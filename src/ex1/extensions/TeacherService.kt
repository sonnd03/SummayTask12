package ex1.extensions

import ex1.model.Teacher
import ex1.objects.GetData
import java.time.LocalDate

class TeacherService(private val listTeacher: List<Teacher>) : Service<Teacher>(listTeacher) {

    private fun printTeacher(list: List<Teacher>, header: String) {
        println(header)
        list.forEach { GetData.getData(it) }
    }

    fun highestExperience(): List<Teacher> {
        val maxExp = listTeacher.maxOfOrNull { it.experienced } ?: return emptyList()
        return listTeacher.filter { it.experienced == maxExp }
    }

    override fun getAllData() {
        printTeacher(listTeacher, "\n== All Data Teacher==")
    }

    override fun maxSalary() {
        val maxPayment = listTeacher.maxOf { it.payment() }
        printTeacher(listTeacher.filter { it.payment() == maxPayment }, "\n=== List Data Teacher max Payment ===")
    }

    fun groupByLevel(): Map<String, List<Teacher>> {
        return listTeacher.groupBy { it.level.name }
    }

    fun printGroupedByLevel() {
        val grouped = groupByLevel()
        grouped.forEach { (level, teachers) ->
            printTeacher(teachers, "\n=== Level: $level ===")
        }
    }

    fun advancedFilter(subject: String? = null, minPayment: Double? = null, level: String? = null): List<Teacher> {
        return listTeacher.filter { teacher ->
            val bySubject = subject?.let { teacher.subject.equals(it, ignoreCase = true) } ?: true
            val byPayment = minPayment?.let { teacher.payment() >= it } ?: true
            val byLevel = level?.let { teacher.level.name.equals(it, ignoreCase = true) } ?: true
            bySubject && byPayment && byLevel
        }
    }
}