package ex1.extensions

import ex1.dataClass.Teacher

class TeacherExtension(val teacher: List<Teacher>) {

    fun highestExperience(): List<Teacher> {
        val maxExp = teacher.maxOfOrNull { it.experienced } ?: return emptyList()
        return teacher.filter { it.experienced == maxExp }
    }

    fun
}