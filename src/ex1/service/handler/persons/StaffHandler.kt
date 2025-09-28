package ex1.service.handler.persons

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.utils.CheckValid
import ex1.utils.Valid
import java.util.*

class StaffHandler(private val scanner: Scanner) {
    private val checkValid: CheckValid = Valid()
    private val inputStaff = EnInAndOut.INPUT_STAFF

    fun createStaff(): Pair<String, Double> {
        val title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value))
        val allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value))
        return title to allowance
    }

    fun updateStaff(): Pair<String, Double> {
        val title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value))
        val allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value))
        return title to allowance
    }
}
