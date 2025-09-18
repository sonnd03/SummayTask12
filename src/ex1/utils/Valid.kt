package ex1.utils

import ex1.enumClass.EnInAndOut
import ex1.interfaces.CheckValid
import ex1.model.TypeLevel
import ex1.objects.Message
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Valid : CheckValid {
    override fun checkValidString(scanner: Scanner, message: String): String {
        while (true) {
            print(message)
            val input: String
            val checkInput = scanner.nextLine()
            input = checkInput
            if (input.isBlank()) {
                println(Message.NOT_NULL)
            } else if (!input.matches(Regex("^[^0-9][a-zA-Z0-9 ]*$"))) {
                println(Message.NOT_INT)
            } else {
                return input
            }
        }
    }

    override fun checkValidDate(scanner: Scanner, message: String): LocalDate {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy")
        var dateCheck: LocalDate? = null

        while (dateCheck == null) {
            print(Message.INPUT_DATE)
            val inputDate = scanner.nextLine()
            try {
                dateCheck = LocalDate.parse(inputDate, dateTimeFormatter)
            } catch (e: Exception) {
                println(Message.FORMAT_DATE + "(message:$e): ")
            }
        }
        return dateCheck
    }

    override fun checkValidDouble(scanner: Scanner, message: String): Double {
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
                println(Message.NOT_STRING + "(message:$e): ")
            }
        }
    }

    override fun checkValidInt(scanner: Scanner, message: String): Int {
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
                println(Message.NOT_STRING + "(message:$e): ")
            }
        }
    }

    override fun selectType(scanner: Scanner, item1: String, item2: String): String {
        while (true) {
            println(EnInAndOut.INPUT_TYPE.format(item1, item2))
            print("Input type: ")
            val type = scanner.nextLine()
            when (type) {
                "1", "2" -> return type
                else -> println("Please input 1 or 2")
            }
        }
    }

    override fun checkInputLevel(scanner: Scanner): TypeLevel {
        while (true) {
            print("Enter level (1=Associate, 2=Bachelor, 3=Master, 4=Doctorate or Other): ")
            val input = scanner.nextLine().trim()

            val level = input.toIntOrNull()?.let { TypeLevel.fromNumber(it) }
                ?: TypeLevel.fromString(input)

            if (level != null) return level
            println("Invalid input. Try again!")
        }
    }


}