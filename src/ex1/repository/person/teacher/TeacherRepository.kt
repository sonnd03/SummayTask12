package ex1.repository.person.teacher

import ex1.model.person.Teacher
import ex1.repository.person.RepositoryPerson

class TeacherRepository(private val dataTeachers: MutableList<Teacher>) : RepositoryPerson<Teacher>(dataTeachers) {

    fun createTeacher(teacher: Teacher): Teacher {
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

    fun deleteTeacher(id: String): Boolean {
        val teacher = dataTeachers.find { it.idOFC == id }
        return if (teacher != null) {
            dataTeachers.remove(teacher)
            allIDSaved.remove(id)
            true
        } else {
            false
        }
    }

    fun getAllTeacher(): List<Teacher> = dataTeachers

    fun findBySubject(title: String?): Boolean =
        data.any { it.subject.equals(title, ignoreCase = true) }
}