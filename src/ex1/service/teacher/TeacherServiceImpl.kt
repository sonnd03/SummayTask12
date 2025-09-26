package ex1.service.teacher

import ex1.messages.GetData
import ex1.model.person.Teacher
import ex1.repository.person.teacher.TeacherRepository

class TeacherServiceImpl(private val teacherRepository: TeacherRepository) : TeacherBusinessService {
    val dataTeacher = teacherRepository.getAll()
    val getData = GetData()

    private fun printTeacher(list: List<Teacher>, header: String) {
        println(header)
        list.forEach { getData.getData(it) }
    }

    override fun highestExperience(): List<Teacher> {
        val maxExp = dataTeacher.maxOfOrNull { it.experienced } ?: return emptyList()
        return dataTeacher.filter { it.experienced == maxExp }
    }

    override fun getAllData() {
        printTeacher(dataTeacher, "\n== All Data Teacher==")
    }

    override fun maxSalary() {
        val maxPayment = dataTeacher.maxOf { it.payment() }
        printTeacher(dataTeacher.filter { it.payment() == maxPayment }, "\n=== List Data Teacher max Payment ===")
    }

    override fun groupByLevel(): Map<String, List<Teacher>> {
        return dataTeacher.groupBy { it.level.name }
    }

    override fun printGroupedByLevel() {
        val grouped = groupByLevel()
        grouped.forEach { (level, teachers) ->
            printTeacher(teachers, "\n=== Level: $level ===")
        }
    }

    override fun advancedFilter(subject: String?, minPayment: Double?, level: String?): List<Teacher> {
        return dataTeacher.filter { teacher ->
            val bySubject = teacherRepository.findBySubject(subject)
            val byPayment = minPayment?.let { teacher.payment() >= it } ?: true
            val byLevel = level?.let { teacher.level.name.equals(it, ignoreCase = true) } ?: true
            bySubject && byPayment && byLevel
        }
    }
}