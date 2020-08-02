package currypartial

fun normalSum(a: Int, b: Int) = a + b
fun currySumLambda(a: Int) = {b: Int -> a + b}
fun currySumAnonymousFunction(a: Int) = fun(b: Int) = a + b
fun curryintSum(a: Int) = fun(b: Int) = a + b
fun curryintSum2(a: Int) = fun(b: Int) = fun(c: Int) = a + b + c
fun curryintSum3(a: Int) = fun(b: Int) = fun(c: Int) = fun(d: Int) = a + b + c + d
fun curryStringConcat(s1: String) = fun(s2: String) = fun(s3: String) = fun(s4: String)
    = "$s1$s2$s3$s4"

typealias LtoLFunc = (Long) -> Long
fun listMap(f: LtoLFunc, list: List<Long>) = list.map { f(it) }
fun partialApplication(remain: (LtoLFunc, List<Long>) -> List<Long>, bind: LtoLFunc) = {list: List<Long> -> remain(bind, list)}

// 고정 bind 함수
fun square(x: Long) = x * x
fun cubic(x: Long) = x * x * x
fun doubleNum(x: Long) = x * 2
fun decaNum(x: Long) = x * 10
fun factorial(x: Long): Long {
    var fac = x
    (x-1 downTo 1).forEach { fac *= it }

    return fac
}

fun main() {
    println("normalSum(3, 4) = ${normalSum(3, 4)}")
    println("currySumLambda(3)(4) = ${currySumLambda(3)(4)}")
    println("currySumAnonymousFunction(3)(4) = ${currySumAnonymousFunction(3)(4)}")
    println("curryintSum(3)(4) = ${curryintSum(3)(4)}")
    println("curryintSum2(3)(4)(5) = ${curryintSum2(3)(4)(5)}")
    println("curryintSum3(3)(4)(5)(6) = ${curryintSum3(3)(4)(5)(6)}")

    val curriedBy_3_4_5 = curryintSum3(3)(4)(5)
    println("curriedBy_3_4_5(6) = ${curriedBy_3_4_5(6)}")
    println("curriedBy_3_4_5(7) = ${curriedBy_3_4_5(7)}")
    println("curriedBy_3_4_5(9) = ${curriedBy_3_4_5(9)}")
    println("curriedBy_3_4_5(15) = ${curriedBy_3_4_5(15)}")

    println("curryStringConcat(\"2020\")(\"년\")(\"04월\")(\"30일\") = ${curryStringConcat("2020")("년 ")("04월 ")("30일")}")

    val partialSquare = partialApplication(::listMap, ::square)
    val partialCubic = partialApplication(::listMap, ::cubic)
    val partialDoubleNum = partialApplication(::listMap, ::doubleNum)
    val partialDecaNum = partialApplication(::listMap, ::decaNum)
    val partialFactorial = partialApplication(::listMap, ::factorial)

    val testDataLists: List<List<Long>> = listOf((1L..20L step 2L).toList(), (1L..10L).map(::doubleNum)) // (1L..20L).map{it*2L)

    for( list in testDataLists) {
        println("target list => $list")
        println("partialSquare = ${partialSquare(list)}")
        println("partialCubic = ${partialCubic(list)}")
        println("partialDoubleNum = ${partialDoubleNum(list)}")
        println("partialDecaNum = ${partialDecaNum(list)}")
        println("partialFactorial = ${partialFactorial(list)}")
        println()
    }

}