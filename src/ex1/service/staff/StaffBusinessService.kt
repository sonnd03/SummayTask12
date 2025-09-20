package ex1.service.staff

interface StaffBusinessService {
    fun getAllData()
    fun maxSalary()
    fun printStaffSecurity()
    fun getFilterStaff()
    fun printTop3Payment(n: Int)
    fun printStaffByAge(startAge: Int, endAge: Int)
    fun printStaffGroupedByTitle(inputTitle: String? = null)
}
