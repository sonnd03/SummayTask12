package ex1.objects

import ex1.dataClass.Official
import ex1.dataClass.Staff
import ex1.dataClass.Teacher
import ex1.interfaces.CheckValid
import java.time.LocalDate
import java.util.*

object Return : CheckValid {
    fun createOfficial(type: String, scanner: Scanner): Official {
        val currentDate = LocalDate.now()
        return when (type) {
            "1" -> Staff("", "", currentDate, 0.0, "", 0.0).apply { input(scanner) }
            "2" -> Teacher("", "", currentDate, 0.0, "", "", 0).apply { input(scanner) }
            else -> throw IllegalArgumentException("Invalid type: $type")
        }
    }

    fun getData(official: Official) {
        println("\nidOFC: ${official.idOFC}")
        println("nameOFC: ${official.nameOFC}")
        println("yearOfBirthOFC: ${official.yearOfBirthOFC}")
        println("salaryOFC: ${official.salaryOFC}")
        when (official) {
            is Staff -> {
                println("title Staff: ${official.title}")
                println("allowance Staff: ${official.allowance}")
            }

            is Teacher -> {
                println("subject Teacher: ${official.subject}")
                println("level Teacher: ${official.level}")
                println("experienced Teacher: ${official.experienced}")
            }
        }
    }

    fun dumpData(official: List<Official>): Pair<List<Staff>, List<Teacher>> {
        val listStaff = official.filterIsInstance<Staff>()
        val listTeacher = official.filterIsInstance<Teacher>()
        return Pair(listStaff, listTeacher)
    }
}