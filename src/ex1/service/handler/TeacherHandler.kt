package ex1.service.handler

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.interfaces.CheckValid
import ex1.request.TeacherInput
import ex1.utils.Valid
import java.util.*

class TeacherHandler(private val scanner: Scanner) {
    val checkValid: CheckValid = Valid()
    val inputTeacher = EnInAndOut.INPUT_TEACHER
    fun createTeacher(): TeacherInput {
        val subject = checkValid.checkValidString(scanner, inputTeacher.format(EnType.SUBJECT.value))
        val level = checkValid.checkInputLevel(scanner)
        val experienced = checkValid.checkValidInt(scanner, inputTeacher.format(EnType.EXPERIENCE.value))

        return TeacherInput(subject, level, experienced)
    }
}

