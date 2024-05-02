package ru.otus.homework.patterns.builder

class Trash private constructor(
    val food: String?,
    val paper: String?,
    val plastic: String?,
    val glass: String?) {

    data class Builder(
        var food: String? = null,
        var paper: String? = null,
        var plastic: String? = null,
        var glass: String? = null) {

        fun food(bread: String) = apply { this.food = bread }
        fun paper(condiments: String) = apply { this.paper = condiments }
        fun plastic(meat: String) = apply { this.plastic = meat }
        fun glass(fish: String) = apply { this.glass = fish }
        fun build() = Trash(food, paper, plastic, glass)
        fun randomBuild() = food(food ?: "apple")
            .paper(paper ?: "newspaper")
            .plastic(plastic ?: "bottle")
            .glass(glass?: "lamp")
            .build()
    }

    override fun toString(): String {
        return "Trash(food=$food, paper=$paper, plastic=$plastic, glass=$glass)"
    }


}