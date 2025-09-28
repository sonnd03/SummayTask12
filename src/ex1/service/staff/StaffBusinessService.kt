package ex1.service.staff

import java.util.Scanner

interface StaffBusinessService {
    fun maxSalary()
    fun getStaffSecurity()
    fun getFilterStaff()
    fun getTop3Payment()
    fun getStaffByAge(scanner: Scanner)
    fun getStaffGroupedByTitle(scanner: Scanner)
}
