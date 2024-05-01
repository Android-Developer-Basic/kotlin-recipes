package ru.otus.homework.patterns

fun main() {
    val painter = Painter("Очень Известный Художник")
    painter.drawPortrait("Девушка с веслом", "Иванова Маша")
    painter.drawSketch("Летящие гуси")
    painter.draw("Фантазия", "надпись", "запотевшее стекло") {
        it.setColors("прозрачный цвет").setBrushes("палец")
    }

    println("${painter.name} нарисовал: ${painter.pictures.joinToString("\n", "\n") { "$it" }}\n")

    val pict1 = PictureBuilder("Мишка на юге", "пейзаж", "холст")
        .setPaintKind("сложная техника")
        .setSubject("Медведь Гризли в кустах")
        .setColors("зеленая", "черная", "бeлая", "желтая")
        .setAeroColors("красная", "синяя")
        .setBrushes("кисточка", "губка", "валик", "мелок")
        .prepare(120, 80, true)
        .draw()
}

// картина
class Picture(
    val name: String,
    val author: String,
    val type: String,
    val surface: String,
    val paintKind: String?,
    val subject: String?,
    val decoration: String?, // оформление (например рамка)
) {
    override fun toString() =
        "\"$name\", $type, $surface${paintKind?.let { ", $it" } ?: ""}${decoration?.let { ", $it" } ?: ""}.${subject?.let { " Изображено: $it." } ?: ""}"

}

// создание картины
class PictureBuilder(
    private val name: String,
    private val type: String,
    private val surface: String
) {
    private var colors = mutableSetOf<IColor>()
    private var brushes = mutableSetOf<String>()
    private var paintKind: String? = null // способ рисования
    private var subject: String? = null  // что рисуем
    private var decoration: String? = null

    // что рисуем
    fun setSubject(subject: String?): PictureBuilder = apply {
        this.subject = subject
    }

    // способ рисования
    fun setPaintKind(paintKind: String): PictureBuilder = apply {
        this.paintKind = paintKind
    }

    // чем рисуем (кисти и т.п.)
    fun setBrushes(vararg brushes: String): PictureBuilder = apply {
        this.brushes.addAll(brushes)
    }

    // используемые цвета
    fun setColors(vararg colors: String): PictureBuilder = apply {
        println("Берем краски: ${colors.joinToString(", ") { it }}")
        this.colors.addAll(colors.map { Color(it) })
    }

    fun setAeroColors(vararg colors: String): PictureBuilder = apply {
        println("Берем краски в баллончиках: ${colors.joinToString(", ") { it }}")
        this.colors.addAll(colors.map { AeroColor(Color(it)) })
    }

    // оформление (размер, рамка)
    fun prepare(width: Int, height: Int, hasFrame: Boolean): PictureBuilder = apply {
        decoration = "$width на $height ${if (hasFrame) "в раме" else "без рамы"}"
        println("Подготавливаем $surface $decoration")
    }

    fun draw(painter: Painter? = null): Picture {
        val author = painter?.name ?: "Неизвестный художник"
        if (colors.isEmpty() || brushes.isEmpty())
            throw Exception("$author хотел нарисовать, да нечем!")

        println("Рисуем картину, используем: ${brushes.joinToString(", ")}, ${colors.joinToString(", ")}")

        return Picture(name, author, type, surface, paintKind, subject, decoration)
            .apply {
                painter?.pictures?.add(this)
                println("$author нарисовал картину $this\n")
            }
    }
}

// художник
class Painter(val name: String) {
    val pictures = mutableSetOf<Picture>()
    val brushes = mutableSetOf("кисточка тонкая", "кисточка толстая")
    val colors = mutableListOf("черная", "белая", "все цвета радуги")

    // рисует портрет маслом на холсте
    fun drawPortrait(name: String, subject: String) = PictureBuilder(name, "портрет", "холст")
        .setPaintKind("масло")
        .setSubject(subject)
        .setColors(*colors.toTypedArray())
        .setBrushes(*brushes.toTypedArray())
        .prepare(40, 60, true)
        .draw(this)

    // рисует эскиз в альбоме
    fun drawSketch(name: String, subject: String? = null) = PictureBuilder(name, "эскиз", "альбом")
        .setSubject(subject)
        .setColors("черная")
        .setBrushes("карандаш", "уголь")
        .draw(this)

    // рисует
    fun draw(name: String, type: String, surface: String, process: (PictureBuilder) -> PictureBuilder) =
        process(PictureBuilder(name, type, surface)).draw(this)

}
