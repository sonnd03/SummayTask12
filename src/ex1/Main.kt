package ex1

import ex1.enumClass.EnInAndOut
import ex1.interfaces.CheckValid
import ex1.messages.GetData
import ex1.model.Official
import ex1.repository.staff.StaffRepository
import ex1.repository.teacher.TeacherRepository
import ex1.service.factory.InputFactory
import ex1.service.official.OfficialService
import ex1.service.staff.StaffBusinessService
import ex1.service.staff.StaffServiceImpl
import ex1.service.teacher.TeacherServiceImpl
import ex1.utils.OptionHandler
import ex1.utils.Valid
import java.util.*

fun main() {
    val checkValid: CheckValid = Valid()
    val officialService = OfficialService()

    val scanner = Scanner(System.`in`)
    val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity"))
    val listOfficial = mutableListOf<Official>()

    for (i in 1..n) {
        println("\nInput type Official is stt: $i")
        val type = checkValid.selectType(scanner, "Staff", "Teacher")

        val official = InputFactory.createOfficial(type, scanner)
        listOfficial.add(official)
    }
    val (listStaff, listTeacher) = GetData.dumpData(listOfficial)

    val staffRepository = StaffRepository(listStaff)
    val teacherRepository = TeacherRepository(listTeacher)

    val staffService = StaffServiceImpl(staffRepository)
    val teacherService = TeacherServiceImpl(teacherRepository)

    officialService.getAll()

    staffService.getAllData()
    staffService.printStaffSecurity()
    staffService.maxSalary()
    staffService.printTop3Payment(3)
    staffService.printStaffByAge(12, 20)
    staffService.printStaffGroupedByTitle()

    teacherService.getAllData()
    teacherService.highestExperience()
    teacherService.groupByLevel()
    teacherService.printGroupedByLevel()
    teacherService.advancedFilter("math", null, "Associate")

    println("Do you want choose option ?")
    val typeOption = checkValid.selectType(scanner, "Update", "Delete")
    OptionHandler.startOption(typeOption, scanner, listOfficial, listStaff, listTeacher)
    officialService.getAll()
}


