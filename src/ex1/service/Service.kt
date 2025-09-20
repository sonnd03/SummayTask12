package ex1.service

import java.util.Scanner

interface Service<T> {
    fun create(scanner: Scanner): T
    fun edit(id: String, item: T): T
    fun remove(id: String): Boolean
    fun getAll(): List<T>
}
