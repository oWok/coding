package Main

fun main() {
//    while (true){
//        println("Always run!!")
//    }
//
//    while(false){
//        println("never run!!")
//    }

    do{
        println("run once!!")
    }while (false) // false라도 한번은 실행

    println("-----------------------------------------------------------")


    print("소수인지 확인하고 싶은 숫자 입력 : ")
    var input_num: Int = readLine()!!.toInt()
    isPrimeNmber(input_num)


    println("-----------------------------------------------------------")
    val myNumbers = intArrayOf(3,7,9,12,11,15)
    for(i in myNumbers)
        println(isPrimeNuber2(i))


    println("-----------------------------------------------------------")
    isPrimeNumber3(165)

}

fun isPrimeNmber(num: Int){
    println("${num} 소수 판단(for)")

    when {
        num <= 1 -> return
        num == 2 -> println("2눈 소수입니다.")
        num >= 3 -> {
            for(i in 2..num-1){ // 2 until num
                if(num % i == 0){
                    println("${num}은 소수가 아닙니다.")
                    return
                }
            }
            println("${num}은 소수입니다.")
            return
        }
        else -> return
    }
}

fun isPrimeNuber2(num: Int){
    println("${num}소수 판단(while)")

    when {
        num <= 1 -> return
        num ==2 -> println("2는 소수입니다.")
        num >= 3 -> {
            var n = 2
            val end = num - 1
            while(n <= end){
                if(num % n == 0){
                   println("${num}은 소수가 아닙니다")
                   return
                }
                n++
            }
            println("${num}은 소수입니다.")
            return
        }
        else -> return
    }
}

fun isPrimeNumber3(num: Int){
    println("${num}소수 판단(do-while)")

    when {
        num <= 1 -> return
        num == 2 -> println("2는 소수입니다")
        num >= 3 -> {
            var n = 2
            val end = num-1

            do {
                if(num % n == 0){
                    println("${num}은 소수가 아닙니다")
                    return
                }
                n++
            }while(n <= end)
            println("${num}은 소수입니다.")
            return
        }
        else -> return
    }
}