package ru.otus.homework.homework6

import kotlin.concurrent.thread

// это шаблон проектирования, который гарантирует, что у класса есть только один экземпляр
// и предоставляет глобальную точку доступа к этому экземпляру.


fun main() {
    repeat(9999) {
        thread {
            println(Singleton.getSingleton())
        }
    }
}

class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null

        fun getSingleton(): Singleton {
            if (instance == null) {
                //проверка для многопоточного обращения
                synchronized(Singleton::class.java) {
                    if (instance == null) {
                        instance = Singleton()
                    }
                }
            }
            return requireNotNull(instance)
        }
    }
}
