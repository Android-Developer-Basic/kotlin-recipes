package ru.otus.homework.homework6

/*
Decorator в Kotlin - это структурный шаблон проектирования, который позволяет добавлять новое поведение
или функциональность объекту, не изменяя его самого.
Этот шаблон позволяет динамически наделять объект новыми возможностями,
оборачивая его в специальные объекты-декораторы, которые добавляют дополнительное поведение.

Decorator является альтернативой наследованию, так как позволяет добавлять новые возможности не меняя исходный класс,
а лишь оборачивая его в декоратор.
Это делает код более гибким, позволяет изменять поведение объекта во время выполнения программы
и следовать принципу открытости/закрытости.

Decorator часто используется в GUI библиотеках для добавления декоративных элементов (например, рамки, тени, текстуры)
 к элементам интерфейса, не изменяя оригинальные объекты.
*/

// Базовый класс Coffee
interface Coffee {
    fun cost(): Int
    fun description(): String
}

// Реализация базового класса Coffee
class SimpleCoffee: Coffee {
    override fun cost(): Int {
        return 5
    }

    override fun description(): String {
        return "Simple Coffee"
    }
}

// Декоратор - добавляет сахар
class Sugar(val coffee: Coffee) : Coffee {
    override fun cost(): Int {
        return coffee.cost() + 1
    }

    override fun description(): String {
        return coffee.description() + ", Sugar"
    }
}

// Декоратор - добавляет молоко
class Milk(val coffee: Coffee) : Coffee {
    override fun cost(): Int {
        return coffee.cost() + 2
    }

    override fun description(): String {
        return coffee.description() + ", Milk"
    }
}

fun main() {
    val simpleCoffee: Coffee = SimpleCoffee()
    println("Cost: ${simpleCoffee.cost()}") // Cost: 5
    println("Description: ${simpleCoffee.description()}") // Description: Simple Coffee

    val coffeeWithSugar: Coffee = Sugar(simpleCoffee)
    println("Cost: ${coffeeWithSugar.cost()}") // Cost: 6
    println("Description: ${coffeeWithSugar.description()}") // Description: Simple Coffee, Sugar

    val coffeeWithMilk: Coffee = Milk(simpleCoffee)
    println("Cost: ${coffeeWithMilk.cost()}") // Cost: 7
    println("Description: ${coffeeWithMilk.description()}") // Description: Simple Coffee, Milk

    val coffeeWithMilkWithSugar: Coffee = Sugar(Milk(simpleCoffee))
    println("Cost: ${coffeeWithMilkWithSugar.cost()}") // Cost: 7
    println("Description: ${coffeeWithMilkWithSugar.description()}") // Description: Simple Coffee, Milk

    val coffeeWithMilkWithDoubleSugar: Coffee = Sugar(Sugar(Milk(simpleCoffee)))
    println("Cost: ${coffeeWithMilkWithDoubleSugar.cost()}") // Cost: 7
    println("Description: ${coffeeWithMilkWithDoubleSugar.description()}") // Description: Simple Coffee, Milk
}