package ex1.dataClass

import java.sql.Date
import java.util.*

class Staff(
    idOFC: String,
    nameOFC: String,
    yearOfBirthOFC: Date,
    salaryOFC: Double,
    var title: String,
    var allowance: Double
) : Official(idOFC, nameOFC, yearOfBirthOFC, salaryOFC) {
    override fun input(scanner: Scanner) {
        super.input(scanner)

        title = checkValidString(scanner, "Input title Staff: ")
        allowance = checkValidDouble(scanner, "Input allowance: ")
    }

    override fun payment(): Double {
        return salaryOFC * 1000000 + allowance
    }
}