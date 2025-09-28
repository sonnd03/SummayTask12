package ex1.repository.person.staff

import ex1.messages.Message
import ex1.model.person.Staff
import ex1.repository.person.RepositoryPerson

class StaffRepository(private val dataStaffs: MutableList<Staff>) : RepositoryPerson<Staff>(dataStaffs) {

    fun createStaff(staff: Staff): Staff {
        dataStaffs.add(staff)
        return staff
    }

    fun updateStaff(staff: Staff): Boolean {
        val index = dataStaffs.indexOfFirst { it.idOFC == staff.idOFC }
        return if (index != -1) {
            dataStaffs[index] = staff
            print(Message.UPDATE_SUCCESS)
            true
        } else {
            false
        }
    }

    fun deleteStaff(id: String): Boolean {
        val staff = dataStaffs.find { it.idOFC == id }
        return if (staff != null) {
            dataStaffs.remove(staff)
            allIDSaved.remove(id)
            true
        } else {
            false
        }
    }

    override fun getAll(): List<Staff> = dataStaffs

    fun findByIdStaff(id: String): Staff? = dataStaffs.find { it.idOFC == id }

    fun findByTitle(title: String): List<Staff> =
        data.filter { it.title.equals(title, ignoreCase = true) }
}