//package Problem
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//
////수치 한글 변환 프로그램
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
//    /*
//    number % 4 ==
//    */
//
//    val title = """
//======================================================================
//               One To Googol <수치 한글 변환 프로그램>
//======================================================================
// 예) 543021 ==> 오십사만 삼천이십일
// 1234567890123456790 ==> 천이백삼십사경 오천육백칠십팔조 구천십이억 삼천사백오십육만 칠천팔백구십
// 10001000100010001000 ==> 백경 백조 백억 백만 백
//
//한국어	        한자
//일	            一/壹	        10^0
//십	            十/拾	        10^1
//백	            百/佰/陌	    10^2
//천	            千/仟/阡	    10^3
//만	            萬/万	        10^4
//억	            億	            10^5
//조	            兆	            10^6
//경	            京	            10^7
//해	            垓	            10^8
//자	            秭	            10^9
//양	            穰/壤	        10^10
//구	            溝	            10^11
//간	            澗	            10^12
//정	            正	            10^13
//재	            載	            10^14
//극	            極	            10^15
//항하사	        恒河沙	        10^16
//아승기	        阿僧祇	        10^17
//나유타	        那由他	        10^18
//불가사의        不可思議	    10^19
//무량수/무량대수	無量數/無量大數	10^20
//구골            Googol          10^100
//    """.trimIndent()
//
//    print("한글로 변경하고 싶은 숫자를 입력 : ")
//    val input_number:String = readLine()
//    var numberToString: String = ""
//    var check_num = input_number.split("")
//
//
//
//    for(i in 0 until input_number.length/4){
//        if(i > 0)
//            numberToString += " "
//
//        when(i) {
//            1 -> numberToString += "만"
//            2 -> numberToString += "억"
//            4 -> numberToString += "조"
//            5 -> numberToString += "해"
//            6 -> numberToString += "자"
//            7 -> numberToString += "양"
//            8 -> numberToString += "구"
//            9 -> numberToString += "간"
//            10 -> numberToString += "정"
//            11 -> numberToString += "재"
//            12 -> numberToString += "극"
//            13 -> numberToString += "항하사"
//            14 -> numberToString += "아승기"
//            15 -> numberToString += "나유타"
//            16 -> numberToString += "불가사의"
//            17 -> numberToString += "무량대수"
//            18 -> numberToString += "구골"
//        }
//
//
//        when(i) {
//            1 -> numberToString += "만"
//            2 -> numberToString += "억"
//            4 -> numberToString += "조"
//            5 -> numberToString += "해"
//            6 -> numberToString += "자"
//            7 -> numberToString += "양"
//            8 -> numberToString += "구"
//            9 -> numberToString += "간"
//            10 -> numberToString += "정"
//            11 -> numberToString += "재"
//            12 -> numberToString += "극"
//            13 -> numberToString += "항하사"
//            14 -> numberToString += "아승기"
//            15 -> numberToString += "나유타"
//            16 -> numberToString += "불가사의"
//            17 -> numberToString += "무량대수"
//            18 -> numberToString += "구골"
//        }
//
//        for(j in 0 until 4){
//
//            if(j != 0) {
//                when (j) {
//                    1 -> numberToString += "십"
//                    2 -> numberToString += "백"
//                    3 -> numberToString += "천"
//                }
//            }
//
//            when(j) {
//                0 -> {
//                    when(check_num){
//                        1 -> numberToString += "일"
//                        2 -> numberToString += "이"
//                        3 -> numberToString += "삼"
//                        4 -> numberToString += "사"
//                        5 -> numberToString += "오"
//                        6 -> numberToString += "육"
//                        7 -> numberToString += "칠"
//                        8 -> numberToString += "팔"
//                        9 -> numberToString += "구"
//                    }
//                }
//                else -> {
//                    when(check_num) {
//                        2 -> numberToString += "이"
//                        3 -> numberToString += "삼"
//                        4 -> numberToString += "사"
//                        5 -> numberToString += "오"
//                        6 -> numberToString += "육"
//                        7 -> numberToString += "칠"
//                        8 -> numberToString += "팔"
//                        9 -> numberToString += "구"
//                    }
//                }
//            }
//        }
//    }
//
//    println(numberToString)
//}
//
///*val digit_one = listOf<String>("", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구")
//val digit_ten = listOf<String>("", "십", "백", "천")
//val digit_bel = listOf<String>("", "만", "억", "조", "경", "해", "자", "양", "구", "간", "정", "재", "극", "항하사", "아승기", "나유타", "불가사의", "무량대수", "구골")
//val number_length: Int = input_number.length
//var count: Int = 0
//var numberToString: String = ""
//
//for(i in (number_length/4) downTo  1){
//    count++
//    if(count == 4)
//    //numberToString += " "
//
//        for(j in 1..4){
//            if(j != 3 && (input_number.split("")).equals("1")){
//                when (j) {
//                    2 -> numberToString += "십"
//                    1 -> numberToString += "백"
//                    0 -> numberToString += "천"
//                }
//            }
//        }
//
//}
//
//println(numberToString)*/
//
//
//
///*
//
//*/
