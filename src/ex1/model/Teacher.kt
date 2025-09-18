package ex1.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

class Teacher(
    idOFC: String,
    nameOFC: String,
    yearOfBirthOFC: LocalDate,
    salaryOFC: Double,
    var subject: String,
    var level: TypeLevel,
    var experienced: Int,
) : Official(idOFC, nameOFC, yearOfBirthOFC, salaryOFC) {
    override fun payment(): Double {
        var sumPayment = salaryOFC * 2000000 * (130 + experienced)
        sumPayment += level.bonus
        return BigDecimal(sumPayment).setScale(3, RoundingMode.HALF_UP).toDouble()
    }
}