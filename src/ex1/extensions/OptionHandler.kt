package ex1.extensions

import ex1.enumClass.EnType
import ex1.model.Official
import ex1.model.Staff
import ex1.model.Teacher
import ex1.repository.CreateData
import ex1.repository.CreateData.inputOfficial
import ex1.repository.EditData
import ex1.repository.RemoveData
import ex1.utils.Valid
import java.util.Scanner
import javax.swing.text.html.Option

object OptionHandler {
    val checkValid = Valid()
    fun startOption(typeOption: String,
                    scanner: Scanner,
                    listOfficial: MutableList<Official>,
                    listStaff: MutableList<Staff>,
                    listTeacher: MutableList<Teacher>){
        when(typeOption){
            "1" -> {
                println("Input Id Update")
                val idOption = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
                EditData.update(scanner,idOption,listOfficial,listStaff,listTeacher)
            }

            "2" -> {
                println("Input Id Delete: ")
                val idOption = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
                RemoveData.deleteData(idOption,listOfficial,listStaff,listTeacher, CreateData.allIDSaved)
            }
        }
    }
}