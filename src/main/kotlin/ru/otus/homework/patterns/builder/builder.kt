package ru.otus.homework.patterns.builder

fun main(){
    val trash= Trash.Builder()
        .randomBuild()

    println(trash)
}