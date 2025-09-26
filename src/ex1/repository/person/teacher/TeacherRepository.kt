package ex1.repository.person.teacher

import ex1.messages.Message
import ex1.model.person.Staff
import ex1.model.person.Teacher
import ex1.repository.person.RepositoryPerson

class TeacherRepository(private val dataTeachers: MutableList<Teacher>) : RepositoryPerson<Teacher>(dataTeachers) {

    fun createTeacher(teacher: Teacher): Teacher {
        if (allIDSaved.contains(teacher.idOFC)) {
            throw IllegalArgumentException(Message.ID_EXITED)
        }
        allIDSaved.add(teacher.idOFC)
        dataTeachers.add(teacher)
        return teacher
    }

    fun updateTeacher(teacher: Teacher): Boolean {
        val index = dataTeachers.indexOfFirst { it.idOFC == teacher.idOFC }
        return if (index != -1) {
            dataTeachers[index] = teacher
            true
        } else {
            false
        }
    }

    fun deleteTeacher(id: String) : Boolean{
        return dataTeachers.removeIf { it.idOFC == id}
    }

    fun getAllTeacher(): List<Teacher> = dataTeachers

    fun findBySubject(title: String?): Boolean =
        data.any { it.subject.equals(title, ignoreCase = true) }
}