package ru.otus.homework.homeworkpatterns


fun main() {
    val textView = TextView()
    println("В текствью сейчас такой текст: ${textView.getText()}")
    textView.add("Привет")
    println("В текствью сейчас такой текст: ${textView.getText()}")
    textView.add(" мир!")
    println("В текствью сейчас такой текст: ${textView.getText()}")
}

class TextView {
    private var text: String = ""
    private var history: List<Command> = emptyList()
    private var historyPointer = 0
    fun getText(): String {
        return text
    }

    private fun addCommand(command: Command) {
        history = history.subList(0, historyPointer) + command.apply { execute() }
        historyPointer++
    }


    fun add(textToAdd: String): TextView = apply {
        addCommand(AddText(textToAdd))
    }
    private inner class AddText(private val textToAdd: String) : Command {
        override fun execute() {
            text += textToAdd
        }

        override fun undo() {
            text = text.replace(textToAdd, "")
        }

    }

    interface Command {
        fun execute()
        fun undo()
    }

    fun undo():
            TextView = apply {
        history.getOrNull(--historyPointer)?.undo()
    }
    fun redo():
            TextView = apply {
        history.getOrNull(historyPointer++)?.execute()
    }
}



