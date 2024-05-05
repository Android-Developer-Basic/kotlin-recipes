package ru.otus.homework.patterns

fun main (){
    val icecream = Caramel(Berries(Chocolate(BaseIceCream()))).decorate()
    println(icecream)
}

interface IceCream {
    fun decorate (): String
}

class BaseIceCream: IceCream {
    override fun decorate () = "Ice Cream"
}

abstract class IceCreamDecorator (private  val icecream: IceCream): IceCream {
    override fun decorate(): String {
        return icecream.decorate()
    }
}

class Chocolate (icecream: IceCream): IceCreamDecorator(icecream){
    override fun decorate(): String {
        return super.decorate() + decorateWithChocolate()
    }

    private fun decorateWithChocolate ():String {
        return " with chocolate"
    }
}

class Berries (icecream: IceCream): IceCreamDecorator(icecream){
    override fun decorate(): String {
        return super.decorate() + decorateWithBerries()
    }

    private fun decorateWithBerries ():String {
        return " with berries"
    }
}

class Caramel (icecream: IceCream): IceCreamDecorator(icecream){
    override fun decorate(): String {
        return super.decorate() + decorateWithCaramel()
    }

    private fun decorateWithCaramel ():String {
        return " with caramel"
    }
}