package Class.license_code

// private -> 해당 클래스 내에서만 사용가능
// protected -> 상속 받는 경우 사용
// internal -> 모듈 기준 사용 // 탑레벨 클래스에서만 사용 가능
// public -> 기본 - 생략가능

// 주어진 길이만큼 영문대문자와 숫자들로 이루어진 임의의 코드 문자열 생성하는 클래스
// 알파벳 26개 + 숫자 10개 임의 생성 => 중복?
// private class -> 패키지 안에서만 사용가능
private class Code(pre: String = "", len: Int = 8) {
    val _c: String // = "xxx"
    init {
        _c = pre + "_" + generateCode(len) //"abcdefg"
    }

    private fun generateCode(upto: Int): String { // private fun은 해당 클래스 안에서만 보임
        val chars = CharArray(upto) // 만들어진 코드 저장용
        val nums = ('0'..'9').toList() // 번호가 있는 문자리스트 생성
        val alphas = CharRange('A','Z').toList() // CharRange는 범위를 나타낼때 .. 이 아닌 , 로 구분

        for(i in 0 until upto) {
            val ran = (Math.random() * 10).toInt() // 0 ~ 9 사이의 임의의 수가 나옴

            chars[i] = 
                if(ran % 2 == 0)
                    nums[(Math.random() * nums.size).toInt()]
                else
                    alphas[(Math.random() * alphas.size).toInt()]
        }
        
        return chars.joinToString("")
    }
}

//fun getCode(pre: String?, len: Int?): String {
//    return Code(pre ?: "", len ?: 8)._c
//}

fun getCode(pre: String?, len: Int?) = Code(pre ?: "", len ?: 8)._c

// val variable = 123 // public가 생략되어 있음
// internal val stringx = "123"
// Maven, Gradle, Ant 알아두기
// protected fun getLicenseKey(lcpre: String? = "", count: Int = 4): String { // 탑레벨 수준의 선언과 정의에서는 프로텍트 가시성 제안자는 사용할 수 없음 // 상속에서 볼 수 있음
internal fun getLicenseKey(lcpre: String? = "", count: Int = 4): String { // java의 default와 비슷함 // 코틀린에서는 모듈(코틀린 안에서 작은 프로젝트 단위) 안에서 보이는 단위
    var str: String = ""

    for(i in 1..count)
        str += getCode("", 8)

    return lcpre + str
}

internal class LicenseKey(var issuedBy: String? = null, var description: String? = null, var issuedNumber: Int = 0, var words: Int = 4) { // 4개의 프라퍼티를 가지고 있는 internal 클래스
    var key: String? = null // 키를 볼수는 있지만 수정은 불가능
        private set
    var issuedWhen: java.util.Date? = null

    fun generate() {
        this.key = getLicenseKey(issuedBy ?: "tester", words)
    }
}

//fun main() {
//    println("Code()._c = ${Code()._c}")
//    println("Code(\"ㅇ\")._c = ${Code("ㅇ")._c}")
//    println("Code(\"ㅇ\")._c = ${Code("ㅇ", 10)._c}")
//}