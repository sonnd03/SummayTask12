package ex1.interfaces

import java.text.ParseException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

interface CheckValid {
    fun checkValidString(scanner: Scanner, message: String): String {
        while (true) {
            print(message)
            val input: String
            val checkInput = scanner.nextLine()
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

    fun checkValidDate(scanner: Scanner, message: String): LocalDate {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy")
        var dateCheck: LocalDate? = null

        while (dateCheck == null) {
            print("Input Year of Birth Official (dd/MM/yyyy): ")
            val inputDate = scanner.nextLine()
            try {
                dateCheck = LocalDate.parse(inputDate, dateTimeFormatter)
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
            }
            try {
                return intCheck.toInt()
            } catch (e: NumberFormatException) {
                println("Please input type Int!($e): ")
            }
        }
    }

    fun selectType(scanner: Scanner): String {
        while (true) {
            println("1: Staff or 2: Teacher")
            print("Input type: ")
            val type = scanner.nextLine()
            when (type) {
                "1", "2" -> return type
                else -> println("Please input 1 or 2")
            }
        }
    }
}