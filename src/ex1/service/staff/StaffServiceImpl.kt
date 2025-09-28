package ex1.service.staff

import ex1.messages.GetData
import ex1.model.person.Staff
import ex1.repository.person.StaffRepository
import ex1.utils.CheckValid
import ex1.utils.Valid
import java.time.LocalDate
import java.util.*

class StaffServiceImpl(private val staffRepository: StaffRepository) : StaffBusinessService {
    val titleSecurity = "security"
    val titleTreasurer = "treasurer"
    val getData = GetData()
    val checkValid: CheckValid = Valid()

    private fun printStaff(list: List<Staff>, header: String) {
        if (list.isEmpty()){
            println("List no value")
        } else{
            println(header)
            list.forEach { getData.getData(it) }
        }
    }

    override fun maxSalary() {
        val dataStaff = staffRepository.getAll()
        val maxPayment = dataStaff.maxOf { it.payment() }
        printStaff(dataStaff.filter { it.payment() == maxPayment }, "\n=== List Data Staff max Payment ===")
    }

    override fun getStaffSecurity() {
        printStaff(
            staffRepository.findByTitle(titleSecurity),
            "\n=== List Data Staff title Security ==="
        )
    }

    override fun getFilterStaff() {
        val listStaff = staffRepository.findByTitle(titleTreasurer).filter {
            it.yearOfBirthOFC.year > 2000 &&
                    it.allowance > 5000
        }
        printStaff(listStaff, "\n=== List Data Staff Filter ===")
    }

    override fun getTop3Payment() {
        val dataStaff = staffRepository.getAll()
        val sorted = dataStaff.sortedByDescending { it.payment() }.take(3)
        printStaff(sorted, "\n=== Top 3 Staff by Payment ===")
    }

    override fun getStaffByAge(scanner: Scanner) {
        val startAge = checkValid.checkValidInt(scanner, "Enter Start age: ")
        val endAge = checkValid.checkValidInt(scanner, "Enter End age: ")

        val dataStaff = staffRepository.getAll()
        val currentYear = LocalDate.now().year
        val filtered = dataStaff.filter { staff ->
            val age = currentYear - staff.yearOfBirthOFC.year
            age in startAge..endAge
        }
        printStaff(filtered, "\n=== Staff Age is between $startAge and $endAge ===")
    }

    override fun getStaffGroupedByTitle(scanner: Scanner) {
        val inputTitle: String? = checkValid.checkValidString(scanner, "Input title must group(can empty): ")
        val dataStaff = staffRepository.getAll()
        val grouped = dataStaff.groupBy { it.title }
        grouped
            .filter { (title, _) -> inputTitle.isNullOrBlank() || title.equals(inputTitle, ignoreCase = true) }
            .forEach { (title, staffList) ->
                val filterPayment = staffList.filter { it.payment() > 50000 }
                printStaff(filterPayment, "\n=== Staff Group: $title (Payment > 50000) ===")
            }
    }

    fun getAllData() = staffRepository.getAll()
}