package ex1.service.staff

import ex1.messages.Message
import ex1.model.person.Staff
import ex1.service.Service
import ex1.viewModel.person.after.CreateData
import java.util.Scanner

class StaffService : Service<Staff> {
    private val data = mutableListOf<Staff>()

    override fun create(scanner: Scanner): Staff {
        val staff = CreateData.createStaff(scanner)
        data.add(staff)
        return staff
    }

    override fun edit(id: String, item: Staff): Staff {
        val indexId = data.indexOfFirst { it.idOFC == id }
        if (indexId == -1) {
            println(Message.ID_NOT_FOUND)
        }
        data[indexId] = item
        return item

    }

    override fun remove(id: String): Boolean {
        return data.removeIf { it.idOFC == id }
    }

    override fun getAll(): List<Staff> = data
}