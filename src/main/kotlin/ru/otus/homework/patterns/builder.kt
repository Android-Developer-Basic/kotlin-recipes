package ru.otus.homework.patterns

import java.awt.Color

fun main(){
    val configuration:Configuration = ConfigurationBuilder()
        .dpi(800)
        .build()
}
data class Configuration(
    val latency: Int,
    val userColor: Color,
    val dpi: Int
)

class ConfigurationBuilder() {
    var latency = 300
    var userColor = Color.GREEN
    var dpi = 1600

    fun dpi(value: Int): ConfigurationBuilder {
        this.dpi
        return this
    }

    fun latency(value: Int): ConfigurationBuilder {
        this.latency
        return this
    }

    fun userColor(value: Int): ConfigurationBuilder {
        this.userColor
        return this
    }

    fun build(): Configuration = Configuration(latency, userColor, dpi)

}