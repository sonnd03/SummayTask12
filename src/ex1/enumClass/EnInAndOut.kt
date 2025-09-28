package ex1.enumClass

enum class EnInAndOut(val message: String) {
    INPUT_OFFICIAL("Input %s: "),
    INPUT_STAFF("Input %s Staff: "),
    INPUT_ORDER("Input %s Order: "),
    INPUT_TEACHER("Input %s Teacher: "),
    INPUT_TYPE("1: %s or 2: %s"),
    INPUT_CHOSE("Input Id %s must %s!"),

    OUTPUT_OFFICIAL("Output %s is: "),
    OUTPUT_STAFF("Output %s Staff is: "),
    OUTPUT_TEACHER("Output %s Teacher is: ");

    fun format(vararg value: Any): String = message.format(*value)
}