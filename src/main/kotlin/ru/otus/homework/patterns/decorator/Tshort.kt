package ru.otus.homework.patterns.decorator

class Tshort(private val cloth: Cloth? = null):Cloth {
    override fun equip() {
        cloth?.equip()
        println("Одели штаны")
    }
}