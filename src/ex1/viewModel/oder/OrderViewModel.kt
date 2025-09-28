package ex1.viewModel.oder

import ex1.model.oders.Order
import ex1.repository.oder.OrderRepository
import ex1.service.handler.orders.OrderHandler

class OrderViewModel(
    private val orderRepository: OrderRepository,
    private val handler: OrderHandler,
) {
    fun createOrder(): Order {
        val inputOrder = handler.createOrder()
        val order = Order(
            inputOrder.id,
            inputOrder.person,
            inputOrder.food,
            inputOrder.drink,
            inputOrder.date,
            inputOrder.price
        )
        return orderRepository.createOder(order)
    }

    fun getAllOrder(): List<Order> = orderRepository.getAllOder()

}
