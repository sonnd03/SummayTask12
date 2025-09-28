package ex1.factory

import ex1.dataFake.DummyData
import ex1.enumClass.EnInAndOut
import ex1.messages.GetData
import ex1.messages.Message
import ex1.model.oders.Order
import ex1.model.person.Official
import ex1.repository.oder.OrderRepository
import ex1.repository.person.OfficialRepository
import ex1.repository.person.StaffRepository
import ex1.repository.person.TeacherRepository
import ex1.service.handler.orders.OrderHandler
import ex1.service.handler.persons.OfficialHandler
import ex1.service.handler.persons.StaffHandler
import ex1.service.handler.persons.TeacherHandler
import ex1.service.staff.StaffServiceImpl
import ex1.service.teacher.TeacherServiceImpl
import ex1.utils.CheckValid
import ex1.utils.Valid
import ex1.viewModel.oder.OrderViewModel
import ex1.viewModel.person.OfficialViewModel
import ex1.viewModel.person.StaffViewModel
import ex1.viewModel.person.TeacherViewModel
import java.util.*

class PersonCreateFactory(private val scanner: Scanner) {
    private val checkValid: CheckValid = Valid()
    private val getDat = GetData()

    private val staffRepository = StaffRepository(mutableListOf())
    private val officialRepository = OfficialRepository(mutableListOf())
    private val teacherRepository = TeacherRepository(mutableListOf())
    private val orderRepository = OrderRepository(mutableListOf())

    private val staffHandler = StaffHandler(scanner)
    private val teacherHandler = TeacherHandler(scanner)
    private val officialHandler = OfficialHandler(scanner)

    private val officialMode = OfficialViewModel(officialRepository, officialHandler)
    private val staffViewModel = StaffViewModel(staffRepository, staffHandler, officialMode)
    private val teacherViewModel = TeacherViewModel(teacherRepository, teacherHandler, officialMode)

    private val orderHandler = OrderHandler(scanner, officialMode)
    private val orderViewModel = OrderViewModel(orderRepository, orderHandler)


    val serviceStaff = StaffServiceImpl(staffRepository)
    val serviceTeacher = TeacherServiceImpl(teacherRepository)

    fun createPersons(): List<Official> {
        println()
        val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity Person"))
        val listOfficial = mutableListOf<Official>()

        for (i in 1..n) {
            println("\nInput type Official is stt: $i")
            val type = checkValid.selectType(scanner, "Staff", "Teacher")
            val official = typePerson(type)
            listOfficial.add(official)
        }
        return listOfficial
    }

    private fun typePerson(type: String): Official {
        return when (type) {
            "1" -> staffViewModel.createStaff()
            "2" -> teacherViewModel.createTeacher()
            else -> throw IllegalArgumentException("Invalid type: $type")
        }
    }

    fun deletePerson() {
        if (ensureHasPersons()) {
            val type = checkValid.selectType(scanner, "Delete Staff", "Delete Teacher")
            print("Input id: ")
            val id = scanner.nextLine()
            when (type) {
                "1" -> staffViewModel.deleteStaff(id)
                    .also { if (it) println("Delete success Staff has id: $id") else println("Delete Fail") }

                "2" -> teacherViewModel.deleteTeacher(id)
                    .also { if (it) println("Delete success Teacher has id: $id") else println("Delete Fail") }
            }
        } else {
            return
        }
    }

    fun updatePerson() {
        if (ensureHasPersons()) {
            val type = checkValid.selectType(scanner, "Update Staff", "Update Teacher")
            when (type) {
                "1" -> staffViewModel.updateStaff()
                "2" -> teacherViewModel.updateTeacher()
            }
        } else {
            return
        }
    }

    fun getAllPersons() {
        val data = staffViewModel.getAllStaff() + teacherViewModel.getAllTeacher()
        println("\n=== Staff Age is between ===" + "\n" + data.forEach { getDat.getData(it) })
    }

    fun ensureHasPersons(): Boolean {
        if (officialRepository.getAllOfficial().isEmpty()) {
            println(Message.NOT_PERSON)
            return false
        }
        return true
    }

    fun createOrder(): List<Order> {
        println()
        val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity Order"))
        val listOrder = mutableListOf<Order>()

        for (i in 1..n) {
            println("\nInput type Official is stt: $i")
            val order = orderViewModel.createOrder()
            listOrder.add(order)
        }
        return listOrder
    }

    fun createOrderRandom() {
        if (!ensureHasPersons()) {
            return
        }
        val randomOrders = DummyData(staffViewModel, teacherViewModel).orders
        orderRepository.addRandomOrders(randomOrders)
        println(Message.CREATE_SUCCESS)
    }

    fun getAllOrders() {
        val data = orderRepository.getAllOder()
        if (data.isEmpty()) {
            println("No orders found")
        } else {
            println("\n=== All Orders ===")
            data.forEach { order ->
                println("Order ID: ${order.id}, Person: ${"Id: " + order.person.idOFC + "Name: " + order.person.nameOFC}, Food: ${order.food}, Drink: ${order.drink}, Date: ${order.date}, Price: ${order.price}")
            }

        }
    }
}
