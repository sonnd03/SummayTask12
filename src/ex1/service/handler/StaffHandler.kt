package ex1.service.handler

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.interfaces.CheckValid
import ex1.utils.Valid
import java.util.*

//class StaffHandler(private val scanner: Scanner) {
//    val checkValid: CheckValid = Valid()
//    val officialHandler = OfficialHandler(scanner)
//    val inputStaff = EnInAndOut.INPUT_STAFF
//
//    fun createStaff(): Staff {
//        val official = officialHandler.createOfficial()
//        val title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value))
//        val allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value))
//        return Staff(official.idOFC, official.nameOFC, official.yearOfBirthOFC, official.salaryOFC, title, allowance)
//    }
//}
class StaffHandler(private val scanner: Scanner) {
    private val checkValid: CheckValid = Valid()
    private val inputStaff = EnInAndOut.INPUT_STAFF

    fun createStaff(): Pair<String, Double> {
        val title = checkValid.checkValidString(scanner, inputStaff.format(EnType.TITLE.value))
        val allowance = checkValid.checkValidDouble(scanner, inputStaff.format(EnType.ALLOWANCE.value))
        return title to allowance
    }
}
