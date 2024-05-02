package ru.otus.homework.patterns.decorator

class Glasses(private val cloth: Cloth? =null):Cloth {
    override fun equip() {
        cloth?.equip()
        println("Одели очки")
    }
}