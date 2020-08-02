package Main

fun main(args: Array<String>) {
    if(isLeepYear(2020))
        println("윤년")
    else
        println("평년")

    println("-----------------------------------------------------------")

    val testYear = intArrayOf(1988, 1992, 1996, 2004, 2008, 2012, 1900, 2100, 2200, 2500, 1600, 2000, 2400, 2016)

    for((i, y) in testYear.withIndex()){
        println("testYear[$i] $y 년 =>  ${ if(isLeepYear(y)) "윤년" else "평년"}")
    }

    println("-----------------------------------------------------------")

    findFirstTenLeepYear(1988, 2024)

}

fun isLeepYear(input_year: Int): Boolean{
    return if(input_year % 4 != 0) false
        else if(input_year % 100 != 0) true
        else if(input_year % 400 != 0) false
        else true
}

fun findFirstTenLeepYear(from: Int, to: Int): IntArray{
    val years = if(from <= to) from..to
    else from downTo to

    val foundLeeps = IntArray(10) // 0으로 초기화 된 상태
    var ly_count = 0

    for((i, y) in years.withIndex()){
        println("${i}번째 실행")
        if(!isLeepYear(y))
            continue

        foundLeeps[ly_count] = y
        println("윤년 발견 : ${foundLeeps.joinToString(", ")}")
        ly_count++

        if(ly_count==foundLeeps.size){
            println("윤년 ${foundLeeps.size}개 다찾음")
            break
}
    }

    return foundLeeps
}