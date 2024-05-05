package ru.otus.homework.patterns

fun main() {
    val lamp = Lamp ()
    val switchOnCommand = SwitchOnCommand(lamp)
    val switchOffCommand = SwitchOffCommand(lamp)
    val remoteControlOn = RemoteControl(switchOnCommand)
    val remoteControlOff = RemoteControl(switchOffCommand)
    remoteControlOn.pressButton()
    remoteControlOff.pressButton()
}

interface Command {
    fun execute ()
}

class Lamp {
    fun switchOn() {
        println ("Да будет свет!")
    }

    fun switchOff() {
        println ("Темнота")
    }
}

class SwitchOnCommand (private val lamp: Lamp): Command {
    override fun execute() {
        lamp.switchOn()
    }
}

class SwitchOffCommand (private val lamp: Lamp): Command {
    override fun execute() {
        lamp.switchOff()
    }
}

class RemoteControl (private val command: Command) {
    fun pressButton () {
        command.execute()
    }
}