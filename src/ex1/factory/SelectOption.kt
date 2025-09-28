package ex1.factory

import java.util.*

object SelectOption {
    fun selectOption() {
        val scanner = Scanner(System.`in`)
        val factory = PersonCreateFactory(scanner)

        while (true) {
            println(
                "\n" +
                        """
            |--- Menu ---
            |0. Create Persons
            |1. Get Staff Data
            |2. Delete Persons
            |3. Update Persons
            |4. Exit
        """.trimMargin()
            )
            print("Enter your choice: ")
            val userChoice = scanner.nextLine().trim().toIntOrNull() ?: -1

            when (userChoice) {
                0 -> factory.createPersons()
                1 -> factory.getDataStaff()
                2 -> factory.deletePerson()
                3 -> factory.updatePerson()
                4 -> {
                    println("Exiting...")
                    break
                }

                else -> println("Invalid option. Try again.")
            }
        }
    }

}