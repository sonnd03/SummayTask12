package ex1.objects

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.model.Official
import ex1.model.Staff
import ex1.model.Teacher

object GetData {
    fun getData(official: Official) {
        println("\n${EnInAndOut.OUTPUT_OFFICIAL.format(EnType.ID.value, "Teacher")}${official.idOFC}")
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.NAME.value, "Teacher") + official.nameOFC)
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.YEAR.value, "Teacher") + official.yearOfBirthOFC)
        println(EnInAndOut.OUTPUT_OFFICIAL.format(EnType.SALARY.value, "Teacher") + official.salaryOFC)
        when (official) {
            is Staff -> {
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.TITLE.value, "Teacher") + official.title)
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.ALLOWANCE.value, "Teacher") + official.allowance)
                println(EnInAndOut.OUTPUT_STAFF.format(EnType.PAYMENT.value, "Teacher") + official.payment())
            }

            is Teacher -> {
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.SUBJECT.value, "Teacher") + official.subject)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.LEVEL.value, "Teacher") + official.level.type)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.EXPERIENCE.value, "Teacher") + official.experienced)
                println(EnInAndOut.OUTPUT_TEACHER.format(EnType.PAYMENT.value, "Teacher") + official.payment())
            }
        }
    }

    fun dumpData(official: List<Official>): Pair<MutableList<Staff>, MutableList<Teacher>> {
        val listStaff = official.filterIsInstance<Staff>().toMutableList()
        val listTeacher = official.filterIsInstance<Teacher>().toMutableList()
        return Pair(listStaff, listTeacher)
    }

}