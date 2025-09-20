package ex1.service.oder

import ex1.model.oders.Order
import ex1.repository.oder.OderRepository

class OrderService(private val oderRepository: OderRepository) {
    fun calculatePrice(order: Order): Double {
        return order.food.priceFood + order.drink.priceDrink
    }

    fun getAllOrders(): List<Order> {
        return oderRepository.getAll()
    }

    fun findById(id: Int): Order? {
        return oderRepository.findById(id)
    }
}

