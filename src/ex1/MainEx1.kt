package ex1

import ex1.dataClass.Official
import ex1.dataClass.Staff
import ex1.dataClass.Teacher
import ex1.interfaces.CheckValid.Companion.checkValidInt
import java.sql.Date
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val n = checkValidInt(scanner, "Input quantity Office: ")
    val listOfficial = mutableListOf<Official>()

    for (i in 1..n) {
        println("\nInput type Official is stt$i")
        println("1: Staff or 2: Teacher")
        val currentDate = Date(System.currentTimeMillis())
        var type: String
        do {
            print("Chose type: ")
            type = scanner.nextLine()
            if (type != "1" && type != "2") {
                println("Please input 1 or 2")
            }
        } while (type != "1" && type != "2")
        when (type) {
            "1" -> {
                val staff = Staff("", "", currentDate, 0.0, "", 0.0)
                staff.input(scanner)
                listOfficial.add(staff)
            }

            "2" -> {
                val teacher = Teacher("", "", currentDate, 0.0, "", "", 0)
                teacher.input(scanner)
                listOfficial.add(teacher)
            }
        }
    }

}