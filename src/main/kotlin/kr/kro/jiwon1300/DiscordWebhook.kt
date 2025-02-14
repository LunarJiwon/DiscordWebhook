package kr.kro.jiwon1300

import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.time.format.DateTimeFormatter


class DiscordWebhook(
    private val webhookURL:String,
){
    //
    private val jsonObject = JSONObject()

    private val embedsArray = JSONArray()

    private var content:String? = null

    fun setContent(content: String){
        this.content = content
    }

    fun setEmbed(embed: DiscordEmbed){
        embedsArray.clear()
        embedsArray.put(getJsonFromEmbed(embed))
    }

    fun addEmbed(embed: DiscordEmbed){
        embedsArray.put(getJsonFromEmbed(embed))
    }

    private fun getJsonFromEmbed(embed: DiscordEmbed): JSONObject {
        val embedJson = JSONObject()
        embedJson.put("title",embed.title)
        embedJson.put("description",embed.description)
        if(embed.color != null) embedJson.put("color",
            (embed.color.red shl 16) or (embed.color.green shl 8) or embed.color.blue
        )
        if(embed.url != null) embedJson.put("url",embed.url)
        if(embed.image != null) embedJson.put("image", hashMapOf(
            Pair("url",embed.image.URL)
        ))
        if(embed.thumbnail != null) embedJson.put("thumbnail", hashMapOf(
            Pair("url",embed.thumbnail.URL)
        ))
        if(embed.author != null) embedJson.put("author", hashMapOf(
            Pair("name",embed.author.name),
            Pair("url",embed.author.url),
            Pair("icon_url",embed.author.iconURL)
        ))
        if(embed.fields != null) embedJson.put("fields", embed.fields)
        if(embed.timeStamp != null) embedJson.put("timestamp"
            ,embed.timeStamp.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        return embedJson
    }

    fun execute(): DiscordResponse {
        if(content != null) jsonObject.put("content",content)
        if(!embedsArray.isEmpty) jsonObject.put("embesds",embedsArray)

        val url = URI.create(webhookURL).toURL()
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.doOutput = true
        connection.setRequestProperty("Content-Type","application/json")
        connection.outputStream.use { os ->
            val input: ByteArray = jsonObject.toString().toByteArray()
            os.write(input, 0, input.size)
        }
        var responseCode :Int
        var response : StringBuffer
        try{
            responseCode = connection.responseCode
            val input = BufferedReader(InputStreamReader(connection.inputStream))
            var inputLine: String
            response = StringBuffer()

            while ((input.readLine().also { inputLine = it }) != null) {
                response.append(inputLine)
            }
            input.close()
        }catch (e:IOException){
            response = StringBuffer(e.localizedMessage.split(":")[0])
            responseCode = 400

        }


        return DiscordResponse(responseCode,response.toString())
    }
}