package ex1.dataClass

import ex1.interfaces.CheckValid
import java.sql.Date
import java.util.Scanner

open class Official(
    protected var idOFC: String,
    var nameOFC: String,
    var yearOfBirthOFC: Date,
    var salaryOFC: Double
) : CheckValid {
    companion object {
        private var auto = 0
    }

    open fun input(scanner: Scanner) {
        auto++
        idOFC = "OFC$auto"
        nameOFC = checkValidString(scanner, "Input name Official: ")
        yearOfBirthOFC = checkValidDate(scanner, "Input year of birth: ")
        salaryOFC = checkValidDouble(scanner, "Input salary Official: ")
    }

    open fun payment(): Double = 0.0
}