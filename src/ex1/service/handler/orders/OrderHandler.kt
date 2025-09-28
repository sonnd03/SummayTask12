package ex1.service.handler.orders

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.messages.Message
import ex1.model.oders.Drink
import ex1.model.oders.Food
import ex1.model.person.Official
import ex1.repository.oder.OrderRepository
import ex1.request.OrderInput
import ex1.utils.CheckValid
import ex1.utils.Valid
import ex1.viewModel.person.OfficialViewModel
import java.util.*


class OrderHandler(
    private val scanner: Scanner,
    private val officialViewModel: OfficialViewModel,
) {
    private val checkValid: CheckValid = Valid()
    private val inputStaff = EnInAndOut.INPUT_ORDER
    private val inputOfficial = EnInAndOut.INPUT_OFFICIAL

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

    fun String.capitalizeWords(): String =
        this.trim()
            .lowercase()
            .split(" ")
            .joinToString(" ") { word ->
                word.replaceFirstChar { it.uppercase() }
            }


    private fun <T> chooseFromMenu(
        message: String,
        prompt: String,
        data: List<T>,
        getName: (T) -> String,
    ): T {
        while (true) {
            println(message)
            val nameInput = checkValid.checkValidString(scanner, inputOfficial.format(prompt))
            val formattedName = nameInput.trim()
                .lowercase()
                .replaceFirstChar { it.uppercase() }

            val item = data.find { getName(it) == formattedName }
            if (item == null) {
                println(Message.NOT_FIND)
            } else {
                return item
            }
        }
    }

    fun createOrder(): OrderInput {
        var id: Int
        while (true) {
            id = checkValid.checkValidInt(scanner, inputStaff.format("ID"))
            if (OrderRepository.allIDSavedOrder.contains(id)) {
                println(Message.ID_EXITED)
            } else {
                OrderRepository.allIDSavedOrder.add(id)
                break
            }
        }
        var person: Official
        while (true) {
            val idPerson = checkValid.checkValidString(scanner, inputOfficial.format("ID Official"))
            val personCheck = officialViewModel.findByIdOfficial(idPerson)
            if (personCheck == null) {
                println(Message.ID_NOT_FOUND)
            } else {
                person = personCheck
                break
            }
        }

        val food = chooseFromMenu("Option: Com, Pho, Bun !", "Name Food", foods) { it.nameFood }
        val drink = chooseFromMenu("Option: Tea, Cafe, Milk !", "Name Drink", drinks) { it.nameDrink }

        val date = checkValid.checkValidDate(scanner, inputOfficial.format(EnType.YEAR.value))

        val price = food.priceFood + drink.priceDrink

        return OrderInput(id, person, food, drink, date, price)
    }
}

