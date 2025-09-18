package ex1.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

class Staff(
    idOFC: String,
    nameOFC: String,
    yearOfBirthOFC: LocalDate,
    salaryOFC: Double,
    var title: String,
    var allowance: Double,
) : Official(idOFC, nameOFC, yearOfBirthOFC, salaryOFC) {
    override fun payment(): Double {
        val sumPayment = salaryOFC * 1000000 + allowance
        return BigDecimal(sumPayment).setScale(3, RoundingMode.HALF_UP).toDouble()
    }
}