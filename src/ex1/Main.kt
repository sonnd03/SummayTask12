package ex1

import ex1.factory.PersonCreateFactory
import ex1.messages.GetData
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val factory = PersonCreateFactory(scanner)
    val getData = GetData()

    val officials = factory.createPersons()

    println("\nDanh sách Officials vừa nhập:")
    officials.forEach { official ->
        getData.getData(official)   // in đẹp thông tin từng Official
    }


//    val checkValid: CheckValid = Valid()
//    val officialService = OfficialService()
//    val staffService = StaffService()
//    val teacherService = TeacherService()
//    val getData = GetData()
//
//    val scanner = Scanner(System.`in`)
//    val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity"))
//    val listOfficial = mutableListOf<Official>()
//
//    for (i in 1..n) {
//        println("\nInput type Official is stt: $i")
//        val type = checkValid.selectType(scanner, "Staff", "Teacher")
//
//        val official = CreateData.createOfficial(type, scanner)
//        listOfficial.add(official)
//    }
//    val (listStaff, listTeacher) = getData.dumpData(listOfficial)
//
//    val staffRepository = StaffRepository(listStaff)
//    val teacherRepository = TeacherRepository(listTeacher)
//
//    val staffServiceImpl = StaffServiceImpl(staffRepository)
//    val teacherServiceImpl = TeacherServiceImpl(teacherRepository)
//
//    officialService.getAll()
//    staffService.getAll()
//    teacherService.getAll()
//
//    staffServiceImpl.getAllData()
//    staffServiceImpl.printStaffSecurity()
//    staffServiceImpl.maxSalary()
//    staffServiceImpl.printTop3Payment(3)
//    staffServiceImpl.printStaffByAge(12, 20)
//    staffServiceImpl.printStaffGroupedByTitle()
//
//
//    teacherServiceImpl.getAllData()
//    teacherServiceImpl.highestExperience()
//    teacherServiceImpl.groupByLevel()
//    teacherServiceImpl.printGroupedByLevel()
//    teacherServiceImpl.advancedFilter("math", null, "Associate")
//
//    println("Do you want choose option ?")
//    val typeOption = checkValid.selectType(scanner, "Update", "Delete")
//    OptionHandler.startOption(typeOption, scanner, listOfficial, listStaff, listTeacher)
//    officialService.getAll()
//
//    val repository = OderRepository(DummyData.orders.toMutableList())
//    val viewModel = OrderViewModel(repository)
//
//    DummyData.orders.forEach { viewModel.addOrder(it) }
//
//    val allOrders = viewModel.getAllOrders()
//
//    allOrders.forEach { println(it) }
//
//    val mostExpensiveOrder = viewModel.getMostExpensiveOrder()
//    println("Order maxPrice: $mostExpensiveOrder")
//
//    val firstOrder = viewModel.getAllOrders().first()
//    val totalPrice = viewModel.sumPrice(firstOrder)
//    println("Sum price order ${firstOrder.id}: $totalPrice")
//
//    val idToFind = 10
//    val orderById = viewModel.findById(idToFind)
//    if (orderById != null) {
//        println("${Message.ID_EXITED}=$idToFind: $orderById")
//    } else {
//        println("${Message.ID_NOT_FOUND}=$idToFind !")
//
//    }
}


