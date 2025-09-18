package ex1.extensions

import ex1.dataClass.Staff

class StaffExtension(val staff: List<Staff>) {
    val titleSecurity = "security"
    val titleTreasurer = "treasurer"

    fun staffSecurity(): List<Staff> {
        return staff.filter { it.title.lowercase() == titleSecurity }
    }

    fun getFilterStaff(): List<Staff> {
        return staff.filter { s ->
            with(s) {
                yearOfBirthOFC.year > 2000 &&
                        title.trim().equals(titleTreasurer, ignoreCase = true) &&
                        allowance > 5000
            }
        }
    }
}