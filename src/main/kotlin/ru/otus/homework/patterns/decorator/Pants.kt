package ru.otus.homework.patterns.decorator

class Pants(private val cloth: Cloth? =null): Cloth {
    override fun equip() {
        cloth?.equip()
        println("Надели штаны")
    }
}