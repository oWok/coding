package members

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.log
/*
 VO와 DTO 정리 :
-       VO : 사용 되는 값이 객체로 표현 되며, 값 변경이 없는 경우를 말한다.

-       DTO : 데이터의 전송을 위한 객체이며, 비지니스 로직까지 담아서 사용하기 한다.
*/



// 회원 데이터 / 아래에 것들 처럼 목록을 스키마 정의라고 함
// 번호
//이름
//나이
//로그인 아이디
//암호(패스워드)
//프리미엄 회원 유무
//활동 포인트
// 위키피디아에서 erd 혹은 rem 검색
// 파워 아키텍트, mysql 웍벤치, sql power -> erd 그리기 무료 툴
// VO DTO / VO : value object -> 값이나 데이터를 담는 그릇과 같은 것 = 내용이 같으면 같은 객체로 봄 / DTO : Data transfer object
class Member() { // : Any가 생략
    // 데이터 단위 클래스 정의
    // java 같은경우에는 get, set 함수를 생성 해야함, toString(), equals(), hashCode()가 필요함 / 복제(copy)
    var id: Int = 0
    var name: String = "no name"
    var activityPoints: Double = 1.0 //
    var age: Int = 20
    var premiumLevel: Boolean = false
    var loginName: String = "guest"
    var password: String = "12345"

    fun copy(id: Int = this.id, name: String = this.name, activityPoints: Double = this.activityPoints, age: Int = this.age, premiumLevel: Boolean = this.premiumLevel,
             loginName: String = this.loginName, password: String = this.password) = Member(id, name, activityPoints, age, premiumLevel, loginName, password)
    // 기존값을 가져오되 다른 값이 입력되면 그 값만 변경 java에서는 클론과 같은 개념


    // override -> 재정의


//    override fun equals(other: Any?): Boolean {
//        return super.equals(other)
//    }
//
//    override fun hashCode(): Int {
//        return super.hashCode()
//    }
//
//    override fun toString(): String {
//        return super.toString()
//    }

    constructor(id: Int, name: String, activityPoints: Double, age: Int, premiumLevel: Boolean, loginName: String, password: String): this() { // 인자가 없지만 위임 해줘야 함
        this.id = id
        this.name = name
        this.activityPoints = activityPoints
        this.age = age
        this.premiumLevel = premiumLevel
        this.loginName = loginName
        this.password = password
    }

    constructor(name: String, loginName: String, password: String): this() {
        this.name = name
        this.age = age
        this.loginName = loginName
        this.password = password
    }

    override fun toString(): String {
        return "Member(id=$id, name='$name', activityPoints=$activityPoints, age=$age, premiumLevel=$premiumLevel, loginName='$loginName', password='$password')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true // === -> 객체의 주소와 내용이 모두 같은지
        if (javaClass != other?.javaClass) return false

        other as Member

        if (id != other.id) return false
        if (name != other.name) return false
        if (activityPoints != other.activityPoints) return false
        if (age != other.age) return false
        if (premiumLevel != other.premiumLevel) return false
        if (loginName != other.loginName) return false
        if (password != other.password) return false

        return true
    }

//    override fun hashCode(): Int {
//        var result = id
//        result = 31 * result + name.hashCode()
//        result = 31 * result + activityPoints.hashCode()
//        result = 31 * result + age
//        result = 31 * result + premiumLevel.hashCode()
//        result = 31 * result + loginName.hashCode()
//        result = 31 * result + password.hashCode()
//        return result
//   }
}

data class Member_data(var id: Int = 0, var name: String = "no name", var activityPoints: Double = 1.0, var age: Int = 20,   // 위에 만든 Member 클래스와 거의 동일
                       var premiumLevel: Boolean = false,  var loginName: String = "guest", var password: String = "12345", var ms: MemberShip = MemberShip.BASIC) // 데이터 클래스는 바디를 굳이 정의 할필요 가없음

// 회원 데이터를 관리하는 클래스
class MemberManager {
    private val memberList = ArrayList<Member_data>()

