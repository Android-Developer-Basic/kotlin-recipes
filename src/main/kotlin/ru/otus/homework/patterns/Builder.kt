package ru.otus.homework.patterns

fun main() {
    val car = Car.Builder()
        .model("Ford Focus")
        .color("Black")
        .type("Type")
        .build()

    println(car.toString())

    val person = Person("","",0)
        .setAge(18)
        .setName("Name")
        .setAddress("Adress")
        .build()

    println(person.toString())
}
class Car(
    val model: String?,
    val color: String?,
    val type: String?) {

    data class Builder(
        var model: String? = null,
        var color: String? = null,
        var type: String? = null) {

        fun model(model: String) = apply { this.model = model }
        fun color(color: String) = apply { this.color = color }
        fun type(type: String) = apply { this.type = type }
        fun build() = Car(model, color, type)
    }

    override fun toString(): String {
        return "$model $color $type"
    }
}

class Person() {

    var name = ""
    var address = ""
    var age = 0

    constructor(_name: String, _address: String, _age: Int) : this() {
        name = _name
        address = _address
        age = _age
    }
    fun setName(name : String) : Person {
        this.name = name
        return this
    }

    fun setAddress(address : String) : Person {
        this.address = address
        return this
    }

    fun setAge(age : Int) : Person {
        this.age = age
        return this
    }

    fun build() : Person {
        return Person(name, address, age)
    }

    override fun toString(): String {
        return "$name $address $age"
    }
}
