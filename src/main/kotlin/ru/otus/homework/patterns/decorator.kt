package ru.otus.homework.patterns

fun main() {
    var coffee: Coffee = SimpleCoffee()
    println("${coffee.cost()} ${coffee.getDescription()}")
    coffee = Milk(coffee)
    println("${coffee.cost()} ${coffee.getDescription()}")
    coffee = Sugar(coffee)
    println("${coffee.cost()} ${coffee.getDescription()}")
}

interface Coffee {
    fun cost(): Double
    fun getDescription(): String
}

class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 3.5
    }

    override fun getDescription(): String {
        return "Простой кофе"
    }

}

abstract class CoffeeDecorator(private val decoratorCoffee: Coffee) : Coffee {
    override fun cost(): Double {
        return decoratorCoffee.cost()
    }

    override fun getDescription(): String {
        return decoratorCoffee.getDescription()
    }
}

class Milk(decoratorCoffee: Coffee) : CoffeeDecorator(decoratorCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.5
    }

    override fun getDescription(): String {
        return super.getDescription() + " c молоком"
    }
}

class Sugar(decoratorCoffee: Coffee) : CoffeeDecorator(decoratorCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.2
    }

    override fun getDescription(): String {
        return super.getDescription() + " и сахором"
    }
}


