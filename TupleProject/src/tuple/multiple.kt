package tuple

fun main() {
    // tuple (x, y, z) mixed type
    // destrucutring

    Pair(1, "퇴사").first // 1 => component1()
    Pair(1, "퇴사").second // "퇴사" => component2 == Pair(1, "퇴사").component2()

    val (num, char) = Pair(1, "퇴사") // num -> 1 char -> 퇴사 // Pair<Int, String>(1, "퇴사") 타입을 명시 해줄 수 있음
    val (num1: Int, str: String) = Pair(2, "토ㅣ사")

    println("num = $num")
    println("str = $str")

    val (i, you, we) = Triple("ㄱ", "ㅈ", "ㄷ")
    val t3 = Triple("ㄱ", "ㅈ", "ㄷ").component3() // .third
    println("i = $i, you = $you, we = $we, $t3")

    for((i, c) in ('A'..'Z').withIndex()){
        print("$i => $c \t")
    }
    println()

    val planets = mapOf<Int, String>(0 to "earth", Pair(1, "Mars"), 2.to("jupiter"), 3 to "saturn", 4.to("pluto?"))

    for((k, v) in planets)
        print("$k => $v\t") // Map.Entry<K, V> k=> componet1 v=> componet2
//    public inline operator fun <K, V> Map.Entry<K, V>.component1(): K = key
//    public inline operator fun <K, V> Map.Entry<K, V>.component2(): V = value
    println()

    planets.mapValues { (k, v) -> "solar system $k: $v" }
    planets.mapValues { (_, v) -> "solar system: $v" }.forEach { println(it.value) } // 여기에서 it은 mapEntry .value는 벨류값만 나오고 .key는 키값만 나옴
    // mapValues에서 사용하지 않을꺼면 "_"를 통해 사용하지 않는다고 표기


    // color

    var cr = MyColor()
    val cr1 = MyColor("556BEF", "다크올리브그린", 50.0)
    val (hex, name) = cr1 // cr1.compoent1()과 cr1.compoent2()가 자동으로 들어가 있음
    val used = cr1.component4() // == val (_, _, _, used) = cr1
    val (R, G, B) = cr1.getEachHex()

    println("cr1: $cr1")
    println("hex : 0x$hex, name : $name, fav : ${cr1.component3()}, used : $used")
    println("R : 0x$R, G : 0x$G, B : 0x$B")
//    println("${cr1.component5()}") // error

    val (crR, crG, crB, crA) = cr1.getRGBA()

    for((a, b, c, d) in listOf(RGBA(255, 0, 0, 123), RGBA(0, 255, 0, 230), RGBA(0, 0, 255, 0),
        RGBA(255, 255, 255, 255))) {
        println("color => R : $a, G : $b, B : $c, Alpha : $d")
    }
}

val BLACK = "000000" // hexadecimal
// DarkOliveGreen 55 6B 2F  -> 85 107 47
data class MyColor(val hexCode: String = BLACK, val name: String = "Black", val fav: Double = 0.0, val used: Boolean = false) {
    private val r: String = hexCode.slice(0..1)
    private val g: String = hexCode.slice(2..3)
    private val b: String = hexCode.substring(4..5)

    fun getEachHex() = Triple(r, g, b) // private로 위에 선언된 변수와 같은것이 있을때 밑에 것과 동일함
//    fun getEachHex() = Triple(hexCode.slice(0..1), hexCode.slice(2..3), hexCode.substring(4..5))
//     코틀린에서는 slice를 자바등에서는 subString을 많이 사용 x..y => x부터 y까지

    fun getRGBA() = RGBA(r.toInt(16), g.toInt(16), b.toInt(16), 0)
}

data class RGBA(val r: Int, val g: Int, val b: Int, val a: Int) { // 0은 불투명 255(FF)는 투명

}