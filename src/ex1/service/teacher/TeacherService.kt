package ex1.service.teacher

import ex1.messages.Message
import ex1.model.person.Teacher
import ex1.service.Service
import ex1.viewModel.person.CreateData
import java.util.*

class TeacherService : Service<Teacher> {
    private val data = mutableListOf<Teacher>()
    override fun create(scanner: Scanner): Teacher {
        val teacher = CreateData.createTeacher(scanner)
        data.add(teacher)
        return teacher
    }

    override fun edit(id: String, item: Teacher): Teacher {
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

    override fun getAll(): List<Teacher> = data
}