package ex1.extensions

import ex1.dataClass.Staff

class StaffExtension(val staff: List<Staff>) {

    fun staffSecurity(): List<Staff> {
        return staff.filter { it.title.lowercase() == "security" }
    }

    fun getFilterStaff(): List<Staff> {
        return staff.filter { staff ->
            with(staff) {
                yearOfBirthOFC.year > 2000 &&
                        nameOFC.equals("treasurer", ignoreCase = true) &&
                        allowance > 5000
            }
        }
    }
}