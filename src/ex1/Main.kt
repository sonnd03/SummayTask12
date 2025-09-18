package ex1

import ex1.dataClass.Official
import ex1.extensions.StaffExtension
import ex1.extensions.TeacherExtension
import ex1.objects.CreateData
import ex1.objects.GetData
import ex1.utils.Valid
import java.util.*

fun main() {
    val checkValid = Valid()
    val scanner = Scanner(System.`in`)
    val n = checkValid.checkValidInt(scanner, "Input quantity Office: ")
    val listOfficial = mutableListOf<Official>()

    for (i in 1..n) {
        println("\nInput type Official is stt: $i")
        val type = checkValid.selectType(scanner)
        val official = CreateData.createOfficial(type, scanner)
        listOfficial.add(official)
    }

    print("\nALL DATA:")
    listOfficial.forEach { GetData.getData(it) }

    print("\nDump Data:")
    val (listStaff, listTeacher) = GetData.dumpData(listOfficial)
    listStaff.forEach { GetData.getData(it) }

    listTeacher.forEach { GetData.getData(it) }

    val staffExtension = StaffExtension(listStaff)
    val teacherExtension = TeacherExtension(listTeacher)

    // lấy tên các ng làm bảo vệ (security)
    print("\nList Data Staff title Security")
    GetData.getDataStaff(staffExtension.staffSecurity())

    // lấy các ng có năm sinh > 2000 , làm thủ quỹ (treasurer), có phụ cấp > 50000
    print("\nList Data Staff Filter")
    GetData.getDataStaff(staffExtension.getFilterStaff())

    // lấy ra teacher có tiền max
    print("\nList Data Teacher max salary")
    GetData.getDataTeacher(teacherExtension.highestExperience())


}


