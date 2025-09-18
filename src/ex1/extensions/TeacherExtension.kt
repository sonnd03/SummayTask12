package ex1.extensions

import ex1.dataClass.Teacher

class TeacherExtension(var teacher: List<Teacher>) {
    fun highestExperience(teachers: List<Teacher>): List<Teacher> {
        val maxExp = teachers.maxOfOrNull { it.experienced } ?: return emptyList()
        return teachers.filter { it.experienced == maxExp }
    }
}