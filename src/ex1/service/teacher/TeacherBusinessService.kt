package ex1.service.teacher

import ex1.model.Teacher

interface TeacherBusinessService {
    fun highestExperience(): List<Teacher>
    fun getAllData()
    fun maxSalary()
    fun groupByLevel(): Map<String, List<Teacher>>
    fun printGroupedByLevel()
    fun advancedFilter(subject: String? = null, minPayment: Double? = null, level: String? = null): List<Teacher>
}