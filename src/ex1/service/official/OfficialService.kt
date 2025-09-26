package ex1.service.official

import ex1.messages.Message
import ex1.model.person.Official
import ex1.service.Service
import ex1.viewModel.person.after.CreateData
import java.util.Scanner

class OfficialService : Service<Official> {
    private val data = mutableListOf<Official>()

    override fun create(scanner: Scanner) : Official {
        val official = CreateData.createOfficial(scanner)
        data.add(official)
        return official
    }

    override fun edit(id: String, item: Official): Official {
        val indexId = data.indexOfFirst { it.idOFC == id }
        if (indexId == -1) {
            println(Message.ID_NOT_FOUND)
        }
        data[indexId] = item
        return item
    }

    override fun remove(id: String): Boolean {
        return data.removeIf { it.idOFC == id }
    }

    override fun getAll(): List<Official> = data
}