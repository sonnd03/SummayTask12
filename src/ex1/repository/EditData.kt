package ex1.repository

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.model.Official
import ex1.model.Staff
import ex1.model.Teacher
import ex1.utils.Valid
import java.util.*

object EditData {
    val checkValid = Valid()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL
    val inputStaff = EnInAndOut.INPUT_STAFF
    val inputTeacher = EnInAndOut.INPUT_TEACHER

    fun update(
        scanner: Scanner, id: String,
        listOfficial: MutableList<Official>,
        listStaff: MutableList<Staff>,
        listTeacher: MutableList<Teacher>,
    ) {
        val official = listOfficial.find { it.idOFC.equals(id, ignoreCase = true) }
        if (official != null) {
            println("=== Update information ID: $id ===")
            official.nameOFC = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value, "Teacher"))
            official.yearOfBirthOFC = checkValid.checkValidDate(scanner, inputOfficial.format(
                EnType.YEAR.value,
                "Teacher"
            ))
            official.salaryOFC = checkValid.checkValidDouble(scanner, inputOfficial.format(
                EnType.SALARY.value,
                "Teacher"
            ))

            listStaff.find { it.idOFC.equals(id, ignoreCase = true) }?.apply {
                title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value, "Teacher"))
                allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value, "Teacher"))
            }

            listTeacher.find { it.idOFC.equals(id, ignoreCase = true) }?.apply {
                subject = checkValid.checkValidString(scanner, inputTeacher.format(EnType.SUBJECT.value, "Teacher"))
                level = checkValid.checkInputLevel(scanner)
                experienced = checkValid.checkValidInt(scanner, inputTeacher.format(EnType.EXPERIENCE.value, "Teacher"))
            }

            println("Update success!")
        } else {
            println("Cannot find ID = $id to edit!")
        }
    }
}