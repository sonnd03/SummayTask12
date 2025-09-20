package ex1.repository.oder

import ex1.dataFake.DummyData
import ex1.model.oders.Order

class OderRepository(private val orders: MutableList<Order>) {
//    private val orders = mutableListOf<Order>().apply {
//        addAll(DummyData.orders)
//    }

    fun add(oder: Order) = orders.add(oder)
    fun getAll(): List<Order> = orders
    fun findById(id: Int): Order? = orders.find { it.id == id }
}