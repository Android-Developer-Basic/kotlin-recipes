package ru.otus.homework.patterns

fun main() {
    val multimediaSystem = MultimediaSystem()
    val playCommand = PlayCommand(multimediaSystem)
    val pauseCommand = PauseCommand(multimediaSystem)
    val remoteControlPlay = RemoteControl(playCommand)
    val remoteControlPause = RemoteControl(pauseCommand)
    remoteControlPlay.pressButton()
    remoteControlPause.pressButton()
}
interface Command {
    fun execute()
}
class PlayCommand(private val multimediaSystem: MultimediaSystem) : Command {
    override fun execute() {
        multimediaSystem.play()
    }
}
class PauseCommand(private val multimediaSystem: MultimediaSystem) : Command {
    override fun execute() {
        multimediaSystem.pause()
    }
}
class MultimediaSystem {
    fun play() {
        println("Playing multimedia")
    }
    fun pause() {
        println("Pausing multimedia")
    }
}
// Step 3: Define the invoker
class RemoteControl(private val command: Command) {
    fun pressButton() {
        command.execute()
    }
}