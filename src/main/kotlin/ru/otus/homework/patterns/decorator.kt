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


class Sugar(private val coffee: Coffee): Coffee {
    override fun cost(): Double {
        return coffee.cost() + 0.3
    }
    override fun getDescription(): String {
        return coffee.getDescription() + " and sugar"
    }

}

class Milk(private val coffee: Coffee): Coffee {
    override fun cost(): Double {
        return coffee.cost() + 0.2
    }

    override fun getDescription(): String {
        return coffee.getDescription() + " milk"
    }
}
//abstract class CoffeeDecorator(private val decoratorCoffee: Coffee) : Coffee {
//    override fun cost(): Double {
//        return decoratorCoffee.cost()
//    }
//
//    override fun getDescription(): String {
//        return decoratorCoffee.getDescription()
//    }
//}


