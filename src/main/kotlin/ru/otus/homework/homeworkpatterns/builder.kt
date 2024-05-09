package ru.otus.homework.homeworkpatterns

data class User(val name: String, val age: Int, val email: String) {
    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var email: String = ""

        fun setName(name: String) {
            this.name = name
        }

        fun setAge(age: Int) {
            this.age = age
        }

        fun setEmail(email: String) {
            this.email = email
        }

        override fun toString(): String {
            return "User(name=$name, age=$age, email=$email)"
        }
    }
}

fun main() {
    val user = User.Builder().apply {
        setName("Alice")
        setAge(30)
        setEmail("alice@example.com")
    }

    println(user)
}