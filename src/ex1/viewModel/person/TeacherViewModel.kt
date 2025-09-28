package ex1.viewModel.person

import ex1.enumClass.EnInAndOut
import ex1.messages.Message
import ex1.model.person.Teacher
import ex1.repository.person.TeacherRepository
import ex1.service.handler.persons.TeacherHandler

class TeacherViewModel(
    private val teacherRepository: TeacherRepository,
    private val handler: TeacherHandler,
    private val officialViewModel: OfficialViewModel,

    ) {
    fun createTeacher(): Teacher {
        val official = officialViewModel.createOfficial()
        val teacherInput = handler.createTeacher()
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

    fun updateTeacher(): Boolean {
        println((EnInAndOut.INPUT_CHOSE).format("Teacher", "Update"))
        val official = officialViewModel.updateOfficial()
        val teacherInput = handler.updateTeacher()
        val teacher = Teacher(
            official.idOFC,
            official.nameOFC,
            official.yearOfBirthOFC,
            official.salaryOFC,
            teacherInput.subject,
            teacherInput.level,
            teacherInput.exception
        )
        return teacherRepository.updateTeacher(teacher)
    }

    fun deleteTeacher(id: String): Boolean {
        return teacherRepository.deleteTeacher(id)
    }

    fun getAllTeacher(): List<Teacher> = teacherRepository.getAll()

    fun findBySubjectTeacher(title: String?): Boolean = teacherRepository.findBySubject(title)
}