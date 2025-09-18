package ex1.extensions

import ex1.model.Staff
import ex1.objects.GetData
import java.time.LocalDate

class StaffService(private val listStaff: List<Staff>) : Service<Staff>(listStaff) {
    val titleSecurity = "security"
    val titleTreasurer = "treasurer"

    private fun printStaff(list: List<Staff>, header: String) {
        println(header)
        list.forEach { GetData.getData(it) }
    }

    override fun getAllData() {
        printStaff(listStaff, "\n== All Data Staff==")
    }

    override fun maxSalary() {
        val maxPayment = listStaff.maxOf { it.payment() }
        printStaff(listStaff.filter { it.payment() == maxPayment }, "\n=== List Data Staff max Payment ===")
    }

    fun printStaffSecurity() {
        printStaff(
            listStaff.filter { it.title.trim().equals(titleSecurity, ignoreCase = true) },
            "\n=== List Data Staff title Security ==="
        )
    }

    fun getFilterStaff() {
        printStaff(
            listStaff.filter {
                it.yearOfBirthOFC.year > 2000 &&
                        it.title.trim().equals(titleTreasurer, ignoreCase = true) &&
                        it.allowance > 5000
            },
            "\n=== List Data Staff Filter ==="
        )
    }

    fun printTop3Payment(n: Int) {
        val sorted = listStaff.sortedByDescending { it.payment() }.take(3)
        printStaff(sorted, "\n=== Top $n Staff by Payment ===")
    }

    fun printStaffByAge(startAge: Int, endAge: Int) {
        val currentYear = LocalDate.now().year
        val filtered = listStaff.filter { staff ->
            val age = currentYear - staff.yearOfBirthOFC.year
            age in startAge..endAge
        }
        printStaff(filtered, "\n=== Staff Age is between $startAge and $endAge ===")
    }

    fun printStaffGroupedByTitle(inputTitle: String? = null) {
        val grouped = listStaff.groupBy { it.title }
        grouped.forEach { (title, staffList) ->
            if (inputTitle.isNullOrBlank() || title.equals(inputTitle, ignoreCase = true)) {
                val filterPayment = staffList.filter { it.payment() > 50000 }
                if (filterPayment.isNotEmpty()) {
                    printStaff(filterPayment, "\n=== Staff Group: $title (Payment > 50000) ===")
                }
            }
        }
    }

}