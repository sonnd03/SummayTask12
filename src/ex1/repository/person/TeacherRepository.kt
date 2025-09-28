package ex1.repository.person

import ex1.messages.Message
import ex1.model.person.Teacher

class TeacherRepository(private val dataTeachers: MutableList<Teacher>) : RepositoryPerson<Teacher>(dataTeachers) {

    fun createTeacher(teacher: Teacher): Teacher {
        dataTeachers.add(teacher)
        println(Message.CREATE_SUCCESS)
        return teacher
    }

    fun updateTeacher(teacher: Teacher): Boolean {
        val index = dataTeachers.indexOfFirst { it.idOFC == teacher.idOFC }
        return if (index != -1) {
            dataTeachers[index] = teacher
            print(Message.UPDATE_SUCCESS)
            true
        } else {
            false
        }
    }

    fun deleteTeacher(id: String): Boolean {
        val teacher = dataTeachers.find { it.idOFC == id }
        return if (teacher != null) {
            dataTeachers.remove(teacher)
            allIDSaved.remove(id)
            println(Message.DELETE_SUCCESS)
            true
        } else {
            false
        }
    }

    override fun getAll(): List<Teacher> = dataTeachers

    fun findBySubject(title: String?): Boolean =
        data.any { it.subject.equals(title, ignoreCase = true) }
}