package ex1.objects

import ex1.dataClass.Official
import ex1.dataClass.Staff
import ex1.dataClass.Teacher
import ex1.enumMessage.EnInAndOut
import ex1.enumMessage.EnType
import ex1.utils.Valid
import java.util.*

//data class EnumInputs(
//    val inputOfficial: EnumInput,
//    val inputStaff: EnumInput,
//    val inputTeacher: EnumInput
//)
//
//fun getInput() = EnumInputs(
//    inputTeacher = EnumInput.INPUT_TEACHER,
//    inputStaff = EnumInput.INPUT_STAFF,
//    inputOfficial = EnumInput.INPUT_OFFICIAL
//)

object CreateData {
    val checkValid = Valid()

    //    val input = getInput()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL
    val inputStaff = EnInAndOut.INPUT_STAFF
    val inputTeacher = EnInAndOut.INPUT_TEACHER

    fun createOfficial(scanner: Scanner): Official {
        val id = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value))
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
        val level = checkValid.checkValidString(scanner, inputTeacher.format(EnType.LEVEL.value))
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
