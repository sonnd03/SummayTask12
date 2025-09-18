package ex1.extensions

import ex1.model.Official
import ex1.objects.GetData

class OfficialService(listOfficial: List<Official>) : Service<Official>(listOfficial) {
    override fun getAllData() {
        print("\n== ALL DATA ==")
        listOfficial.forEach { GetData.getData(it) }
    }

    override fun maxSalary() {
        listOfficial.maxOf { it.payment() }
    }
}