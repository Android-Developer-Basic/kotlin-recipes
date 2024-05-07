fun main() {

    val order = mutableListOf<Product>()
    order.add(Headset(Iphone()))
    order.add(Charger(Headset(Iphone())))

    order.forEach {
        println("${it.getName()} - ${it.getPrice()}")
    }
}

interface Product {
    fun getName(): String
    fun getPrice(): Double
}

open class Iphone : Product {
    override fun getName(): String = "iphone"
    override fun getPrice(): Double = 10000.0
}

class Headset(private val item: Product) : Product {
    override fun getName(): String = item.getName() + " + headset"
    override fun getPrice(): Double = item.getPrice() + 1000.0
}

class Charger(private val item: Product) : Product {
    override fun getName(): String = item.getName() + " + charger"
    override fun getPrice(): Double = item.getPrice() + 500.0
}
