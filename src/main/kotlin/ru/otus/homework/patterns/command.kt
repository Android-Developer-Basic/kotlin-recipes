package ru.otus.homework.patterns

fun main() {
    val drink = "Wine"
    val food = "Pizza and Burger"
    val customer = Customer("Kotya")

    val barOrder = BarWaiter(customer, drink)
    customer.makeOrder(barOrder)
    customer.getOrder(barOrder)

    println()

    val tableOrder = DiningWaiter(customer, food)
    customer.makeOrder(tableOrder)
    customer.getOrder(tableOrder)
}

interface Waiter {
    fun receive()
    fun deliver()
}

data class BarWaiter(private val customer: Customer, private val order: String) : Waiter {
    override fun receive() {
        println("$customer ordered $order from bar.")
        Chef.makeFood(order)
    }

    override fun deliver() {
        println("$customer got $order from bar waiter.")
    }
}

data class DiningWaiter(private val customer: Customer, private val order: String) : Waiter {
    override fun receive() {
        println("$customer ordered $order from dining table.")
        Chef.makeFood(order)
    }

    override fun deliver() {
        println("$customer got $order from dining table waiter.")
    }
}

class Customer(private val name: String) {
    fun makeOrder(waiter: Waiter) {
        waiter.receive()
    }

    fun getOrder(waiter: Waiter) {
        waiter.deliver()
    }

    override fun toString(): String {
        return name
    }
}

object Chef {
    fun makeFood(order: String) {
        println("$order: ready to serve!")
    }
}