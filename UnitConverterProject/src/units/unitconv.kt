package units

val DEF_DATA_UNIT = "kb"
val DEF_LENGTH_UNIT = "m"
val DEF_WEIGHT_UNIT = "kg"

// 확장 프라퍼티
// data size (1kb)
val Double.bit get() = 8192 * this
val Double.b get() = 1024 * this
val Double.kb get() = this
val Double.mb get() = 0.000977 * this
val Double.gb get() = 9.5367e-7 * this
val Double.tb get() = 9.3132e-10 * this
val Double.pb get() = 9.0949e-13 * this
val Double.eb get() = 8.8818e-16 * this

// length (1m)
val Double.mm get() = 1000 * this
val Double.cm get() = 100 * this
val Double.m get() = this
val Double.km get() = 0.001 * this
val Double.inch get() = 39.370079 * this
val Double.ft get() = 3.28084 * this
val Double.yd get() = 1.093613 * this
val Double.mi get() = 0.000621 * this

// weight (1kg)
val Double.mg get() = 1000000 * this
val Double.g get() = 1000 * this
val Double.kg get() = this
val Double.t get() = 0.001 * this
val Double.kt get() = 1e-6 * this
val Double.gr get() = 15432.3584 * this
val Double.oz get() = 35.273962 * this
val Double.lb get() = 2.204623 * this

// 공통 변환 구조
interface Conv {
    fun conv(from :Double): String
}

// String extension func....... pair
fun String.toUc(): Pair<Double, String> = Pair(this.split(" ").first().toDouble(), this.split(" ").last())
//{
//    val d: Double = this.split(" ").first().toDouble()
//    val u: String = this.split(" ").last()
//    return Pair(d, u)
//
//    return Pair(this.split(" ").first().toDouble(), this.split(" ").last())
//}

// 유닛 변환 랩퍼 클래스
class UnitConverter(val input: String) {
    lateinit var uc: Conv

    fun showConvertedTable() {
//        val inputValue: Double = input.split(" ").first().toDouble()
//        val inputUnit: String = input.split(" ").last()

        val (inputValue, inputUnit) = input.toUc()
        when(inputUnit) {
            DEF_DATA_UNIT -> {this.uc = DataUnit()}
            DEF_LENGTH_UNIT -> {this.uc = LengthUnit()}
            DEF_WEIGHT_UNIT -> {uc = WeightUnit()}
            // new unit -> {변환처리} 추가
            else -> {
                println("변환이 아직 구현되지 않았습니다 / 2020년 04월 30일 퇴사 이후 구현 하도록 하겠습니다.")
                return
            }
        }
        println(this.uc.conv(inputValue)) // 인터페이스 다형성 메소드 호출출
    }

   // Data
    inner class DataUnit: Conv {
        override fun conv(from: Double): String {
            return """
                |=============================================
                |       Data $from kb  ==>  
                |--------------------------------
                |       ${from.bit} bit
                |       ${from.b} byte
                |       ${from.mb} mb
                |       ${from.gb} gb
                |       ${from.tb} tb
                |       ${from.pb} peta byte
                |       ${from.eb} exa byte
                |=============================================
            """.trimMargin()
        }
    }

    // length
    inner class LengthUnit: Conv {
        override fun conv(from: Double): String {
            return """
                |=============================================
                |       Length $from m  ==>  
                |--------------------------------
                |       ${from.mm} mm
                |       ${from.cm} cm
                |       ${from.km} km
                |       ${from.inch} inch
                |       ${from.ft} ft
                |       ${from.yd} yd
                |       ${from.mi} mile
                |=============================================
            """.trimMargin()
        }
    }

    // weight
    inner class WeightUnit: Conv {
        override fun conv(from: Double): String {
            return """
                |=============================================
                |       Weight $from kg  ==>  
                |--------------------------------
                |       ${from.mg} mg
                |       ${from.g} g
                |       ${from.t} ton
                |       ${from.gr} grain
                |       ${from.oz} oz
                |       ${from.kt} kt
                |       ${from.lb} lb
                |=============================================
            """.trimMargin()
        }
    }


}

fun main() {
    val l: List<Int> = listOf(1, 2, 3)
    l.lastIndex

    UnitConverter("2048.0 kb").showConvertedTable()
    UnitConverter("20200501.0 m").showConvertedTable()
    UnitConverter("20200430.0 kg").showConvertedTable()


}


/*
8192비트(bit) 1024바이트(B) 1킬로바이트(KB) 0.000977메가바이트(MB)
9.5367e-7기가바이트(GB) 9.3132e-10테라바이트(TB) 9.0949e-13페타바이트(PB) 8.8818e-16엑사바이트(EB)
 */

/*
길이 length (1 m)
1000밀리미터(mm)  100센티미터(cm) 1미터(m) 0.001킬로미터(km) 39.370079인치(in)
3.28084피트(ft)  1.093613야드(yd) 0.000621마일(mile)
 */

/**
질량 무게 weight (1 kg)
1000000밀리그램(mg)  1000그램(g) 1킬로그램(kg) 0.001톤(t) 1e-6킬로톤(kt)
15432.3584그레인(gr)  35.273962온스(oz)  2.204623파운드(lb)
 */