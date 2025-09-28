package ex1.service.teacher

import ex1.messages.GetData
import ex1.model.person.Teacher
import ex1.repository.person.TeacherRepository
import ex1.utils.CheckValid
import ex1.utils.Valid
import java.util.*

class TeacherServiceImpl(private val teacherRepository: TeacherRepository) : TeacherBusinessService {
    val getData = GetData()
    val checkValid: CheckValid = Valid()

    private fun printTeacher(list: List<Teacher>, header: String) {
        if (list.isEmpty()) {
            println("List no value")
        } else {
            println(header)
            list.forEach { getData.getData(it) }
        }
    }

    override fun highestExperience(): List<Teacher> {
        val dataTeacher = teacherRepository.getAll()
        val maxExp = dataTeacher.maxOfOrNull { it.experienced } ?: return emptyList()
        return dataTeacher.filter { it.experienced == maxExp }
    }

    override fun maxSalary() {
        val dataTeacher = teacherRepository.getAll()
        val maxPayment = dataTeacher.maxOfOrNull { it.payment() }
        printTeacher(dataTeacher.filter { it.payment() == maxPayment }, "\n=== List Data Teacher max Payment ===")
    }

    override fun groupByLevel() {
        teacherRepository.getAll()
            .groupBy { it.level }
            .forEach { (level, teachers) ->
                printTeacher(teachers, "\n=== Level: $level ===")
            }
    }

    override fun advancedFilter(scanner: Scanner): List<Teacher> {
        val subject: String? = checkValid.checkValidString(scanner, "Enter Start age: ")
        val minPayment: Double? = checkValid.checkValidDouble(scanner, "Enter End age: ")
        val level: String? = checkValid.checkValidString(scanner, "Enter End age: ")
        val dataTeacher = teacherRepository.getAll()
        return dataTeacher.filter { teacher ->
            val bySubject = subject?.let { teacher.subject.equals(it, ignoreCase = true) } ?: true
            val byPayment = minPayment?.let { teacher.payment() >= it } ?: true
            val byLevel = level?.let { teacher.level.name.equals(it, ignoreCase = true) } ?: true
            bySubject && byPayment && byLevel
        }
    }
    
    fun getAllData() = teacherRepository.getAll()
}