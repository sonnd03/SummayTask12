package ex1.viewModel.person

import ex1.model.person.Official
import ex1.repository.person.official.OfficialRepository
import ex1.service.handler.OfficialHandler

class OfficialViewModel(
    private val officialRepository: OfficialRepository,
    private val handler: OfficialHandler,
) {
    fun createOfficial(): Official {
        val officialInput = handler.createOfficial()
        val official = Official(
            officialInput.id,
            officialInput.name,
            officialInput.year,
            officialInput.salary
        )
        return officialRepository.createOfficial(official)
    }

    fun updateOfficial(): Official {
        val officialInput = handler.updateOfficial()
        val official = Official(
            officialInput.id,
            officialInput.name,
            officialInput.year,
            officialInput.salary
        )
        return officialRepository.updateOfficial(official)
    }

    fun deleteOfficial(id: String): Boolean {
        return officialRepository.deleteOfficial(id)
    }

    fun getAllOfficial(): List<Official> = officialRepository.getAllOfficial()

    fun findByIdOfficial(id: String): Official? = officialRepository.findByIdOfficial(id)
}