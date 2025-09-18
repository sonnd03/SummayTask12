package ex1

import ex1.enumClass.EnInAndOut
import ex1.extensions.OfficialService
import ex1.extensions.OptionHandler
import ex1.extensions.StaffService
import ex1.extensions.TeacherService
import ex1.interfaces.CheckValid
import ex1.model.Official
import ex1.objects.GetData
import ex1.repository.CreateData
import ex1.utils.Valid
import java.util.*

fun main() {
    val checkValid: CheckValid = Valid()

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

    val officialService = OfficialService(listOfficial)
    val staffService = StaffService(listStaff)
    val teacherService = TeacherService(listTeacher)

    officialService.getAllData()

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
    officialService.getAllData()
}


