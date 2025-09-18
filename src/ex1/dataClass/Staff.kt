package ex1.dataClass

import java.time.LocalDate

class Staff(
    idOFC: String,
    nameOFC: String,
    yearOfBirthOFC: LocalDate,
    salaryOFC: Double,
    var title: String,
    var allowance: Double
) : Official(idOFC, nameOFC, yearOfBirthOFC, salaryOFC) {
    override fun payment(): Double {
        return salaryOFC * 1000000 + allowance
    }
}