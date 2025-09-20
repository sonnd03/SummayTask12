package ex1.model.oders

data class Food(
    var nameFood: String,
    var priceFood: Double,
) {
    fun getInfor() = "Get data"
}
