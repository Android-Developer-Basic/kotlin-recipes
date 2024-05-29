package ru.otus.homework.patterns

fun main() {
    val defaultHouse = House.Builder().build()
    val simpleHouse = House.Builder(1, "Wood").build()
    val customHouse = House.Builder().floors(4).roof("Tiles")
        .rooms(listOf("Kitchen", "Dining room", "Living Room")).build()
    println("1: $defaultHouse\n2: $simpleHouse\n3: $customHouse")
}

class House private constructor(
    private val floors: Int,
    private val roof: String,
    private val rooms: List<String>,
) {
    data class Builder(
        private var floors: Int = 2,
        private var roof: String = "Metal",
        private var rooms: List<String> = listOf("Bathroom, Bedroom, Kitchen"),
    ) {
        fun build(): House = House(floors, roof, rooms)
        fun floors(floors: Int) = apply { this.floors = floors }
        fun roof(roof: String) = apply { this.roof = roof }
        fun rooms(rooms: List<String>) = apply { this.rooms = rooms }
    }

    override fun toString(): String {
        return "House(floors=$floors, roof='$roof', rooms=$rooms)"
    }
}