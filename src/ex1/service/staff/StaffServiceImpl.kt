package ex1.service.staff

import ex1.model.person.Staff
import ex1.repository.person.StaffRepository
import java.time.LocalDate

class StaffServiceImpl(private val staffRepository: StaffRepository) : StaffBusinessService {
    val dataStaff = staffRepository.getAll()
    val titleSecurity = "security"
    val titleTreasurer = "treasurer"

    private fun printStaff(list: List<Staff>, header: String) {
        println(header)
        list.forEach { it }
    }

    override fun getAllData() {
        printStaff(dataStaff, "\n== All Data Staff==")
    }

    override fun maxSalary() {
        val maxPayment = dataStaff.maxOf { it.payment() }
        printStaff(dataStaff.filter { it.payment() == maxPayment }, "\n=== List Data Staff max Payment ===")
    }

    override fun printStaffSecurity() {
        printStaff(
            staffRepository.findByTitle(titleSecurity),
            "\n=== List Data Staff title Security ==="
        )
    }

    override fun getFilterStaff() {
        val listStaff = staffRepository.findByTitle(titleTreasurer)
        listStaff.filter {
            it.yearOfBirthOFC.year > 2000 &&
                    it.allowance > 5000
        }
        printStaff(listStaff, "\n=== List Data Staff Filter ===")
    }

    override fun printTop3Payment(n: Int) {
        val sorted = dataStaff.sortedByDescending { it.payment() }.take(3)
        printStaff(sorted, "\n=== Top $n Staff by Payment ===")
    }

    override fun printStaffByAge(startAge: Int, endAge: Int) {
        val currentYear = LocalDate.now().year
        val filtered = dataStaff.filter { staff ->
            val age = currentYear - staff.yearOfBirthOFC.year
            age in startAge..endAge
        }
        printStaff(filtered, "\n=== Staff Age is between $startAge and $endAge ===")
    }

    override fun printStaffGroupedByTitle(inputTitle: String?) {
        val grouped = dataStaff.groupBy { it.title }
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