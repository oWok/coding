package Main

fun main(args: Array<String>) {
    //Range <==> Array 두개는 거의 비슷함
    val naturalNumber = 1..100 //.. -> range의 표현법 (min 이상 max 이하) / range는 비교가 가능해야함
    val r = 1..(99+1)
    val r2 = IntRange(1,10)
    val arr: IntArray = r.toList().toIntArray()
    val arr1: Array<Int> = r.toList().toTypedArray()

    val r3 = 100..200 // .. 은 rangeTo() 함수와 같은 표현
    val r4 = 100..200-1 // 200 미포함 / 같은 표현으로는 r4 = 100 until 200
    val r5 = 100 until 200 // 100이상 200미만
    val r6 = 200 downTo 100 // 200부터 100 까지 내려감 ..은 +1 씩 downTo는 -1 씩
    val r7 = (200 downTo 100).step(20) // 200부터 100까지 20단위로 내려감
    val r8 = (1..100).step(33) // 1부터 100까지 33 단위로 올라감
    val r9 = (0 until 100).step(33) // 0부터 99까지 33 단위로 올라감
    println("r7.joinToString(\",\") = ${r7.joinToString(", ")}")
    println("r8.joinToString(\",\") = ${r8.joinToString(", ")}")
    println("r9.joinToString(\",\") = ${r9.joinToString(", ")}")

    println("-----------------------------------------------------------")

    println("r3.last = ${r3.last} r4.last = ${r4.last} r5.first = ${r5.first}")

    println("-----------------------------------------------------------")

    for(number in naturalNumber){
        if(number % 2 == 0)
            print("even number : ${number}   ")
    }
    println()


    println("-----------------------------------------------------------")

    for(number2 in 2L..20L step 2L){
        print("long even number2 = ${number2}")
    }

    println("-----------------------------------------------------------")
    println("(1..20).filter {   } = ${(1..20).filter { it % 2 == 0 }}") // 앞의 값을 받아와 조건에 만족하면 출력

    println("-----------------------------------------------------------")

    for((i, n) in (50..80 step 5).withIndex()) // 50부터 80까지 5씩 증가 해서 n에 저장
        println("${i+1}번째 값 --> $n")

    println("-----------------------------------------------------------")

    //printGuGuDan()

    print("시작하는 수 입력 : ")
    var start_num = readLine()!!.toInt()
    print("끝나는 수 : ")
    var end_num = readLine()!!.toInt()
    println("${start_num} + ${end_num} = ${sumOfBetween(start_num, end_num)}")

}

fun sumOfBetween(start: Int, end: Int):Int {
    var sum: Int = 0

    when {
        end >= start -> {
            for(i in (start..end))
                sum+=i
        }
        else -> {
            for(i in (end..start))
                sum+=i
        }
    }

    return sum
}

fun printGuGuDan(){
    for(i in 2..9){
        println("$i 단")
        for(j in 1..9)
            println("$i * $j = ${i*j}")

        println()

    }
}