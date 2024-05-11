package ru.otus.homework.patterns

fun main() {
    println("Hello, singleton!")
    println("First call:")
    val db1 = Database.getInstance()
    println(db1.data)
    println("Second call:")
    val db2 = Database.getInstance()
    println(db2.data)

    println("db1 === db2: ${db1 === db2}")

    val settings = AppSettings.instance
    println("В данный момент язык приложения ${settings.getLanguage()}")
    println("В данный момент тема приложения ${settings.getTheme()}")
    settings.setLanguage(newlanguage = "Spanish")
    settings.setTheme(newtheme = "Dark")
    println("Теперь язык приложения ${settings.getLanguage()} и тема ${settings.getTheme()} ")
}

class Database private constructor(val data: Map<String, String>) {
    companion object {
        private var instance: Database? = null

        fun getInstance(): Database {
            if (instance == null) {
                println("Initializing database...")
                instance = Database(
                    mapOf(
                        "1" to "One",
                        "2" to "Two",
                        "3" to "Three"
                    )
                )
            }
            return instance!!
        }
    }
}

class AppSettings private constructor() {
    private var language: String = "English"
    private var theme: String = "Light"

    companion object {
        val instance: AppSettings by lazy { AppSettings() }
    }

    fun getLanguage(): String {
        return language
    }

    fun setLanguage(newlanguage: String): String {
        language = newlanguage
        return newlanguage
    }

    fun getTheme(): String {
        return theme
    }

    fun setTheme(newtheme: String): String {
        theme = newtheme
        return newtheme
    }
}