    // 회원 가입 함수
    fun joinMember(newMb: Member_data) {
        when {
            newMb.loginName.isEmpty() -> {
                println("error : 로그인 아이다가 입력되지 않았습니다.")
                return
            }
            newMb.loginName.isBlank() -> {
                println("error : 로그인 아이디에 공백문자열이 포함되어있습니다.")
                return
            }
            newMb.loginName.length < 4 || newMb.loginName.length > 10 -> {
                println("error : 아이디는 4자리 이상 9자리 이하로 해주세요")
                return
            }
            newMb.loginName.equals("guest") -> {  //newMb.loginName == "guest" 라고 해도됨 (자바이서는 안됨 -> 코틀린에서만 가능)
                println("guest입니다")
                return
            }
            else -> {
                println("정상 로그인 아이디 : ${newMb.loginName} / ${newMb.hashCode()}")
            }
        }
        newMb.id = memberList.size + 1
        this.memberList.add(newMb)
    }

    // 회원 리스트 출력 함수
    fun showAllMembers() {
        println("=".repeat(50))
        println("------- 회원 리스트 (총 회원 수 : ${memberList.size} 명) -------")
        this.memberList.forEach {
            println(it) // it -> it.toString() 문자열을 찍는 것에 한에 .toString()이 자동 호출
        }
        println("=".repeat(50))
    }

    private val LOGIN_SUCCESS: Int = 1
    private val LOGIN_PASSWORD_MISMATCH: Int = 11
    private val LOGIN_MEMBER_NOT_FOUND: Int = 13
    private val LOGIN_NAME_EMPTY: Int = 15
    private val LOGIN_PASSWORD_EMPTY: Int = 17

    // 회원 로그인 인증
    //fun loginMember(loginName: String, password: String): Boolean {} // 단순히 true false만 리턴
    fun loginMember(loginName: String, password: String): Int { // true false 말고도 다른 경우의 수에 대해 구현 가능
        if(loginName.isEmpty() || loginName.isEmpty()){
            println("로그인 이름이 입력되지 않음")
            return LOGIN_NAME_EMPTY
        }

        if(password.isEmpty() || password.isEmpty()){
            println("페스워드가 입력되지 않았습니다.")
            return LOGIN_PASSWORD_EMPTY
        }

        for(mb in this.memberList){
            if(mb.loginName == loginName){ // 내용만 일치 하면 됨
                if(mb.password == password) {
                    println("$loginName 회원님 ㅇ 성공")
                    return LOGIN_SUCCESS
                }
                else {
                    println("비밀번호가 다름")
                    return LOGIN_PASSWORD_MISMATCH
                }

            }
        }

        println("$loginName 회원을 찾을 수 없습니다 가입 해주소")
        return LOGIN_MEMBER_NOT_FOUND
    }

}

class MemberOld() {
    var id: Int = 0
    var name: String = "no name"
    var activityPoints: Double = 1.0 //
    var age: Int = 20
    var premiumLevel: Boolean = false
    var loginName: String = "guest"
    var password: String = "12345"

    constructor(id: Int, name: String, activityPoints: Double, age: Int, premiumLevel: Boolean, loginName: String, password: String): this() { // 인자가 없지만 위임 해줘야 함
        this.id = id
        this.name = name
        this.activityPoints = activityPoints
        this.age = age
        this.premiumLevel = premiumLevel
        this.loginName = loginName
        this.password = password
    }

    constructor(name: String, age: Int, loginName: String, password: String): this() {
        this.name = name
        this.age = age
        this.loginName = loginName
        this.password = password
    }

    override fun toString(): String {
        return "MemberOld(id=$id, name='$name', activityPoints=$activityPoints, age=$age, premiumLevel=$premiumLevel, loginName='$loginName', password='$password')"
    }

    fun copy(id: Int = this.id, name: String = this.name, activityPoints: Double = this.activityPoints, age: Int = this.age, premiumLevel: Boolean = this.premiumLevel,
             loginName: String = this.loginName, password: String = this.password) = MemberOld(id, name, activityPoints, age, premiumLevel, loginName, password)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true // === -> 객체의 주소와 내용이 모두 같은지
        if (javaClass != other?.javaClass) return false

        other as MemberOld

        if (id != other.id) return false
        if (name != other.name) return false
        if (activityPoints != other.activityPoints) return false
        if (age != other.age) return false
        if (premiumLevel != other.premiumLevel) return false
        if (loginName != other.loginName) return false
        if (password != other.password) return false

        return true
    }
}

// enum class -> 열겨형 : 정의된 범주의 상수만 해당 열거형 데이터로 지정 가능 -> name과 ordianl(0부터 자신의 순차번호) 번호가 있음
// 활용도가 높음및
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    BLACK(0xFFFFFF),
    WHITE(0x000000)
}

