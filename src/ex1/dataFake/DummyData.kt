package ex1.dataFake

import ex1.model.oders.Drink
import ex1.model.oders.Food
import ex1.model.oders.Order
import ex1.viewModel.person.StaffViewModel
import ex1.viewModel.person.TeacherViewModel
import java.time.LocalDate
import kotlin.random.Random

class DummyData(staffViewModel: StaffViewModel, teacherViewModel: TeacherViewModel) {

    val foods = listOf(
        Food("Com", 100.0),
        Food("Pho", 80.0),
        Food("Bun", 120.0)
    )

    val drinks = listOf(
        Drink("Tea", 50.0),
        Drink("Cafe", 45.0),
        Drink("Milk", 30.0)
    )

    fun randomDate(startYear: Int = 1890, endYear: Int = 2025): LocalDate {
        val start = LocalDate.of(startYear, 1, 1)
        val end = LocalDate.of(endYear, 12, 31)
        val days = end.toEpochDay() - start.toEpochDay()
        val randomDay = Random.nextLong(days + 1)
        return start.plusDays(randomDay)
    }

    private val persons = staffViewModel.getAllStaff() + teacherViewModel.getAllTeacher()

    val orders: List<Order> = List(100) { index ->
        val food = foods.random()
        val drink = drinks.random()
        val person = persons.random()
        val order = Order(
            id = index + 1,
            person = person,
            food = food,
            drink = drink,
            date = randomDate(),
            price = null
        )
        order.copy(price = food.priceFood + drink.priceDrink)
    }
}