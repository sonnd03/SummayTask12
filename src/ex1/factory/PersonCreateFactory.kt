package ex1.factory

import ex1.enumClass.EnInAndOut
import ex1.interfaces.CheckValid
import ex1.messages.GetData
import ex1.messages.Message
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
    val getData = GetData()

    private val staffRepository = StaffRepository(mutableListOf())
    private val officialRepository = OfficialRepository(mutableListOf())
    private val teacherRepository = TeacherRepository(mutableListOf())
    private val staffHandler = StaffHandler(scanner)
    private val teacherHandler = TeacherHandler(scanner)
    private val officialHandler = OfficialHandler(scanner)
    private val officialMode = OfficialViewModel(officialRepository, officialHandler)
    private val staffViewModel = StaffViewModel(staffRepository, staffHandler, officialMode)
    private val teacherViewModel = TeacherViewModel(teacherRepository, teacherHandler, officialMode)

    fun createPersons(): List<Official> {
        println()
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

    fun deletePerson() {
        val type = checkValid.selectType(scanner, "Delete Staff", "Delete Teacher")
        print("Input id: ")
        val id = scanner.nextLine()
        when (type) {
            "1" -> staffViewModel.deleteStaff(id)
                .also { if (it) println("Delete success") else println("Delete Fail") }

            "2" -> teacherViewModel.deleteTeacher(id)
                .also { if (it) println("Delete success") else println("Delete Fail") }
        }
    }

    fun getDataStaff() = staffViewModel.getAllStaff().forEach { getData.getData(it) }

    fun updatePerson() {
        if (getAllPersons().isEmpty()) {
            println(Message.NOT_PERSON)
            return
        }
        val type = checkValid.selectType(scanner, "Update Staff", "Update Teacher")
        when (type) {
            "1" -> staffViewModel.updateStaff()
            "2" -> teacherViewModel.updateTeacher()
        }
    }

    fun getAllPersons(): List<Official> {
        return staffRepository.getAll() + teacherRepository.getAll()
    }

}