enum class WeekDays(val kr: String) {
    SUN("일요일"), MON("월요일"), TUE("화요일"), WED("수요일"), THU("목요일"), FRI("금요일"), SAT("토요일")
}

enum class MemberShip(var aPoint: Double = 0.0, val desp: String = "기본회원") {
    BASIC, FAMILY(3000.0, "가족 회원"), PREMIUM(5000.0, "프리미엄 회원등급"), VIP(10000.0, "최고회원 등급");
    // 콤마로 구분하다가 뒤에 함수가 오니까 ; 으로 구분 //코틀린에서는 ; 생략가능

    fun showCard() {
        println("""
        ======================================================
                ${this.name} MemberShip
                $desp
                point : ${aPoint}, ${this.ordinal+1} of ${MemberShip.values().size} // 
        ======================================================
        """)
    }
}

fun findMemberShip(ap: Double){
    if (ap < 0.0)
        return

    val ms: MemberShip = MemberShip.values().filter { it.aPoint <= ap }.last()
    println("ms = ${ms}, ${ms.desp}")
}

fun findMemberShip2(ap: Double, mb: Member_data? = null){
    if (ap < 0.0)
        return

    val ms: MemberShip = MemberShip.values().filter { it.aPoint <= ap }.last()
    println("$ap = ${ms}, ${ms.desp}")

    mb?.let { //mb가 null이 아니라면 정의 해라
        it.activityPoints = ap
        it.ms = ms
        it.premiumLevel = (ms == MemberShip.PREMIUM || ms == MemberShip.VIP)
        println("\n회원 : $it \n")
    }
}

fun main() {

//    MemberShip.values().forEach { it.showCard() }
//    println()
//    findMemberShip(3000.0)
//    findMemberShip(6000.0)
//    findMemberShip(1000.0)
//    findMemberShip(5000.0)
//    findMemberShip(20000.0)

    val mb1 = Member_data(name = "원종우", loginName = "WON_ㅇ")
    println("${mb1.name}의 맴버쉽 ${mb1.ms}")
    findMemberShip2(3100.0, mb1)
    mb1.ms.showCard()
    findMemberShip2(5100.0, mb1)
    mb1.ms.showCard()
    findMemberShip2(11100.0, mb1)
    mb1.ms.showCard()

//    val d1: Direction = Direction.EAST
//    println("d1 = ${d1}")
//
//    val cr1: Color = Color.BLACK
//    println("cr1.toString() = ${cr1.toString()}")
//    println("cr1.rgb = ${cr1.rgb}")
//    println("cr1.rgb = 0x${cr1.rgb.toString(16).toUpperCase()}")
//    println("cr1.name = ${cr1.name}")
//    println("cr1.ordinal = ${cr1.ordinal}")
}

