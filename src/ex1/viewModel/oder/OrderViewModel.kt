package ex1.viewModel.oder

import ex1.model.oders.Order
import ex1.repository.oder.OderRepository
import ex1.service.oder.OrderService

class OrderViewModel(
    private val oderRepository: OderRepository,
) {
    private val oderService = OrderService(oderRepository)

    fun addOrder(order: Order) {
        oderRepository.add(order)
    }

    fun getAllOrders(): List<Order> =
        oderService.getAllOrders()

    fun sumPrice(order: Order): Double =
        oderService.calculatePrice(order)

    fun getMostExpensiveOrder(): Order? =
        oderRepository.getAll().maxByOrNull { it.sumPrice() }

    fun findById(id: Int): Order? =
        oderService.findById(id)
}
