package ex1.factory

import ex1.enumClass.EnInAndOut
import ex1.interfaces.CheckValid
import ex1.model.person.Official
import ex1.repository.person.official.OfficialRepository
import ex1.repository.person.staff.StaffRepository
import ex1.repository.person.teacher.TeacherRepository
import ex1.service.handler.OfficialHandler
import ex1.service.handler.StaffHandler
import ex1.service.handler.TeacherHandler
import ex1.utils.Valid
import ex1.viewModel.person.OfficialViewModel
import ex1.viewModel.person.StaffViewModel
import ex1.viewModel.person.TeacherViewModel
import java.util.*

class PersonCreateFactory(private val scanner: Scanner) {
    private val checkValid: CheckValid = Valid()

    private val staffRepository = StaffRepository(mutableListOf())
    private val officialRepository = OfficialRepository(mutableListOf())
    private val teacherRepository = TeacherRepository(mutableListOf())
    private val staffHandler = StaffHandler(scanner)
    private val teacherHandler = TeacherHandler(scanner)
    private val officialHandler = OfficialHandler(scanner)
    private val officialMode = OfficialViewModel(officialRepository,officialHandler)

    private val staffViewModel = StaffViewModel(staffRepository, staffHandler,officialMode)
    private val teacherViewModel = TeacherViewModel(teacherRepository, teacherHandler,officialMode)

    fun createPersons(): List<Official> {
        val n = checkValid.checkValidInt(scanner, EnInAndOut.INPUT_OFFICIAL.format("quantity"))
        val listOfficial = mutableListOf<Official>()

        for (i in 1..n) {
            println("\nInput type Official is stt: $i")
            val type = checkValid.selectType(scanner, "Staff", "Teacher")
            val official = typePerson(type)
            listOfficial.add(official)
        }
        return listOfficial
    }

    private fun typePerson(type: String): Official {
        return when (type) {
            "1" -> staffViewModel.createStaff()
            "2" -> teacherViewModel.createTeacher()
            else -> throw IllegalArgumentException("Invalid type: $type")
        }
    }

    fun deletePerson(type: String, id: String) {
        when (type) {
            "1" -> staffViewModel.deleteStaff(id)
            "2" -> teacherViewModel.deleteTeacher(id)
        }
    }

//    fun updatePerson(type: String, id: String) {
//        when (type) {
//            "1" -> staffViewModel.updateStaff(id)
//            "2" -> teacherViewModel.updateTeacher(id)
//        }
//    }

    fun getAllPersons(): List<Official> {
        return staffRepository.getAll() + teacherRepository.getAll()
    }

}
