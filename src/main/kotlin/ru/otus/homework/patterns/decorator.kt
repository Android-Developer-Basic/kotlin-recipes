package ru.otus.homework.patterns

fun main() {
    val color = Color("красная")
    println(color)
    color.mix()
    val aeroColor = AeroColor(color)
    println(aeroColor)
    aeroColor.run { mix(); push() }
}

interface IColor {
    val name: String
    fun mix()
}

class Color(override val name: String) : IColor {
    override fun mix() {
        println("перемешиваем")
    }

    override fun toString() = "краска $name"
}

class AeroColor(private val base: IColor) : IColor {
    override val name: String
        get() = base.name

    override fun mix() {
        base.mix()
    }

    override fun toString() = "краска в баллончике $name"

    fun push() {
        println("распыляем")
    }
}