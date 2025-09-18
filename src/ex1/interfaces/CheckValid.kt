package ex1.interfaces

import java.time.LocalDate
import java.util.*

interface CheckValid {
    fun checkValidString(scanner: Scanner, message: String): String

    fun checkValidDate(scanner: Scanner, message: String): LocalDate

    fun checkValidDouble(scanner: Scanner, message: String): Double

    fun checkValidInt(scanner: Scanner, message: String): Int
}