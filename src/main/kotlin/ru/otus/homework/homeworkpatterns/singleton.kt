package ru.otus.homework.homeworkpatterns


class ScreenManager private constructor() {
    companion object {
        private val instance = ScreenManager()

        fun getInstance(): ScreenManager {
            return instance
        }
    }

    fun showScreen(screen: Screen) {
        println(with(screen) {
            "Отображаю экран со следующими данными: \n" +
                    "screenId - $screenId \n" +
                    "screenName - $screenName \n" +
                    "resource - $resource"
        })
    }

    fun transition() {
        println("--------------------------------")
    }
}

class Screen(val screenId: Int, val screenName: String, val resource: String) {
}

fun main() {

    val onboardingScreen : Screen = Screen(1,
        "onboarding",
        "res/layout/onboarding.xml")
    val mainScreen : Screen = Screen(2,
        "main",
        "res/layout/main.xml")
    val authScreen : Screen = Screen(3,
        "auth",
        "res/layout/auth.xml")

    val screenManager = ScreenManager.getInstance()

    screenManager.showScreen(onboardingScreen)
    screenManager.transition()
    screenManager.showScreen(mainScreen)
    screenManager.transition()
    screenManager.showScreen(authScreen)
    screenManager.transition()




}
