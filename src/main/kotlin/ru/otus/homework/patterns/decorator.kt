package ru.otus.homework.patterns


fun main() {
    val simpleCoffee: Coffee = SimpleCoffee()
    println("Cost: ${simpleCoffee.cost()}, Description: ${simpleCoffee.description()}")

    val coffeeWithMilk: Coffee = MilkDecorator(SimpleCoffee())
    println("Cost: ${coffeeWithMilk.cost()}, Description: ${coffeeWithMilk.description()}")
}

interface Coffee {
    fun cost(): Double
    fun description(): String
}

class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 1.0
    }

    override fun description(): String {
        return "Simple coffee"
    }
}

open class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun cost(): Double {
        return decoratedCoffee.cost()
    }

    override fun description(): String {
        return decoratedCoffee.description()
    }
}

class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.5
    }

    override fun description(): String {
        return super.description() + ", with milk"
    }
}