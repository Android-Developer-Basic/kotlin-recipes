package ru.otus.homework.patterns.command

fun main(){
    val dog=Dog()

    dog.execute("sit")
    dog.execute("stand")
    dog.execute("voice")
}