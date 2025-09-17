package ex1.interfaces

import java.sql.Date
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

interface CheckValid {
    //    companion object{
    fun checkValidString(scanner: Scanner, message: String): String {
        while (true) {
            print(message)
            val input: String
            val checkInput = scanner.nextLine().toString()
            input = checkInput
            if (input.isBlank()) {
                println("Pleas input because it's not null!")
            } else if (!input.matches(Regex("^[a-zA-Z ]+$"))) {
                println("Input must not contain numbers or special characters!")
            } else {
                return input
            }
        }
    }

    fun checkValidDate(scanner: Scanner, message: String): Date {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        var dateCheck: Date? = null
        simpleDateFormat.isLenient = false
        while (dateCheck == null) {
            print("Input Year of Birth Official (dd/MM/yyyy): ")
            val inputDate = scanner.nextLine()
            try {
                val parsed = simpleDateFormat.parse(inputDate)
                dateCheck = Date(parsed.time)
            } catch (e: ParseException) {
                println("Format Error! Pleas return Input is format dd/MM/yyyy(message: $e): ")
            }
        }
        return dateCheck
    }

    fun checkValidDouble(scanner: Scanner, message: String): Double {
        while (true) {
            print(message)
            val doubleCheck = scanner.nextLine()
            if (doubleCheck.isNullOrBlank()) {
                println("Please ${message[0].lowercase() + message.substring(1)}")
                continue
            } else {
                println()
            }
            try {
                return doubleCheck.toDouble()
            } catch (e: NumberFormatException) {
                println("Please input type Int!($e): ")
            }
        }
    }

    fun checkValidInt(scanner: Scanner, message: String): Int {
        while (true) {
            print(message)
            val intCheck = scanner.nextLine()
            if (intCheck.isNullOrBlank()) {
                println("Please ${message[0].lowercase() + message.substring(1)}")
                continue
            } else {
                println()
            }
            try {
                return intCheck.toInt()
            } catch (e: NumberFormatException) {
                println("Please input type Int!($e): ")
            }
        }
    }
//    }

}