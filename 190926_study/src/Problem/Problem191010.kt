package Problem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    //화씨 -> 섭씨 / 섭씨 -> 화씨 로 상호변환하는 프로그램

    val st = StringTokenizer(readLine())
    var input_Tem: Double = st.nextToken().toDouble()
    var input_Txt: String = st.nextToken()
    var change_Tem: Double = 0.00

    //if문을 사용한 변환
//    if(input_Txt.equals("C") || input_Txt.equals("c")){
//        change_Tem = input_Tem * 1.8 + 32
//        println("${"%.2f".format(change_Tem)} F")
//    }
//    else if(input_Txt.equals("F") || input_Txt.equals("f")){
//        change_Tem = (input_Tem-32)/1.8
//        println("${"%.2f".format(change_Tem)} C")
//    }
//    else{
//        println("잘못된 단위 입니다.")
//    }

    //when을 사용한 변환
    when(input_Txt.toUpperCase()){
        "C" -> {
          change_Tem = input_Tem*1.8 + 32
          println("${"%.2f".format(change_Tem)} F")
        }
        "F" -> {
        change_Tem = (input_Tem-32)/1.8
        println("${"%.2f".format(change_Tem)} C")
        }
        else -> println("잘못된 접근입니다.")
    }
}