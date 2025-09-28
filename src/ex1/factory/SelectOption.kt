package ex1.factory

import ex1.messages.Message
import java.util.*

object SelectOption {
    fun selectOption() {
        val scanner = Scanner(System.`in`)
        val factory = PersonCreateFactory(scanner)

        while (true) {
            println(
                """
                |--- Menu ---
                |0. Create Persons
                |1. Get all Persons
                |2. Delete Persons
                |3. Update Persons
                |4. Service Persons
                |5. Exit
                """.trimMargin()
            )
            print("Enter your choice: ")
            val userChoice = scanner.nextLine().trim().toIntOrNull() ?: -1

            when (userChoice) {
                0 -> factory.createPersons()
                1 -> factory.getAllPersons()
                2 -> factory.deletePerson()
                3 -> factory.updatePerson()
                4 -> if (!factory.ensureHasPersons()) {
                    continue
                } else {
                    subMenu(scanner, factory)
                }

                5 -> {
                    println("Exiting...")
                    break
                }

                else -> println("Invalid option. Try again.")
            }
        }
    }

    private fun subMenu(scanner: Scanner, factory: PersonCreateFactory) {
        while (true) {
            println(
                """
                |--- Menu Service Person ---
                |0. Staff Services
                |1. Teacher Services 
                |2. Back to Main Menu
                """.trimMargin()
            )
            print("Enter your choice: ")
            val choice = scanner.nextLine().trim().toIntOrNull() ?: -1

            when (choice) {
                0 -> staffMenu(scanner, factory)
                1 -> teacherMenu(scanner, factory)
                2 -> return

                else -> println("Invalid option. Try again.")
            }
        }
    }

    private fun staffMenu(scanner: Scanner, factory: PersonCreateFactory) {
        while (true) {
            println(
                """
                |--- Menu Staff ---
                |0. MaxSalary
                |1. Staff is Security
                |2. Year > 2000 and Allowance > 5000
                |3. Top 3 is the most Payment
                |4. Staffs of the same age  
                |5. Group title
                |6. Get All Staff
                |7. Back Main Menu
                """.trimMargin()
            )
            print("Enter your choice: ")
            val choice = scanner.nextLine().trim().toIntOrNull() ?: -1

            when (choice) {
                0 -> factory.serviceStaff.maxSalary()
                1 -> factory.serviceStaff.getStaffSecurity()
                2 -> factory.serviceStaff.getFilterStaff()
                3 -> factory.serviceStaff.getTop3Payment()
                4 -> factory.serviceStaff.getStaffByAge(scanner)
                5 -> factory.serviceStaff.getStaffGroupedByTitle(scanner)
                6 -> factory.serviceStaff.getAllData()
                7 -> return

                else -> println("Invalid option. Try again.")
            }
        }
    }


    private fun teacherMenu(scanner: Scanner, factory: PersonCreateFactory) {
        while (true) {
            println(
                """
                |--- Menu Teacher ---
                |0. Teacher is HighestExperience
                |1. MaxSalary
                |2. GroupByLevel
                |3. Filter advanced
                |4. Get All Teacher
                |5. Back to Main Menu
                """.trimMargin()
            )
            print("Enter your choice: ")
            val choice = scanner.nextLine().trim().toIntOrNull() ?: -1

            when (choice) {
                0 -> factory.serviceTeacher.highestExperience()
                1 -> factory.serviceTeacher.maxSalary()
                2 -> factory.serviceTeacher.groupByLevel()
                3 -> factory.serviceTeacher.advancedFilter(scanner)
                4 -> factory.serviceTeacher.getAllData()
                5 -> return

                else -> println("Invalid option. Try again.")
            }
        }
    }
}
