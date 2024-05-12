package ru.otus.homework.homeworkpatterns

class User private constructor(val name: String?, val age: Int?, val email: String?) {
    override fun toString(): String {
        return "User(name=$name, age=$age, email=$email)"
    }
    data class Builder(
        var name: String? = null,
        var age: Int? = null,
        var email: String? = null
    )
    {
        fun name (name: String) = apply {this.name = name}
        fun age (age: Int) = apply {this.age = age}
        fun email (email: String) = apply {this.email = email}

        fun build() = User(name, age, email)


    }
}

fun main() {
    // Я сильно запутался и решил взять просто как пример код в сайта
    // https://www.baeldung.com/kotlin/builder-pattern
    val user = User.Builder().name("John").age(30).email("john@mail.ru").build()
    println(user)
    // А вот так теперь не работает
    //val user1 = User("Alexey", 16, "alex@mail.ru")

}