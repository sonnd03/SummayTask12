package ex1.viewModel.person.after

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.interfaces.CheckValid
import ex1.messages.Message
import ex1.model.person.Official
import ex1.model.person.Staff
import ex1.model.person.Teacher
import ex1.utils.Valid
import java.util.*

object CreateData {
    val checkValid: CheckValid = Valid()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL
    val inputStaff = EnInAndOut.INPUT_STAFF
    val inputTeacher = EnInAndOut.INPUT_TEACHER
    val allIDSaved = mutableSetOf<String>()

    fun createOfficial(scanner: Scanner): Official {
        var id: String
        do {
            id = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
            if (allIDSaved.contains(id)) {
                println(Message.ID_EXITED)
            }
        } while (allIDSaved.contains(id))
        allIDSaved.add(id)
        val name = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value))
        val year = checkValid.checkValidDate(scanner, inputOfficial.format(EnType.YEAR.value))
        val salary = checkValid.checkValidDouble(scanner, inputOfficial.format(EnType.SALARY.value))
        return Official(id, name, year, salary)
    }

    fun createStaff(scanner: Scanner): Staff {
        val official = createOfficial(scanner)
        val title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value))
        val allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value))
        return Staff(official.idOFC, official.nameOFC, official.yearOfBirthOFC, official.salaryOFC, title, allowance)
    }

    fun createTeacher(scanner: Scanner): Teacher {
        val official = createOfficial(scanner)
        val subject = checkValid.checkValidString(scanner, inputTeacher.format(EnType.SUBJECT.value))
        val level = checkValid.checkInputLevel(scanner)
        val experienced = checkValid.checkValidInt(scanner, inputTeacher.format(EnType.EXPERIENCE.value))
        return Teacher(
            official.idOFC,
            official.nameOFC,
            official.yearOfBirthOFC,
            official.salaryOFC,
            subject,
            level,
            experienced
        )
    }

    fun createOfficial(type: String, scanner: Scanner): Official {
        return when (type) {
            "1" -> createStaff(scanner)
            "2" -> createTeacher(scanner)
            else -> throw IllegalArgumentException("Invalid type: $type")
        }
    }
}