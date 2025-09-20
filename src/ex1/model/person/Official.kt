package ex1.model.person

import java.time.LocalDate

open class Official(
    internal var idOFC: String,
    var nameOFC: String,
    var yearOfBirthOFC: LocalDate,
    var salaryOFC: Double,
) {
    open fun payment(): Double = 0.0
}