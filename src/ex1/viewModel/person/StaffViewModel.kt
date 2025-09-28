package ex1.viewModel.person

import ex1.enumClass.EnInAndOut
import ex1.model.person.Official
import ex1.model.person.Staff
import ex1.repository.person.staff.StaffRepository
import ex1.service.handler.StaffHandler

class StaffViewModel(
    private val staffRepository: StaffRepository,
    private val handler: StaffHandler,
    private val officialViewModel: OfficialViewModel,
) {

    fun createStaff(): Staff {
        val official = officialViewModel.createOfficial()
        val (title, allowance) = handler.createStaff()
        val staff = Staff(
            official.idOFC,
            official.nameOFC,
            official.yearOfBirthOFC,
            official.salaryOFC,
            title,
            allowance
        )
        return staffRepository.createStaff(staff)
    }

    fun updateStaff(): Boolean {
        println((EnInAndOut.INPUT_CHOSE).format("Staff","Update"))
        val official = officialViewModel.updateOfficial()
        val (title, allowance) = handler.updateStaff()
        val staff = Staff(
            official.idOFC,
            official.nameOFC,
            official.yearOfBirthOFC,
            official.salaryOFC,
            title,
            allowance
        )
        return staffRepository.updateStaff(staff)
    }

    fun deleteStaff(id: String): Boolean {
        return staffRepository.deleteStaff(id)
    }

    fun getAllStaff() = staffRepository.getAll()

    fun findByIdStaff(id: String): Official? = staffRepository.findByIdStaff(id)
}