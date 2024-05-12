package ru.otus.homework.homework6

// это шаблон проектирования, который гарантирует, что у класса есть только один экземпляр
// и предоставляет глобальную точку доступа к этому экземпляру.
object Singleton {
    init {
        println("Экземпляр Singleton инициализирован")
    }

    fun doSomething() {
        println("Синглтон что-то делает")
    }
}

fun main() {
    Singleton.doSomething() // вывод: Экземпляр Singleton инициализирован, Singleton что-то делает
}