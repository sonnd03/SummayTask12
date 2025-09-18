package ex1.dataClass

import java.time.LocalDate
import java.util.*

class Teacher(
    idOFC: String,
    nameOFC: String,
    yearOfBirthOFC: LocalDate,
    salaryOFC: Double,
    var subject: String,
    var level: String,
    var experienced: Int
) : Official(idOFC, nameOFC, yearOfBirthOFC, salaryOFC) {
    override fun input(scanner: Scanner) {
        super.input(scanner)

        subject = checkValidString(scanner, "Input subject Staff: ")
        level = checkValidString(scanner, "Input level Staff: ")
        experienced = checkValidInt(scanner, "Input experienced: ")
    }

    override fun payment(): Double {
        var sumSalary = salaryOFC * 2000000 * (130 + experienced)
        sumSalary += when (level.lowercase(Locale.getDefault())) {
            "university" -> 1000000
            "master" -> 3000000
            else -> 5000
        }
        return sumSalary
    }
}