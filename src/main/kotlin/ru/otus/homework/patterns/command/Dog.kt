package ru.otus.homework.patterns.command

import java.lang.IllegalStateException

class Dog() {
    private val map: HashMap<String, Command> = HashMap()

    init{
        map["voice"] = VoiceCommand()
        map["stand"] = StandCommand()
        map["sit"] = SitCommand()
    }

    fun execute(command: String){
        if (map.containsKey(command)) {
            map[command]?.execute()
        } else{
            throw IllegalStateException("Command not supported")
        }
    }
}