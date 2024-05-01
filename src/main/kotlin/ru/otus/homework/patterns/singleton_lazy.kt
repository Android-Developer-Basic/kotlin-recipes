package ru.otus.homework.patterns

fun main() {
    // тест класса настроек приложения (синглтон)
    val opt1 = AppOptions.get().apply {
        set(
            mapOf(
                "new option" to "new value",
                "default option1" to "",
            )
        )
    }
    println("opt1: ${opt1.values}")

    val opt2 = AppOptions.get()
    opt2.set("new option", "newest value")
    println("opt2: ${opt2.values}")

    println("op1 === opt2: ${opt1 === opt2}")
    println("op1 == opt2: ${opt1 == opt2}")

    // тест процесса загрузки (синглтон как object, ленивая инициализация)
    val process = MyProcess("процесс загрузки")
    println()
    println(Loader)
    process.start()
    println(Loader)
    process.stop()
    println(Loader)
}

// класс настроек приложения
class AppOptions private constructor(val values: MutableMap<String, String>) {
    companion object {
        private var instance: AppOptions? = null
        fun get(): AppOptions {
            if (instance == null)
                instance = AppOptions(
                    mutableMapOf(
                        "default option1" to "value1",
                        "default option2" to "value2",
                    )
                )
            return instance as AppOptions
        }
    }

    fun set(name: String, value: String) = set(mapOf(name to value))
    fun set(values: Map<String, String>) {
        val opt = get()
        opt.values.putAll(values)
    }
}

// процесс загрузки
class MyProcess(private val name: String) {
    private val loader: Loader by lazy {
        println("инициализация, устанавливаем соединение")
        Loader["last process"] = name
        Loader
    }

    fun start() {
        loader["state"] = "started"
        println("начинаем загрузку")
    }

    fun stop() {
        println("останавливаем загрузку")
        loader["state"] = "stopped"
    }
}

// загрузчик
object Loader {
    private val options = mutableMapOf(
        "state" to "unknown",
        "last process" to ""
    )

    override fun toString() = "состояние загрузчика: $options"

    operator fun get(key: String) = options[key]
    operator fun set(key: String, value: String) {
        options[key] = value
    }
}
