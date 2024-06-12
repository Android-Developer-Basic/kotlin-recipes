package ru.otus.homework.patterns

fun main() {
    val light = Light()
    val turnOnCommand = TurnOnCommand(light)
    val turnOffCommand = TurnOffCommand(light)
    val remote = RemoteControl()
    remote.setCommand(turnOnCommand)
    remote.pressButton()
    remote.setCommand(turnOffCommand)
    remote.pressButton()
}

class Light {
    fun turnOn() = println("Light is on")
    fun turnOff() = println("Light is off")
}

fun interface Command { fun execute() }

class TurnOnCommand(private val light: Light) : Command {
    override fun execute() { light.turnOn() }
}

class TurnOffCommand(private val light: Light) : Command {
    override fun execute() = light.turnOff()
}

class RemoteControl {
    private var command: Command? = null
    fun setCommand(cmd: Command) { command = cmd }
    fun pressButton() = command?.execute()
}