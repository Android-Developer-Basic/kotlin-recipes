package ru.otus.homework.patterns


fun main() {
    val pine = PineChristmasTree()
    pine.decorate()

    val bubble = BubbleLights(pine)
    bubble.decorate()
}
interface ChristmasTree {
    fun decorate(): String
}

abstract class TreeDecorator
    (private val tree: ChristmasTree) : ChristmasTree {
    override fun decorate(): String {
        return tree.decorate()
    }
}

class PineChristmasTree : ChristmasTree {
    override fun decorate(): String {
        val result = "Christmas tree"
        println(result)
        return result
    }
}

class BubbleLights(tree: ChristmasTree) : TreeDecorator(tree) {
    override fun decorate(): String {
        val result = super.decorate() + decorateWithBubbleLights()
        println(result)
        return result
    }
    private fun decorateWithBubbleLights(): String {
        return " with Bubble Lights"
    }
}