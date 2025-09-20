package ex1.messages

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.model.Official
import ex1.model.Staff
import ex1.model.Teacher

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
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.PAYMENT.value) + official.payment())
            }

            is Teacher -> {
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.SUBJECT.value) + official.subject)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.LEVEL.value) + official.level.type)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.EXPERIENCE.value) + official.experienced)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.PAYMENT.value) + official.payment())
            }
        }
    }

    fun dumpData(official: List<Official>): Pair<MutableList<Staff>, MutableList<Teacher>> {
        val listStaff = official.filterIsInstance<Staff>().toMutableList()
        val listTeacher = official.filterIsInstance<Teacher>().toMutableList()
        return Pair(listStaff, listTeacher)
    }

}