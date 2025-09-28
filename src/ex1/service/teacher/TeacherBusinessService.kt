package ex1.service.teacher

import ex1.model.person.Teacher
import java.util.Scanner

interface TeacherBusinessService {
    fun highestExperience(): List<Teacher>
    fun maxSalary()
    fun groupByLevel()
    fun advancedFilter(scanner: Scanner): List<Teacher>
}