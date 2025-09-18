package ex1.extensions

import ex1.model.Official

abstract class Service<T : Official>(protected val listOfficial: List<T>) {
    fun printHello() = println("Hello")

    abstract fun getAllData()

    abstract fun maxSalary()
}
