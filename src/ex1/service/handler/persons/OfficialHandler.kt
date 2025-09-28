package ex1.service.handler.persons

import ex1.enumClass.EnInAndOut
import ex1.enumClass.EnType
import ex1.utils.CheckValid
import ex1.messages.Message
import ex1.repository.person.RepositoryPerson
import ex1.request.OfficialInput
import ex1.utils.Valid
import java.util.*

class OfficialHandler(private val scanner: Scanner) {
    val checkValid: CheckValid = Valid()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL

    fun createOfficial(): OfficialInput {
        var id: String
        while (true) {
            id = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
            if (RepositoryPerson.allIDSaved.contains(id)) {
                println(Message.ID_EXITED)
            } else {
                RepositoryPerson.allIDSaved.add(id)
                break
            }
        }
        val name = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value))
        val year = checkValid.checkValidDate(scanner, inputOfficial.format(EnType.YEAR.value))
        val salary = checkValid.checkValidDouble(scanner, inputOfficial.format(EnType.SALARY.value))

        return OfficialInput(id, name, year, salary)
    }

    fun updateOfficial(): OfficialInput {
        var id: String
        while (true) {
            id = checkValid.checkValidString(scanner, inputOfficial.format(EnType.ID.value))
            if (RepositoryPerson.allIDSaved.contains(id)) break else println(Message.ID_NOT_FOUND)
        }
        val name = checkValid.checkValidString(scanner, inputOfficial.format(EnType.NAME.value))
        val year = checkValid.checkValidDate(scanner, inputOfficial.format(EnType.YEAR.value))
        val salary = checkValid.checkValidDouble(scanner, inputOfficial.format(EnType.SALARY.value))

        return OfficialInput(id, name, year, salary)
    }
}