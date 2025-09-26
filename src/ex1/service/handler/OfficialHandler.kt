package ex1.service.handler

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.interfaces.CheckValid
import ex1.request.OfficialInput
import ex1.utils.Valid
import java.util.*

class OfficialHandler(private val scanner: Scanner) {
    val checkValid: CheckValid = Valid()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL

    fun createOfficial(): OfficialInput {
        val id = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
        val name = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value))
        val year = checkValid.checkValidDate(scanner, inputOfficial.format(EnType.YEAR.value))
        val salary = checkValid.checkValidDouble(scanner, inputOfficial.format(EnType.SALARY.value))

        return OfficialInput(id, name, year, salary)
    }

}