package ex1

import ex1.dataClass.Official
import ex1.extensions.StaffExtension
import ex1.extensions.TeacherExtension
import ex1.objects.Return
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = Return.checkValidInt(scanner, "Input quantity Office: ")
    val listOfficial = mutableListOf<Official>()

    for (i in 1..n) {
        println("\nInput type Official is stt: $i")
        val type = Return.selectType(scanner)
        val official = Return.createOfficial(type, scanner)
        listOfficial.add(official)
    }

    print("\nALL DATA:")
    listOfficial.forEach { Return.getData(it) }

    print("\nDump Data:")
    val (listStaff, listTeacher) = Return.dumpData(listOfficial)
    listStaff.forEach { Return.getData(it) }
    listTeacher.forEach { Return.getData(it) }

    val staffExtension = StaffExtension(listStaff)
    val teacherExtension = TeacherExtension(listTeacher)

    // lấy tên các người làm bảo vệ (security)
    val getSecurity = staffExtension.staffSecurity()
    getSecurity.forEach { println(it.nameOFC) }

//    // lấy các người có năm sinh > 2000 , làm thủ quỹ (treasurer), có phụ cấp > 50000
//    val getFilterStaff = staffExtension.getFilterStaff()
//    getFilterStaff.forEach { println(it) }
    staffExtension.staff.forEach { println(it.nameOFC) }


}