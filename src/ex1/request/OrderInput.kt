package ex1.request

import ex1.model.oders.Drink
import ex1.model.oders.Food
import ex1.model.person.Official
import java.time.LocalDate

data class OrderInput (
    val id: Int,
    val person: Official,
    val food: Food,
    val drink: Drink,
    val date: LocalDate,
    val price: Double?,
)