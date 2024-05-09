package ru.otus.homework.homeworkpatterns


fun main() {
    val textView = TextViewText()
    println("В текствью сейчас такой текст: ${textView.getText()}")
    textView.add("Привет")
    println("В текствью сейчас такой текст: ${textView.getText()}")
    textView.add(" мир!")
    println("В текствью сейчас такой текст: ${textView.getText()}")


}

class TextViewText {
    private var text: String = ""
    fun getText(): String {
        return text
    }

    fun add(textToAdd: String): TextViewText = apply {
        AddText(textToAdd).execute()
    }
    private inner class AddText(private val textToAdd: String) {
        fun execute() {
            text += textToAdd
        }
    }
}



