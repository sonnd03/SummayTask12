package ex1.repository

abstract class Repository<T>(protected val data: MutableList<T>) {
    open fun getAll(): List<T> = data
    open fun add(item: T) = data.add(item)
    open fun remove(item: T) = data.remove(item)

//    abstract fun getAllData()
//    abstract fun maxSalary()
}