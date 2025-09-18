package ex1.repository

import ex1.model.Official
import ex1.model.Staff
import ex1.model.Teacher
import ex1.objects.Message

object RemoveData {
    fun deleteData(
        id: String,
        listOfficial: MutableList<Official>,
        listStaff: MutableList<Staff>,
        listTeacher: MutableList<Teacher>,
        allIDSaved: MutableSet<String>,
    ) {
        if (allIDSaved.contains(id)) {
            listOfficial.removeIf { it.idOFC == id }
            listStaff.removeIf { it.idOFC == id }
            listTeacher.removeIf { it.idOFC == id }
            allIDSaved.remove(id)
            println("Delete $id success!")
        } else {
            println(Message.ID_NOT_FOUND)
        }
    }
}
