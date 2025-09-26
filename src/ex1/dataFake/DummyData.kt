package ex1.dataFake

import ex1.model.oders.Drink
import ex1.model.oders.Food
import ex1.model.oders.Order
import ex1.model.person.Staff
import ex1.model.person.Teacher
import ex1.utils.TypeLevel
import java.time.LocalDate
import kotlin.random.Random

object DummyData {
    val staff = Staff("S01", "Son", LocalDate.of(2003, 2, 18), 2000000.0, "security", 5000.0)
    val teacher = Teacher("S02", "Hug", LocalDate.of(2000, 5, 10), 5000000.0, "math", TypeLevel.DOCTORATE, 2)

    val foods = listOf(
        Food("Com", 100.0),
        Food("Pho", 80.0),
        Food("Bun", 120.0)
    )

    val drinks = listOf(
        Drink("Hoa Qua", 50.0),
        Drink("Cafe", 45.0),
        Drink("Tra", 30.0)
    )

    fun randomDate(startYear: Int = 1890, endYear: Int = 2025): LocalDate {
        val start = LocalDate.of(startYear, 1, 1)
        val end = LocalDate.of(endYear, 12, 31)

        val days = end.toEpochDay() - start.toEpochDay()
        val randomDay = Random.nextLong(days + 1)

        return start.plusDays(randomDay)
    }

    val orders: List<Order> = List(100) { index ->
        val food = foods[index % foods.size]
        val drink = drinks[index % drinks.size]
        val order = Order(
            id = index + 1,
            person = staff,
            food = food,
            drink = drink,
            date = randomDate(),
            price = null
        )
        order.copy(price = food.priceFood + drink.priceDrink)
    }
}