//7-4
//fun main() {
//
//
//
//    val mb1 = Member_data() // data클래스 DTO
//    val mb2 = Member_data()
//
//    if (mb1.equals(mb2))
//        println("mb1과 mb2는 내용이 같습니다. (equals)")
//    // 두개가 같은것인데 코틀린에서는 아래것을 선호
//    if (mb1 == mb2)
//        println("mb1과 mb2는 내용이 같습니다.(==)")
//
//    if (mb1 === mb2)
//        println("mb1과 mb2는 내용이나 주소가 같지 않습니다(===)")
//
//    if (mb1 !== mb2)
//        println("mb1과 mb2는 내용이나 주소가 같지 않습니다(!==)")
//
//    // 문자열 객체로 메모리 비교
//    val str0 = "xyz"
//    val str1: String = "ABCDE"
//    val str2 = str1
//    val str3 = ('A'..'E').joinToString("") // "ABCDE"
//    val str4 = "ABCDE"
//    val str5 = String("ABCDE".toCharArray()) // charArrayOf로 해도됨
//
//    println("내용 : str0 = ${str0} str1 = ${str1} str2 = ${str2} str3 = ${str3} str4 = ${str4} str5 = ${str5}")
//
//    println()
//
//    println("equality str1 == str0 => ${str1 == str0}") // 내용만 비교
//    println("identical str1 === str0 => ${str1 === str0}") // 내용과 주소도 비교
//
//    println()
//
//    println("equality str1 == str2 => ${str1 == str2}")
//    println("identical str1 === str2 => ${str1 === str2}")
//
//    println()
//
//    println("equality str1 == str3 => ${str1 == str3}")
//    println("identical str1 === str3 => ${str1 === str3}")
//
//    println()
//
//    println("equality str1 == str4 => ${str1 == str4}")
//    println("identical str1 === str4 => ${str1 === str4}")
//
//    println()
//
//    println("equality str1 == str5 => ${str1 == str5}")
//    println("identical str1 === str5 => ${str1 === str5}")
//
//    val str6a = String(charArrayOf('A', 'B', 'C', 'D', 'E'))
//    val str6b = String(charArrayOf('A', 'B', 'C', 'D', 'E'))
//
//    println("str6a == str6b => ${str6a == str6b}")
//    println("str6a === str6b => ${str6a === str6b}")
//
//    val memberMgr = MemberManager()
//    memberMgr.joinMember(Member_data(name = "원종우", loginName = "won_ㅇ", password = "ㅇㅇ"))
//    memberMgr.joinMember(Member_data(name = "손ㅇ", loginName = "son_ㅇ", password = "ㅇㅇ"))
//    memberMgr.joinMember(Member_data(name = "이ㅇ, loginName = "lee_ㅇ", password = "ㅇㅇ"))
//
//    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`)) // `in`이라 표시하는 이유는 코틀린에서 in is as 이런것들은 키워드이기 때문에
//
//    println("** 로그인 체크 **")
//    print(">> login : ")
//    val login = br.readLine()
//    print(">> password : ")
//    val pass = br.readLine()
//
//    println("\n\n 로그인 결과 : => " + memberMgr.loginMember(login, pass))
//
//}


//7-1
//fun main() {
////    Member() // db members table -- 레코드(record) 행 하나를 가져와 맴버 객체에 담음
//    val humanMembers = arrayListOf<Member>(Member(), Member("원종우", 22, "won", "xhltkgkwk"))
//
//    humanMembers[1].id = 1 // setter 접근 호출
//
//    val mb2 = Member(2, "손ㅇ", 2.0, 24, true, "hwamin", "ㅇ하자")
//    val mb3 = humanMembers[1].copy(age = 26, loginName = "ㅇ하자", password = "20200430")
//    val mb4 = mb2.copy(name = "신유주", age = 25, loginName = "sin")
//
//    humanMembers.add(mb2)
//    humanMembers.add(mb3)
//    humanMembers.add(mb4)
//
//    humanMembers.forEach{println("member : ${it.toString()}")}
//}

// 7-2
//fun main() {
//    // tuples
//    val backpack = Pair(10, "ㅇ")
//    println("backpack.toString() = ${backpack.toString()}")
//    println("backpack.javaClass = ${backpack.javaClass}")
//    println("backpack.first = ${backpack.first}")
//    println("backpack.second = ${backpack.second}")
//
//    val backpack2 = Triple(20, "20200430", "ㅇ")
//    println("backpack2.toString() = ${backpack2.toString()}")
//    println("backpack2.javaClass = ${backpack2.javaClass}")
//    println("backpack2.first = ${backpack2.first}")
//    println("backpack2.second = ${backpack2.second}")
//    println("backpack2.third = ${backpack2.third}")
//
//    // member data class
//    val mb0 = Member_data()
//    val mb1 = Member_data(1, "원종우", 5.5,22,true, "xhltkgkwk")
//    val mb2 = Member_data(2, "손ㅇ", 2.0, 24, true, "hwamin", "ㅇ하자")
//
//
//    mb2.age = mb2.age + 1 // getter, setter 둘다 사용함
//    mb2.password = "20200430"
//
//    val mb3 = mb2.copy()
//    val mb4 = mb1.copy(activityPoints = 175.3, loginName = "akjshdlkjahskldjhaslkdhakljshd")
//
//
//    // 회원가입 -> 리스트 출력
//    println()
//
//    val memberMgr = MemberManager() // 생성자가 하나도 없을 떄는 주요생성자가 default로 만들어짐
//    memberMgr.joinMember(mb0)
//    memberMgr.joinMember(mb1)
//    memberMgr.joinMember(mb2)
//    memberMgr.joinMember(mb3)
//    memberMgr.joinMember(mb4)
//
//    memberMgr.showAllMembers()
//
//}


