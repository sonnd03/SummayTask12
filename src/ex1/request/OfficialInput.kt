package ex1.request

import java.time.LocalDate

data class OfficialInput(
    val id: String,
    val name: String,
    val year: LocalDate,
    val salary: Double
)
