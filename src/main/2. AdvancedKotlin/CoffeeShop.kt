interface Worker {
    val name: String
    var salary: Double
    fun work(): String
}

abstract class BaseWorker(override val name: String, override var salary: Double) : Worker {
    abstract fun performDuties(): String
}

class Barista(name: String, salary: Double) : BaseWorker(name, salary) {
    override fun work(): String {
        return "$name is making coffee."
    }

    override fun performDuties(): String {
        return "Making espresso and cappuccino."
    }
}

class Manager(name: String, salary: Double) : BaseWorker(name, salary) {
    override fun work(): String {
        return "$name is managing the shop."
    }

    override fun performDuties(): String {
        return "Overseeing operations and staff."
    }
}

data class Customer(val name: String, var order: String? = null)

class CoffeeShop(val name: String) {
    private val workers = mutableListOf<BaseWorker>()
    private val customers = mutableListOf<Customer>()

    fun hireWorker(worker: BaseWorker) {
        workers.add(worker)
        println("${worker.name} has been hired.")
    }

    fun serveCustomer(customer: Customer): Boolean {
        customers.add(customer)
        println("Serving ${customer.name} with order ${customer.order}.")
        return true
    }

    fun calculateTotalSalaries(): Double {
        return workers.sumOf { it.salary }
    }
}

fun main() {
    val coffeeShop = CoffeeShop("The Daily Grind")

    val barista = Barista("Alice", 3000.0)
    val manager = Manager("Bob", 5000.0)

    coffeeShop.hireWorker(barista)
    coffeeShop.hireWorker(manager)

    val customer1 = Customer("John", "Latte")
    coffeeShop.serveCustomer(customer1)

    val totalSalaries = coffeeShop.calculateTotalSalaries()
    println("Total salaries of workers in ${coffeeShop.name}: $$totalSalaries")
}