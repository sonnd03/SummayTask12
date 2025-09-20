package ex1.repository.person

import ex1.model.person.Teacher

import ex1.repository.Repository

class TeacherRepository(dataTeacher: MutableList<Teacher>) : Repository<Teacher>(dataTeacher) {
    fun findBySubject(title: String?): Boolean =
        data.any { it.subject.equals(title, ignoreCase = true) }
}