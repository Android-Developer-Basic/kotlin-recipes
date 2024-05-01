package ru.otus.homework.patterns

import kotlin.random.Random

fun main() {
    val rover = MoonRover("Луноход-1")
    val luna1 = MoonStation(rover)
    luna1.run {
        moveRover(10, 20)
        moveRover(-10, -20)
        stopRover()
        getTelemetry()
        makeMeasurements()
        getTelemetry()
    }
    luna1.printLog()

    println()
    RoverJoystick(rover).move(100, 200).move(-10, 0).stop()
}

// луноход
class MoonRover(val name: String) {
    private var x = 0
    private var y = 0
    private val telemetry = mutableMapOf<String, String?>("воздух" to null, "радиация" to null)

    fun move(dX: Int, dY: Int): String {
        x += dX
        y += dY
        return "переместился в ($x,$y)"
    }

    fun stop() = "остановился"

    fun temperature() {
        telemetry["воздух"] = "${Random.nextInt(-100, 100)}"
    }

    fun radiation() {
        telemetry["радиация"] = "как обычно"
    }

    fun getTelemetry() = telemetry.map { "{${it.key}:${it.value?:"нет данных"}}" }.joinToString("")
}

class RoverJoystick(private val rover: MoonRover) {
    init {
        println("Включили джойстик для ${rover.name}")
    }
    fun move(dX: Int, dY: Int): RoverJoystick = apply {
        println(MoveRover(rover, dX, dY).exec())
    }

    fun stop(): RoverJoystick = apply {
        println(StopRover(rover).exec())
    }
}

// станция
class MoonStation(private val rover: MoonRover) {

    private val log = mutableListOf<String>()

    init {
        log.add("Станция управляет луноходом \"${rover.name}\"")
    }

    fun printLog() = println(log.joinToString("\n"))

    private fun execCommand(command: ICommand) {
        log.add(command.exec())
    }

    fun moveRover(dX: Int, dY: Int) {
        execCommand(MoveRover(rover, dX, dY))
    }

    fun stopRover() {
        execCommand(StopRover(rover))
    }

    fun getTelemetry() {
        execCommand(GetTelemetry(rover))
    }

    fun makeMeasurements() {
        execCommand(MakeMeasurements(rover))
    }
}

// Команды лунохода

interface ICommand {
    fun exec(): String
}

abstract class RoverCommand(val rover: MoonRover) : ICommand {
    abstract override fun exec(): String
}

class MoveRover(rover: MoonRover, private val dX: Int, private val dY: Int) : RoverCommand(rover) {
    override fun exec() = rover.move(dX, dY)
}

class StopRover(rover: MoonRover) : RoverCommand(rover) {
    override fun exec() = rover.stop()
}

class GetTelemetry(rover: MoonRover) : RoverCommand(rover) {
    override fun exec() = "за бортом: ${rover.getTelemetry()}"
}

class MakeMeasurements(rover: MoonRover) : RoverCommand(rover) {
    override fun exec() = rover.run {
        temperature()
        radiation()
        "проведены измерения"
    }
}

