package ex1.viewModel.person

import ex1.model.person.Teacher
import ex1.repository.person.teacher.TeacherRepository
import ex1.service.handler.TeacherHandler

class TeacherViewModel(
    private val teacherRepository: TeacherRepository,
    private val handler: TeacherHandler,
    private val officialViewModel: OfficialViewModel,

    ) {
    fun createTeacher(): Teacher {
        val teacherInput = handler.createTeacher()
        val official = officialViewModel.createOfficial()
        val teacher = Teacher(
            official.idOFC,
            official.nameOFC,
            official.yearOfBirthOFC,
            official.salaryOFC,
            teacherInput.subject,
            teacherInput.level,
            teacherInput.exception
        )
        return teacherRepository.createTeacher(teacher)
    }

    fun updateTeacher(teacher: Teacher): Boolean {
        return teacherRepository.updateTeacher(teacher)
    }

    fun deleteTeacher(id: String): Boolean {
        return teacherRepository.deleteTeacher(id)
    }

    fun getAllTeacher(): List<Teacher> = teacherRepository.getAllTeacher()

    fun findBySubjectTeacher(title: String?): Boolean = teacherRepository.findBySubject(title)
}