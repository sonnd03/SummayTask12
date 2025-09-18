package ex1.dataClass

import ex1.interfaces.CheckValid
import java.time.LocalDate
import java.util.*

open class Official(
    internal var idOFC: String,
    var nameOFC: String,
    var yearOfBirthOFC: LocalDate,
    var salaryOFC: Double
) : CheckValid {
    companion object {
        private var auto = 0
    }

    open fun input(scanner: Scanner) {
        val tempName = checkValidString(scanner, "Input name Official: ")
        val tempYear = checkValidDate(scanner, "Input year of birth: ")
        val tempSalary = checkValidDouble(scanner, "Input salary Official: ")

        auto++
        idOFC = "OFC$auto"
        nameOFC = tempName
        yearOfBirthOFC = tempYear
        salaryOFC = tempSalary
    }

    open fun payment(): Double = 0.0
}