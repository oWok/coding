package Main

fun main() {
    val iceCreams = intArrayOf(1000,2000,3000,4000,5000, 7000, 10000)

    val coffeCups = IntArray(3,{i -> (i+1) * 2000 + 1000 }) // 람다식 : 인덱스 i번째에 (i+1)*2000 + 1000 값이 저장됨

    val sweetDounets =  IntArray(4)
    sweetDounets.fill(990, 0, 4) // fromIndex는 포함 / toIndex는 포함이 안됨 / 0 ~ 3 까지만 채워짐

//    println("iceCreams.size = ${iceCreams.size} / ${iceCreams.joinToString(", ")}")
//    println("coffeCups.size = ${coffeCups.size} / ${coffeCups.joinToString(", ")}")
//    println("sweetDounets.size = ${sweetDounets.size} / ${sweetDounets.joinToString(", ")}")

    printPrices("iceCreams", iceCreams)
    printPrices("coffeCups", coffeCups)
    printPrices("sweetDounets", sweetDounets)

    println("-----------------------------------------------------------")

    var index = 0
    for(ice in iceCreams)
        println("ic[${index++}] => ${ice}")

    println("-----------------------------------------------------------")

    for(i in iceCreams.indices) // i --> iceCreams의 인덱스(0 ~ 4) IntRange
        println("ic[${i}] => ${iceCreams[i]}") // == "ic[${i}] => ${iceCreams.get(i)}"

    println("-----------------------------------------------------------")
    println("ic[0] => ${iceCreams[0]}") // 0번째 인덱스 / == iceCreams[iceCreams.frist] / 마지막은 iceCreams[iceCreams.last]

    println("-----------------------------------------------------------")

    var ccSum = 0
    for(cc in coffeCups){
        println("cc = ${cc}")
        ccSum += cc
    }

    for((i, cc) in coffeCups.withIndex()){ // 순서번호와 매칭되는 값
        println("cc[$i] = ${cc}")
    }

    println("coffeCups_Sum = $ccSum")
    println("coffeCups_Sum_method = ${coffeCups.sum()}")

    println("-----------------------------------------------------------")

    var sdSum: Double = 0.0
    for((i, sd) in sweetDounets.withIndex()){
        println("$i = ${sd}")
        sdSum += sd
    }
    println("sdSum = ${sdSum}, ${sweetDounets.sum()}")
    println("sdAvg = ${sdSum/sweetDounets.size}, ${sweetDounets.average()}")

    println("-----------------------------------------------------------")

    for((i, ic) in iceCreams.withIndex()){
        if(ic > 5000)
            println("expensive $i => ${ic}")
    }

    println("iceCreams.filter {   } = ${iceCreams.filter { it > 5000 }}") // 가져온 값에 대해 true인 값만 출력(list로 출력)
    println("iceCreams.find = ${iceCreams.find { it > 5000 }}") // 배열에서 처음으로 조건에 대해 만족하는 값을 찾아 출력

}

fun printPrices(product: String, prices: IntArray){
    println("$product.size = ${prices.size} / ${prices.joinToString(", ")}")
}