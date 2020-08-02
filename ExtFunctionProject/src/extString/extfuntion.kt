package extString
import java.lang.Math.random
import java.nio.charset.Charset
import java.security.MessageDigest

// 정수 수치형의 확장
fun Int.code(): String { // Receiver type
    val c = ('A'..'Z').toList().joinToString("") + ('0'..'9').toList().joinToString("")
//     (range).joinToString는 불가능 (range).toList()를 통해 리스트로 만든후에 joinToString로 짤라줌
    var s = ""

    for(i in 1..this) { // receviver => receiver 오브젝트 Int형의 값이 1 ~ 10이면 1 ~ 10으로 받음?
        s += c[(random() * c.length).toInt()]
    }

    return s
}

// 정수 수치형의 확장2 // 1번과 동일한데 toS()라는 확장 함수를 만들어 두고 그것을 활용하여 만든것
fun Int.code2(): String { // Receiver type
    val c = ('A'..'Z').toS() + ('0'..'9').toS()
//     (range).joinToString는 불가능 (range).toList()를 통해 리스트로 만든후에 joinToString로 짤라줌
    var s = ""

    for (i in 1..this) { // receviver => receiver 오브젝트 Int형의 값이 1 ~ 10이면 1 ~ 10으로 받음?
        s += c[(random() * c.length).toInt()]
    }

    return s
}

// 문자 범위형의 확장1
fun CharRange.toS(): String = this.toList().joinToString("")

// 기본형 Byte 확장 - unsigned byte 흉내
fun Byte.toUInt() = this.toInt() and 0x000000FF // +든 -든 부호비트까지 데이터로 보고 다 담기겟다 // 최하위 비트만 unsinged로 남겨주기 위해

// 문자열형 확장 => hash 코드 함수로 확장
// MD5, SHA-1, SHA-256 해쉬 알고리즘을 사용
// 단방향 해쉬 함수 코드

fun String.hash(algo: String = "MD5"): String {
    val ds = MessageDigest.getInstance(algo)
    ds.update(this.toByteArray()) // 다이제스트할 내용을 버퍼에 채울때 update 함수를 쓰는데 byte를 써도 되지만 byte_array를 권장
    // Charset.defaultCharset() -> UTF_8이 들어가 있음 (유니코드) -> 생략가능 -> 다른 타입이라면 넣어줘야함
    return ds.digest().map{it.toUInt().toString(16).toUpperCase()}.joinToString("") // bytearray! -> 널러블 하거나 널러블하지 않을지 모를때 주로 이것을 씀
    // 코틀린에서 byte를 unsigned하게 인식하지 않음(예전버전 현재버전은 확인해야함)
}

fun String.mask(target: String = " ", using: String): String = this.replace(target, using.hash()) // MD5

fun main() {
    println("6.code() = ${6.code2()}")
    println("12.code() = ${12.code()}")
    println()

    println("20200430 집으로 가자!! => (md5) ${"20200430 집으로 가자!!".hash()}")
    println("20200430 집으로 가자!! => (sha1) ${"20200430 집으로 가자!!".hash("SHA-1")}")
    println("20200430 집으로 가자!! => (sha256) ${"20200430 집으로 가자!!".hash("SHA-256")}")

    println()
    println("""
        |Kotlin provides the ability to extend a class with new functionality 
        |without having to inherit from the class or use design patterns such as Decorator. 
        |This is done via special declarations called extensions. 
        |For example, you can write new functions for a class from a third-party library 
        |that you can't modify. Such functions are available for calling in the usual way as if they were methods of the original class. 
    """.trimMargin().mask("Kotlin", "jetbrain").mask("class", "퇴사").mask("functions", "2020년4월30일").hash("SHA-1").hash("SHA-512"))
}