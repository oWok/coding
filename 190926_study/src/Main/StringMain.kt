package Main

fun main(args: Array<String>) {
    val str1: CharArray = charArrayOf('a','b','c')
    val str2: String = "ABCDEFGHI"

    println("str1 = ${str1.joinToString("")}")
    println("str2 = ${str2.toCharArray().joinToString(", ")}")

    val c0 = str2.get(2)
    val c1 = str2[0]
    //str2[1] = '2' // 불변 set이 없음

    println("c0 = ${c0} c0 = ${c0.toInt()} c0 = ${c0.javaClass}")
    println("clast = ${str2[str2.lastIndex]} ${str2[str2.lastIndex].toInt()} ${str2[str2.lastIndex].javaClass}")


    println("-----------------------------------------------------------")

    //2차원 배열 | 코틀린에서는 아직 공식적으로 지원하지는 않음
    var numbers2d = Array(3, {IntArray(4)}) // 3행 4열 배열 생성
    // row 0 1 2 / column 0 1 2 3 -> 총 12개의 요소
    // Array(m, {oooArray(n)}) -> m * n 의 2차원 배열
    // Array(m, {oooArray(n, {initial})}) -> m * n 의 2차원 배열 -> initial로 초기화

    val numbers2dZero = Array(3, {IntArray(4, {0})})

    for ((i, row) in numbers2dZero.withIndex()){
        for ((j, col) in row.withIndex())
            print("[$i ,$j] => $col\t")

        println()
    }

    println("-----------------------------------------------------------")
    // 0이 아니라 다른것으로 초기화된 2차원 배열
    val numbers2dOrdered = Array(3, { i -> IntArray(4, {j -> j + i*4})}) // i -> 행번(0, 1, 2) j-> 열번(0, 1, 2 ,3)
    for ((i, row) in numbers2dOrdered.withIndex()){
        for ((j, col) in row.withIndex())
            print("[$i ,$j] => $col\t")

        println()
    }

    println("-----------------------------------------------------------")
    //args: Array<String> --> Array<Array<Char>>

    val myFriends = arrayOf<String>("가", "나남나", "다", "라")

    if(myFriends[0] == "가")
        println("첫번째 친구의 이름 : ${myFriends[0]}")

    if(myFriends[1][2] == '나')
        println("두번째 친구의 마지막글자는 : ${myFriends[1][2]}")

    println("가장 이름이 긴 사람의 문자 길이 = ${myFriends.map { it.length }.max()}")

}