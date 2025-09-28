package ex1.service.oder

import ex1.model.oders.Order
import ex1.repository.oder.OrderRepository
import ex1.viewModel.oder.OrderViewModel

class OrderService(private val orderViewModel: OrderViewModel) {
    fun getAllOrders(): List<Order> {
        return orderViewModel.getAllOrder()
    }

}

