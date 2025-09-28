package ex1.model.oders

import ex1.model.person.Official
import java.time.LocalDate

data class Order(
    val id: Int,
    val person: Official,
    val food: Food,
    val drink: Drink,
    val date: LocalDate,
    val price: Double?,
) : BaseOrder() {
    constructor(id: Int, person: Official, nameFood: Food, nameDrink: Drink, date: LocalDate) : this(
        id,
        person,
        nameFood,
        nameDrink,
        date,
        null
    )

    override fun sumPrice(): Double {
        return food.priceFood + drink.priceDrink
    }

}
