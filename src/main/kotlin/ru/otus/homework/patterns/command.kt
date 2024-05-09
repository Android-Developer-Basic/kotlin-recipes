package ru.otus.homework.patterns



fun main(){
    val tv = Television()
    val remote = RemoteControll()

    val turnOnCommamd = TurnOnCommand(tv)
    val turnOffCommand = TurnOffCommand(tv)

    remote.pressButton(turnOnCommamd)
    remote.setCommand(turnOffCommand)
}

interface Command {
    fun execute()
}

class TurnOnCommand(private val tv:Television):Command {
    override fun execute() {
        tv.turnOn()
    }

}

class TurnOffCommand(private val tv: Television):Command {
    override fun execute() {
        tv.turnOff()
    }

}

class Television {
    fun turnOn() {
        println(" Телевизор включен ")
    }

    fun turnOff() {
        println(" Телевизор выключен ")
    }
}

class RemoteControll {
    var command: Command? = null
    fun setCommand(command: Command){
        this.command = command
    }
    fun pressButton(command: Command){
        command?.execute()
    }
}