package ex1

import ex1.dataFake.DummyData
import ex1.enumClass.EnInAndOut
import ex1.interfaces.CheckValid
import ex1.messages.GetData
import ex1.messages.Message
import ex1.model.person.Official
import ex1.repository.oder.OderRepository
import ex1.repository.person.StaffRepository
import ex1.repository.person.TeacherRepository
import ex1.service.official.OfficialService
import ex1.service.staff.StaffService
import ex1.service.staff.StaffServiceImpl
import ex1.service.teacher.TeacherService
import ex1.service.teacher.TeacherServiceImpl
import ex1.utils.OptionHandler
import ex1.utils.Valid
import ex1.viewModel.oder.OrderViewModel
import ex1.viewModel.person.CreateData
import java.util.*

fun main() {
    val checkValid: CheckValid = Valid()
    val officialService = OfficialService()
    val staffService = StaffService()
    val teacherService = TeacherService()

    val scanner = Scanner(System.`in`)
    val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity"))
    val listOfficial = mutableListOf<Official>()

    for (i in 1..n) {
        println("\nInput type Official is stt: $i")
        val type = checkValid.selectType(scanner, "Staff", "Teacher")

        val official = CreateData.createOfficial(type, scanner)
        listOfficial.add(official)
    }
    val (listStaff, listTeacher) = GetData.dumpData(listOfficial)

    val staffRepository = StaffRepository(listStaff)
    val teacherRepository = TeacherRepository(listTeacher)

    val staffServiceImpl = StaffServiceImpl(staffRepository)
    val teacherServiceImpl = TeacherServiceImpl(teacherRepository)

    officialService.getAll()
    staffService.getAll()
    teacherService.getAll()

    staffServiceImpl.getAllData()
    staffServiceImpl.printStaffSecurity()
    staffServiceImpl.maxSalary()
    staffServiceImpl.printTop3Payment(3)
    staffServiceImpl.printStaffByAge(12, 20)
    staffServiceImpl.printStaffGroupedByTitle()


    teacherServiceImpl.getAllData()
    teacherServiceImpl.highestExperience()
    teacherServiceImpl.groupByLevel()
    teacherServiceImpl.printGroupedByLevel()
    teacherServiceImpl.advancedFilter("math", null, "Associate")

    println("Do you want choose option ?")
    val typeOption = checkValid.selectType(scanner, "Update", "Delete")
    OptionHandler.startOption(typeOption, scanner, listOfficial, listStaff, listTeacher)
    officialService.getAll()

    val repository = OderRepository(DummyData.orders.toMutableList())
    val viewModel = OrderViewModel(repository)

    DummyData.orders.forEach { viewModel.addOrder(it) }

    val allOrders = viewModel.getAllOrders()

    allOrders.forEach { println(it) }

    val mostExpensiveOrder = viewModel.getMostExpensiveOrder()
    println("Order maxPrice: $mostExpensiveOrder")

    val firstOrder = viewModel.getAllOrders().first()
    val totalPrice = viewModel.sumPrice(firstOrder)
    println("Sum price order ${firstOrder.id}: $totalPrice")

    val idToFind = 10
    val orderById = viewModel.findById(idToFind)
    if (orderById != null) {
        println("${Message.ID_EXITED}=$idToFind: $orderById")
    } else {
        println("${Message.ID_NOT_FOUND}=$idToFind !")

    }
}


