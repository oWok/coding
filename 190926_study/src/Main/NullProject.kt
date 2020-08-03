package Main

fun main() {
    var a: String = "ㅇ" // non-null -> null이 불가능한 타입
    var b: String? = "2020년 5월 7일" // nullable -> null이 가능한 타입

    println("a.length = ${a.length}")
    //println("b.length = ${b.length}")    // null 일수도 있기 때문에 error이 남
    println("b.length = ${b?.length}")    // 변수? -> safe call로 null이 아닐때만 뒤를 참조하거나 호출할수 있음
    b = null
    //println("b!!.length = ${b!!.length}") // nullable 타입이더라도 null일지 몰라도 무조건 참조, 호출 -> null이라면 예외 발생
    println("b.length = ${b?.length ?: "$b length를 알 수 없음" }")//값이 null일때 값을 알수 없음 이라고 표기 할떄-> Elvis operator (엘비스 연산자)

    println(joinForm("원종우", 26))
    println(joinForm(null, 26) ?: "가입내용이 누락되었습니다") // null
}

//널 가능형 타입을 리턴하는 함수
fun joinForm(name: String?, age: Int): String? {
    val result =
        if(name != null) "$name 가입 ($age 세)"
        else null
    return result
}