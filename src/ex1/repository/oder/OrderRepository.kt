package ex1.repository.oder

import ex1.messages.Message
import ex1.model.oders.Order

class OrderRepository(private val orders: MutableList<Order>) {

    companion object {
        val allIDSavedOrder = mutableSetOf<Int>()
    }

    fun createOder(order: Order): Order {
        orders.add(order)
        println(Message.CREATE_SUCCESS)
        return order
    }

    fun addRandomOrders(randomOrders: List<Order>) {
        randomOrders.forEach { order ->
            if (!allIDSavedOrder.contains(order.id)) {
                orders.add(order)
                allIDSavedOrder.add(order.id)
            } else {
                println(Message.ID_EXITED)
            }
        }
    }

    fun getAllOder(): List<Order> = orders

}