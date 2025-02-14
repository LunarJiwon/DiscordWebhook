package io.github.lunarjiwon

import java.awt.Color
import java.time.ZonedDateTime
import java.util.*

class DiscordEmbedBuilder() {
    private var title:String? = null
    private var description:String? = null
    private var url:String? = null
    private var color:Color? = null

    private var footer: DiscordEmbed.Footer? = null
    private var thumbnail: DiscordEmbed.Thumbnail? = null
    private var image: DiscordEmbed.Image? = null
    private var author: DiscordEmbed.Author? = null
    private var timeStamp:ZonedDateTime? = null
    private var fields = ArrayList<DiscordEmbed.Field>()

    fun setTitle(title:String): DiscordEmbedBuilder {
        this.title = title
        return this
    }

    fun setDescription(description:String): DiscordEmbedBuilder {
        this.description = description
        return this
    }

    fun setColor(color:Color): DiscordEmbedBuilder {
        this.color = color
        return this
    }

    fun setFooter(footer: DiscordEmbed.Footer): DiscordEmbedBuilder {
        this.footer = footer
        return this
    }

    fun setThumbnail(thumbnail: DiscordEmbed.Thumbnail): DiscordEmbedBuilder {
        this.thumbnail = thumbnail
        return this
    }

    fun setImage(image: DiscordEmbed.Image): DiscordEmbedBuilder {
        this.image = image
        return this
    }

    fun setAuthor(author: DiscordEmbed.Author): DiscordEmbedBuilder {
        this.author = author
        return this
    }

    fun setTimeStamp(timeStamp:ZonedDateTime): DiscordEmbedBuilder {
        this.timeStamp = timeStamp
        return this
    }

    fun setFields(fields: ArrayList<DiscordEmbed.Field>): DiscordEmbedBuilder {
        this.fields
        return this
    }

    fun addField(field: DiscordEmbed.Field): DiscordEmbedBuilder {
        this.fields.add(field)
        return this
    }

    fun build(): DiscordEmbed {
        return DiscordEmbed(
            title = title,
            description = description,
            url = url,
            color = color,
            footer = footer,
            thumbnail = thumbnail,
            image = image,
            author = author,
            timeStamp = timeStamp,
            fields = fields
        )
    }

}