package ex1.repository.person
import ex1.enumClass.EnInAndOut
import ex1.model.person.Official
import ex1.repository.Repository
import ex1.utils.Valid

class OfficialRepository(dataOfficial: MutableList<Official>) : Repository<Official>(dataOfficial){
    val checkValid = Valid()
    val inputOfficial = EnInAndOut.INPUT_OFFICIAL
    val inputStaff = EnInAndOut.INPUT_STAFF
    val inputTeacher = EnInAndOut.INPUT_TEACHER
}