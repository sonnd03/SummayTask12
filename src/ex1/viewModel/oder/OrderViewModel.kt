package ex1.viewModel.oder

import ex1.model.oders.Order
import ex1.repository.oder.OderRepository
import ex1.service.oder.OrderService

class OrderViewModel(
    private val orderRepository: OderRepository,
) {
    private val oderService = OrderService(orderRepository)

    fun addOrder(order: Order) {
        orderRepository.createOder(order)
    }

    fun updateOrder(order: Order): Boolean {
        return orderRepository.updateOrder(order)
    }

    fun deleteOrder(id: Int): Boolean {
        return orderRepository.deleteOrder(id)
    }

    fun getAllOrders(): List<Order> =
        oderService.getAllOrders()

    fun findById(id: Int): Order? =
        oderService.findById(id)

    fun sumPrice(order: Order): Double =
        oderService.calculatePrice(order)

    fun getMostExpensiveOrder(): Order? =
        orderRepository.getAllOder().maxByOrNull { it.sumPrice() }


}
