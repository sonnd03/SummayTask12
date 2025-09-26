package ex1.repository.person.staff

import ex1.messages.Message
import ex1.model.person.Staff
import ex1.repository.person.RepositoryPerson

class StaffRepository(private val dataStaffs: MutableList<Staff>) : RepositoryPerson<Staff>(dataStaffs) {

    fun createStaff(staff: Staff): Staff {
        if (allIDSaved.contains(staff.idOFC)) {
            throw IllegalArgumentException(Message.ID_EXITED)
        }
        allIDSaved.add(staff.idOFC)
        dataStaffs.add(staff)
        return staff
    }

    fun updateStaff(staff: Staff): Boolean {
        val index = dataStaffs.indexOfFirst { it.idOFC == staff.idOFC }
        return if (index != -1) {
            dataStaffs[index] = staff
            true
        } else {
            false
        }
    }

    fun deleteStaff(id: String): Boolean {
        return dataStaffs.removeIf { it.idOFC == id }
    }

    fun getAllStaff(): List<Staff> = dataStaffs

    fun findByIdStaff(id: String): Staff? = dataStaffs.find { it.idOFC == id }

    fun findByTitle(title: String): List<Staff> =
        data.filter { it.title.equals(title, ignoreCase = true) }
}