package Problem

fun main() {
    var drow = intArrayOf(0,0,0,0,0,0,0)

    for(i in 1..3) {
        println("******** ${i}회차 럭키드로우 구매 ********")
        luckDrow(drow = arrayOf(0, 0, 0, 0, 0, 0, 0))
        println()
    }
}

fun luckDrow(drow: Array<Int>){
    for(i in 0 until drow.size){
        println("${i+1}번 번호 추첨 : ")
        drow[i] = (Math.random()*77).toInt() + 1
        println(">> 행운 넘버 드로우 중... => ${drow[i]}이 뽑혔습니다.")
        if(i > 0) {
            back@for (j in 0 until i) {
                if (drow[i] == drow[j]) {
                    println("중복 됩니다 다시 추첨...")
                    drow[j] = (Math.random()*77).toInt() + 1
                    println(">> 행운 넘버 드로우 중... => ${drow[j]}이 뽑혔습니다.")
                    break@back
                }
            }
        }
    }

    drow.sort()
    println("====================================")
//    for((i, result) in drow.withIndex())
//        print("${drow[i]}\t")
    print("${drow.joinToString("\t")}")
    println("\n====================================")
}
