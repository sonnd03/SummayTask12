package ex1.repository.person.official

import ex1.messages.Message
import ex1.model.person.Official
import ex1.repository.person.RepositoryPerson

class OfficialRepository(private val dataOfficials: MutableList<Official>) : RepositoryPerson<Official>(dataOfficials) {

    fun createOfficial(official: Official): Official {
        if (allIDSaved.contains(official.idOFC)) {
            throw IllegalArgumentException(Message.ID_EXITED)
        }
        allIDSaved.add(official.idOFC)
        dataOfficials.add(official)
        return official
    }

    fun updateOfficial(official: Official): Boolean {
        val index = dataOfficials.indexOfFirst { it.idOFC == official.idOFC }
        return if (index != -1) {
            dataOfficials[index] = official
            true
        } else {
            false
        }
    }

    fun deleteOfficial(id: String): Boolean {
        return dataOfficials.removeIf { it.idOFC == id }
    }

    fun findByIdOfficial(id: String): Official? = dataOfficials.find { it.idOFC == id }

    fun getAllOfficial(): List<Official> = dataOfficials
}