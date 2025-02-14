package kr.kro.jiwon1300

import java.awt.Color
import java.time.ZonedDateTime
import java.util.*

data class DiscordEmbed(
    val title:String?,
    val description:String?,
    val url:String?,
    val color:Color?,

    val footer: Footer?,
    val thumbnail: Thumbnail?,
    val image: Image?,
    val author: Author?,
    val timeStamp:ZonedDateTime?,
    val fields: ArrayList<Field>?

){
    data class Author(
        val name:String,
        val url:String?,
        val iconURL:String?
    )
    data class Field(
        val name:String,
        val value:String,
        val inline:Boolean
    )
    data class Footer(
        val text:String,
        val iconURL:String
    )
    data class Image (
        val URL:String
    )
    data class Thumbnail (
        val URL:String
    )
}