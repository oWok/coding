package Class.urlChecker

class UrlChecker {
    private val DEF_URL = "http://bueongine.com" // private -> 내부에서만 사용 / 밖에서는 안보임
    var url: String = initMyUrl() // 초기화 / initMyurl() == ""
    var description: String? = null  // val은 getter만 되고 var은 getter, setter 둘다 가능
        get() = field ?: "설명이 아직 없음 퇴사하셈"
        set(value) { // value 대신 아무꺼나 써도됨 // custom setter
            if(!value.isNullOrEmpty())
                field = value
        }

    val isHttp: Boolean // kotlin 1.1 버전 이후는 타입 생략가능
        get() = url.startsWith("http://")

    val isHttps
        get() = url.startsWith("https")

    fun showUrl() {
        println("""
            -------------------------------------------------
                        url  : $url
                        설명 : $description
                        http프로토콜 : ${if(this.isHttp) "Yes" else "No"}
                        https프로토콜 : ${if(this.isHttps) "Yes" else "No"}
            -------------------------------------------------
        """.trimIndent())
    }

    private fun initMyUrl(): String {
        println("url초기화 함수")
        return ""
    }

    // 2차 생성자
    constructor(_url: String?) {
        this.url = _url ?: DEF_URL
        println("2차생성자 실행")
    }

    // 1차 생성자
    init {
        println("초기화 블럭 init 실행")
    }
}

fun main() {
    val url1 = UrlChecker("http://www.bueong-ine.com\n")
//    println("url1.url = ${url1.url}") // getter
    url1.description = "퇴사 예정인 원종우입니다."
    url1.showUrl()

    val url2 = UrlChecker(null)
//    println("url2.url = ${url2.url}") // getter
    url2.description = "대구 맛집 부엉이네 숯불구이"
    url2.showUrl()

    val url3 = UrlChecker("ftp://owo.com")
    url3.description = null
    url3.showUrl()
}
