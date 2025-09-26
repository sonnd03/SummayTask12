package ex1.utils

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.model.person.Official
import ex1.model.person.Staff
import ex1.model.person.Teacher
import ex1.viewModel.person.after.CreateData
import ex1.viewModel.person.after.EditData
import ex1.viewModel.person.after.RemoveData
import java.util.*

object OptionHandler {
    val checkValid = Valid()
    fun startOption(
        typeOption: String,
        scanner: Scanner,
        listOfficial: MutableList<Official>,
        listStaff: MutableList<Staff>,
        listTeacher: MutableList<Teacher>,
    ) {
        when (typeOption) {
            "1" -> {
                println(EnInAndOut.INPUT_OFFICIAL.format("Edit"))
                val idOption = checkValid.checkValidString(scanner, CreateData.inputOfficial.format(EnType.ID.value))
                EditData.update(scanner, idOption, listOfficial, listStaff, listTeacher)
            }

            "2" -> {
                println(EnInAndOut.INPUT_OFFICIAL.format("Delete"))
                val idOption = checkValid.checkValidString(scanner, CreateData.inputOfficial.format(EnType.ID.value))
                RemoveData.deleteData(idOption, listOfficial, listStaff, listTeacher, CreateData.allIDSaved)
            }
        }
    }
}