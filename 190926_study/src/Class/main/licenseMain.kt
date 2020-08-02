package Class.main
import Class.license_code.* // 클래스 전체 임폴트 private일떄 그 해당 클래스는 안보임
import Class.license_code.LicenseKey // 클래스만 임폴트
import Class.license_code.getCode // 함수만 임폴트
import java.util.* // 자바것도 임폴트 가능 (코틀린은 자바기반)

//fun main() {
////    val c1: Code = Code()
////    println(getCode(null, null))
////    println(getCode("퇴사", null))
////    println(getCode("퇴사", 7))
//
////    fun localFun() { // 함수안에 함수가 정의 가능 용도는 거의 없음 // 로컬 범위의 제안자에서는 internal과 같은 가시성을 가진 것을 정의 할 수 없음
////        println("local test")
////    }
//
////    localFun()
//
//    val lc1 = getLicenseKey("퇴사20200430")
//    val lc2 = getLicenseKey("퇴사", 6)
//
//    println("lc1 = ${lc1}")
//    println("lc2 = ${lc2}")
//
//}

fun main() {
//    printLincenseKey(null, "종우", 1, "종우의 테스트 키")
//    println()
//    printLincenseKey(LicenseKey(), "홤니", 2, "홤니의 디폴트 라이센스 키")
//    println()
//    printLincenseKey(LicenseKey(), "원종우", 3, "퇴사")

    printLincenseKey2(null, "종우", 1, "종우의 테스트 키")
    println()
    printLincenseKey2(LicenseKey(), "홤니", 2, "홤니의 디폴트 라이센스 키")
    println()
    printLincenseKey2(LicenseKey(), "원종우", 3, "퇴사")
}

internal fun printLincenseKey(lcKey: LicenseKey?, issuer: String, order: Int, desc: String) { // let을 사용한 것
    lcKey?.let { // lcKey.let({ }) 와 같음 // 객체 자체가 인자로 들어감.. it으로 사용
        it.issuedWhen = Date()
        it.issuedBy = issuer
        it.issuedNumber = order
        it.description = desc

        it.generate()
        val br = "=".repeat(56)
        println("""
            |$br
            |       ******** License Key ********
            |       issued by ${it.issuedBy} at ${it.issuedWhen}
            |       serial number : 1911${it.issuedNumber}
            |       License Key : ${it.key}
            |       desc : ${it.description}
            |
            |$br
        """.trimIndent())
    } ?: println("lckey is null")
}

internal fun printLincenseKey2(lcKey: LicenseKey?, issuer: String, order: Int, desc: String) { // with를 사용한 것

    if(lcKey == null) {
        println("lckey is null")
        return
    }
    with(lcKey) { // with 블록내에서는 this가 이미 존재함
        issuedWhen = Date()
        issuedBy = issuer
        issuedNumber = order
        description = desc

        generate()
        val br = "=".repeat(56)
        println("""
        |$br
        |       ******** License Key ********
        |       issued by ${issuedBy} at ${issuedWhen}
        |       serial number : 1911${issuedNumber}
        |       License Key : ${key}
        |       desc : ${description}
        |
        |$br
    """.trimIndent())
    }
}