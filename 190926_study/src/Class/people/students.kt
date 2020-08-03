package Class.people

// 기본 default 주요 생성자 (프라이머리 컨트럭트)
// class Student
// class Student {}
// 클래스명 뒤에 public constructor()이 생략되어 있음
// private constructor() -> 클래스 내에서만 사용 가능한 것 java에서 static와 동일

// 주요생성자 인자를 이용해서 필드를 생성
class Student(name: String?, age: Int, score: Float = 1.0f) { // 인자 값에 var, val이 없으면 필드가 아님
    val realName: String = name ?: "퇴사" // 수정불가 // read only property
    val email: String = "${realName}@퇴사.co.kr"
    val joinedAge: Int = age
    var realScore: Float = score // 수정가능 // read/write property
    private val scholarship: Boolean = (age <= 20) && (realScore >= 3.8f) // private면 외부에서 보이지 않음 내부에서만 동작

    // 행위(메소드) 생성
    fun showStatus() {
        val status = """
            =========== 학생 재학증명 ===========
                이름   : $realName     ${if(scholarship) "장학생" else ""}
                나이   : $joinedAge 세
                학점   : $realScore pt             
                이메일 : ${this.email}
             ===================================
        """.trimIndent() // this -> 클래스 내의 변수를 불러오는거

        println(status)
    }
}

class Student1(val name: String?, val age: Int, var score: Float = 1.0f) {
//    val realName: String = name ?: "퇴사" // 수정불가 // read only property
    val email: String = "${name}@퇴사.co.kr"
//    val joinedAge: Int = age
//    var realScore: Float = score // 수정가능 // read/write property

    // 행위(메소드) 생성
    fun showStatus() {
        val status = """
            =========== 학생 재학증명 ===========
                이름   : $name
                나이   : $age 세
                학점   : ${this.score} pt             
                이메일 : ${this.email}  
             ===================================
        """.trimIndent() // this -> 클래스 내의 변수를 불러오는거

        println(status)
    }
}


fun main() {
//    val s = Student() // 객체의 타입이 인스턴스화 됨
    val s1 = Student("원종우", 26) // realScore는 default로 1.0으로 되어 있음
    val s2: Student = Student(null, 10, 4.0f)
    val s3 = Student("ㄷ", 23, 4.0f)
    val s4 = Student("ㅈ", 25, 3.3f)

    val s5 = Student("원종우", 26) // realScore는 default로 1.0으로 되어 있음
    val s6: Student = Student(null, 10, 2.0f)
    val s7 = Student("ㄷ", 23, 4.0f)
    val s8 = Student("ㅈ", 25, 3.3f)
    val sAll = arrayOf(s5, s6, s7, s8)
//    s1.email = "퇴사@퇴사.co.kr" // val이기 떄문에 수정 불가
    s1.realScore = 4.0f // set 설정 // var이기 떄문에 수정 가능

    s1.showStatus()
    s2.showStatus()
    s3.showStatus()
    s4.showStatus()

    for((i, student) in sAll.withIndex())
        student.showStatus()

}