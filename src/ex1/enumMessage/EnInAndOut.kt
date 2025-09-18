package ex1.enumMessage

enum class EnInAndOut(val message: String) {
    INPUT_OFFICIAL("Input %s: "),
    INPUT_STAFF("Input %s Staff: "),
    INPUT_TEACHER("Input %s Teacher: "),

    OUTPUT_OFFICIAL("Output %s is: "),
    OUTPUT_STAFF("Output %s Staff is: "),
    OUTPUT_TEACHER("Output %s Teacher is: ");

    fun format(value: String): String = message.format(value)
}