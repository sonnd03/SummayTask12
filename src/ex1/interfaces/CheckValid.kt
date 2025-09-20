package ex1.interfaces

import ex1.utils.TypeLevel
import java.time.LocalDate
import java.util.*

interface CheckValid {
    fun checkValidString(scanner: Scanner, message: String): String

    fun checkValidDate(scanner: Scanner, message: String): LocalDate

    fun checkValidDouble(scanner: Scanner, message: String): Double

    fun checkValidInt(scanner: Scanner, message: String): Int

    fun selectType(scanner: Scanner, item1: String, item2: String): String

    fun checkInputLevel(scanner: Scanner): TypeLevel
}