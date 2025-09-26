package ex1.request

import ex1.utils.TypeLevel

data class TeacherInput(
    val subject: String,
    val level: TypeLevel,
    val exception: Int,
)
