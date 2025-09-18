package ex1.objects

import ex1.dataClass.Official
import ex1.dataClass.Staff
import ex1.dataClass.Teacher
import ex1.enumMessage.EnInAndOut
import ex1.enumMessage.EnType

object GetData {
    fun getData(official: Official) {
        println("\n${EnInAndOut.OUTPUT_OFFICIAL.format(EnType.ID.value)}${official.idOFC}")
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.NAME.value) + official.nameOFC)
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.YEAR.value) + official.yearOfBirthOFC)
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.SALARY.value) + official.salaryOFC)
        when (official) {
            is Staff -> {
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.TITLE.value) + official.title)
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.ALLOWANCE.value) + official.allowance)
            }

            is Teacher -> {
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.SUBJECT.value) + official.subject)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.LEVEL.value) + official.level)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.EXPERIENCE.value) + official.experienced)
            }
        }
    }

    fun getDataStaff(staff: List<Staff>) {
        staff.forEach {
            println("\n${EnInAndOut.OUTPUT_OFFICIAL.format(EnType.ID.value)}${it.idOFC}")
            println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.NAME.value) + it.nameOFC)
            println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.YEAR.value) + it.yearOfBirthOFC)
            println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.SALARY.value) + it.salaryOFC)
            println(EnInAndOut.OUTPUT_STAFF.format(EnType.TITLE.value) + it.title)
            println(EnInAndOut.OUTPUT_STAFF.format(EnType.ALLOWANCE.value) + it.allowance)
        }
    }

    fun getDataTeacher(teacher: List<Teacher>) {
        teacher.forEach {
            println("\n${EnInAndOut.OUTPUT_OFFICIAL.format(EnType.ID.value)}${it.idOFC}")
            println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.NAME.value) + it.nameOFC)
            println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.YEAR.value) + it.yearOfBirthOFC)
            println(EnInAndOut.OUTPUT_TEACHER.format(EnType.SUBJECT.value) + it.subject)
            println(EnInAndOut.OUTPUT_TEACHER.format(EnType.LEVEL.value) + it.level)
            println(EnInAndOut.OUTPUT_TEACHER.format(EnType.EXPERIENCE.value) + it.experienced)
        }
    }

    fun dumpData(official: List<Official>): Pair<List<Staff>, List<Teacher>> {
        val listStaff = official.filterIsInstance<Staff>()
        val listTeacher = official.filterIsInstance<Teacher>()
        return Pair(listStaff, listTeacher)
    }
}