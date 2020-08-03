package Main

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val arr_A = Array(2, {0})
    val arr_B = Array<Int>(3, {0}) // type 제한
    val arr_C = Array<Char>(4,{'k'}) // type 제한 // \u0000 -> null 문자(유니코드)
    val arr_D = Array<String?>(3, {null}) // nullable 타입 -> String? -> 스트링타입의 배열인데 null 값으로 초기화 null 값도 사용가능
    val arr_F: Array<String> = args

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    println("a.size = ${arr_A.size}")
    println("b.size = ${arr_B.size}")
    println("c.size = ${arr_C.size}")
    println("d.size = ${arr_D.size}")
    println("f.size = ${arr_F.size}")

    bw.write("-------------------------------------\n")
    //배열의 값을 가져옴
    bw.write("a.get() = ${arr_A.get(0)}\n")
    bw.write("b.get() = ${arr_B.get(0)}\n")
    bw.write("c.get() = ${arr_C.get(0)}\n")

    bw.write("-------------------------------------\n")
    //배열에 값을 설정
    //arr.set(x, k) -> arr[x] = k
    arr_A.set(0, 1)
    arr_B.set(0, 12)
    arr_C.set(0, 'K')
    arr_D.set(0, "ㅇ")
    arr_D[1] = "하고싶다"
    //arr.get(x) == arr[x]
    bw.write("a.get() = ${arr_A.get(0)}\ta.get() = ${arr_A[0]}\n")
    bw.write("b.get() = ${arr_B.get(0)}\tb.get() = ${arr_B[0]}\n")
    bw.write("c.get() = ${arr_C.get(0)}\tc.get() = ${arr_C[0]}\n")
    bw.write("d.get() = ${arr_D.get(0)}\td.get() = ${arr_D[0]}\n")

    bw.write("-------------------------------------\n")

    bw.write("array D = ${arr_D.joinToString(" ") }\n") //joinToString -> 문자열을 떄엇다 붙엇다 할때 사용하는 매소드

    bw.write("-------------------------------------\n")

    val f1 = arrayOf("ㅇ->", "2020년", "5월 6일", "혹은", "5월 7일")
    val f2: Array<String> = Array(3, {"_"})

    f2[2] = "ㅇ다 ㅇ" // == f2[f2.lastIndex] lastIndex -> 마지막 인덱스
    val goal = f1 + f2 // == arrayOf<tyep>(*f1, *f2) "*" -> 펼침 연산자

    bw.write("${f1.joinToString(" ")}\n")
    bw.write("${goal.joinToString(" ")}\n")
    bw.write("goal.szie = ${goal.size}\n")

    bw.write("-------------------------------------\n")

    val arr_E = arrayOfNulls<String>(3) // 초기에는 무조건 null로 초기화
    bw.write("arr_E[0] = ${arr_E[0]}")

    bw.write("-------------------------------------\n")

    val eng = charArrayOf('a', 'b') // char형 배열 비어있다면 null
    val arr_num = intArrayOf(1,2,3) // int형 배열 비어있다면 null
    val arr_float = floatArrayOf() // float형 배열
    val arr_bool1 = booleanArrayOf(true, true, false) // boolean형 배열
    val arr_bool2 = BooleanArray(3, {true})

    bw.flush()
    bw.close()

}