package ex1.repository.person

abstract class RepositoryPerson<T>(protected val data: MutableList<T>) {
    open fun getAll(): List<T> = data

    companion object {
        val allIDSaved = mutableSetOf<String>()
    }
}