package ex1.repository.person

import ex1.model.person.Staff
import ex1.repository.Repository

class StaffRepository(dataStaff: MutableList<Staff>) : Repository<Staff>(dataStaff) {
    fun findByTitle(title: String): List<Staff> =
        data.filter { it.title.equals(title, ignoreCase = true) }
}