package ex1.repository.person.official

import ex1.messages.Message
import ex1.model.person.Official
import ex1.repository.person.RepositoryPerson

class OfficialRepository(
    private val dataOfficials: MutableList<Official>,
) : RepositoryPerson<Official>(dataOfficials) {

    fun createOfficial(official: Official): Official {
        dataOfficials.add(official)
        return official
    }

    fun updateOfficial(official: Official): Official {
        val index = dataOfficials.indexOfFirst { it.idOFC == official.idOFC }
        if (index == -1) {
            throw NoSuchElementException(Message.ID_NOT_FOUND)
        } else {
            dataOfficials[index] = official
        }
        return official
    }

    fun deleteOfficial(id: String): Boolean {
        return dataOfficials.removeIf { it.idOFC == id }
    }

    fun findByIdOfficial(id: String): Official? = dataOfficials.find { it.idOFC == id }

    fun getAllOfficial(): List<Official> = dataOfficials
}