package ex1.repository.oder

import ex1.model.oders.Order

class OderRepository(private val orders: MutableList<Order>) {
    fun createOder(order: Order) = orders.add(order)

    fun updateOrder(order: Order): Boolean {
        val index = orders.indexOfFirst { it.id == order.id }
        return if (index != -1) {
            orders[index] = order
            true
        } else {
            false
        }
    }

    fun deleteOrder(id: Int): Boolean {
        return orders.removeIf { it.id == id }
    }

    fun getAllOder(): List<Order> = orders

    fun findById(id: Int): Order? = orders.find { it.id == id }
}