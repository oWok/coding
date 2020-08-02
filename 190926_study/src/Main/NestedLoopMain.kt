package Main

fun main(args: Array<String>) {
    println("1번")
    for(i in 1..4){
        for(j in 1..8){
            print("${if(j < i*2-1) " " else "O"}")
        }
        println()
    }

    println("-----------------------------------------------------------")

    println("2번")
    for(i in 1..4){
        for(j in 8 downTo 1){
            print("${if(j < i*2-1) " " else "O"}")
        }
        println()
    }

    println("-----------------------------------------------------------")

    println("3번")
    for(i in 4 downTo 1){
        for(j in 1..8){
            print("${if(j < i*2-1) " " else "O"}")
        }
        println()
    }

    println("-----------------------------------------------------------")

    println("4번")
    for(i in 4 downTo 1){
        for(j in 8 downTo 1){
            print("${if(j < i*2-1) " " else "O"}")
        }
        println()
    }

    println("-----------------------------------------------------------")
    print("확인하고 싶은 도형의 번호 : ")
    var input_num = readLine()!!.toInt()
    printTriAngle(input_num)

}

fun printTriAngle(target: Int){

    if(target !in (1..4)){
        println("입력이 잘못되었습니다.")
        return
    }

    println("${target}번 도형")
    val row = when(target){
        1, 2 -> 1..4
        else -> 4 downTo 1
    }

    val column = when(target){
        1, 3 -> 1..8
        else -> 8 downTo 1
    }

    for(i in row){
        for(j in column){
            print("${if(j < i*2-1) " " else "O"}")
        }
        println()
    }

}
