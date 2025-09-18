package ex1.model

enum class TypeLevel(val type: String, val bonus: Int) {
    ASSOCIATE("Associate", 500000),
    BACHELOR("Bachelor", 1000000),
    MASTER("Master", 2000000),
    DOCTORATE("Doctorate", 5000000),
    OTHER("Other", 50000);

    companion object {
        fun fromNumber(number: Int): TypeLevel? = when (number) {
            1 -> ASSOCIATE
            2 -> BACHELOR
            3 -> MASTER
            4 -> DOCTORATE
            5 -> OTHER
            else -> null
        }

        fun fromString(value: String): TypeLevel? =
            TypeLevel.entries.firstOrNull { it.type.equals(value, ignoreCase = true) }
    }
}
