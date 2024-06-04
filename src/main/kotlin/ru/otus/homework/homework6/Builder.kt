package ru.otus.homework.homework6

/*
Builder в Kotlin - это порождающий паттерн проектирования, который используется для создания объектов с сложными конструкторами
или с большим количеством необязательных параметров. Этот паттерн позволяет создавать объекты шаг за шагом,
настраивая их параметры по мере необходимости и упрощая процесс их создания.

Builder позволяет разделить процесс создания объекта на несколько шагов, каждый из которых добавляет определенные свойства
или настройки. Это делает код более читаемым, понятным и позволяет избежать длинных списков параметров у конструктора.

В языке Kotlin часто используется паттерн Builder вместе с паттерном Data class,
который позволяет легко создавать неизменяемые данных.

Использование Builder позволяет создавать объекты с различными комбинациями параметров,
делая код более гибким и удобным для использования.
 */

fun main() {
    // создание экземпляра Builder и последовательное вызов его методов для установки значений свойств `type`, `sugar` и `size`,
    // а затем вызов метода `build()` для создания объекта `Coffee`.
    val coffee1 : Coffee11 = CoffeeBuilder()
        .setType("Tea")
        .setSize("Small")
        .build()

    val coffee2 : Coffee11 = CoffeeBuilder()
        .setType("Americano")
        .setSize("Middle")
        .addMilk()
        .build()

    val coffee3 : Coffee11 = CoffeeBuilder()
        .setType("Latte")
        .setSize("Big")
        .addMilk()
        .addSugar()
        .build()

    println(coffee1)
    println(coffee2)
    println(coffee3)
}

// объявление data класса `Coffee` со свойствами `type`, `milk`, `sugar` и `size`.
data class Coffee11(
    val type: String,
    val milk: Boolean,
    val sugar: Boolean,
    val size: String
)

// объявление класса `CoffeeBuilder`, который будет использоваться для создания объектов класса `Coffee` шаг за шагом.
class CoffeeBuilder() {
    var type: String = ""
    var milk: Boolean = false
    var sugar: Boolean = false
    var size: String = ""

    // объявление функции `setType`, которая устанавливает значение переменной `type` и возвращает текущий объект `Builder`
    fun setType(value: String): CoffeeBuilder {
        this.type = value
        return this
    }

    // объявление функции `addMilk`, которая устанавливает значение переменной `milk` в `true` и возвращает текущий объект `Builder`.
    fun addMilk(): CoffeeBuilder {
        this.milk = true
        return this
    }

    // объявление функции `addSugar`, которая устанавливает значение переменной `sugar` в `true` и возвращает текущий объект `Builder`.
    fun addSugar(): CoffeeBuilder {
        this.sugar = true
        return this
    }

    // объявление функции `setSize`, которая устанавливает значение переменной `size` и возвращает текущий объект `Builder`
    fun setSize(value: String): CoffeeBuilder {
        this.size = value
        return this
    }

    // объявление функции `build`, которая создает и возвращает объект класса `Coffee` на основе текущих значений переменных в `Builder`.
    fun build(): Coffee11 {
        return Coffee11(
            type = type,
            milk = milk,
            sugar = sugar,
            size = size
        )
    }
}
