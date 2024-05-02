package ru.otus.homework.patterns.decorator

fun main(){
    Glasses(Tshort(Pants())).equip()
}

