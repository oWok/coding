package main

fun myFun(p: () -> Unit) = p() // p: () -> Unit 라는 함수는 아무 인자값도 받지 않고 아무것도 리턴하지 않는 함수 // 임보크 (연산자 오버로딩)
// p = {
//    println("Hello Kotlin FP!! (ㅈ -> ㄷ)")
//}

// HOF HIGHER OF FUNCTION
fun takePrintNameFunction(name: String, pnFun: (String) -> Unit) {
    val local: (String) -> Unit = pnFun
    local(name)
}

fun supplyPrintNameFunction(): (String) -> Unit {
    return {name: String -> println("aaaa ${name}야")}
}

// 숫자 리스트 확장 함수 - 고차함수
fun List<Int>.showNumbersToString(pre: (Int) -> Boolean, con: ((List<Int>), String) -> String) { // predicate
    val list = arrayListOf<Int>()
    for(n in this) {
        if(pre(n))
            list.add(n)
    }

    println(con(this, ", "))
}

val concats = fun(ints: List<Int>, sep: String): String {
    var s = ""
    for ((i, n) in ints.withindex()) {
        if(i < ints.lastindex)s += "$n$sep"
        else s += n
    }

    return s
}

fun main() {
    myFun {
        println("Hello Kotlin FP!! (ㅈ -> ㄷ)")
    }
    
    // 1. 변수에 함수를 담을 수 있음
    val printName = fun(name: String) { println("당신의 이름은 ${name}입니다! ㄷ ㅈ하시오")} // 익명함수
    
    printName("ㅇ")
    printName("s")
    printName("a")
    println("printName.javaClass = ${printName.javaClass}")

    val pName2: (String) -> Unit = printName // 익명함수 어나미어스? 함수
    pName2("f")

    val pName3 = {name: String -> println("ㅇ ${name} 입니다!!!!!")} // 람다식
    pName3("ㅇ")

    // 2. 인자로 전달할 수 있음
    takePrintNameFunction("ㅇ", pName2)
    takePrintNameFunction("a", fun(n: String) {println("ㄴ")})
    takePrintNameFunction("s", {x: String -> println("${x} ㅁ ㅁ")})

    // 3. 변환값으로 리턴할 수 있음
    takePrintNameFunction("종우", supplyPrintNameFunction())

    supplyPrintNameFunction()("d")

    val pName4: (String) -> Unit = supplyPrintNameFunction()
    pName4("종우")

    listOf<Int>(1,3,5,7,9,12).showNumbersToString({n -> n % 2 == 1}, concats)
    (1..20).toList().showNumbersToString(fun(n: Int) = n % 2 == 0, concats)
}

