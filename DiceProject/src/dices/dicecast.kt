package dices

//import java.util.Random
import java.util.Random as JRandom // java.util의 Random을 JRandom으로 정의?

// DICE
/*
4 Tetrahedron
6 Cube
8 Octahedron
12 Dodecahedron
*/

fun getNumberInt(max: Int) = (Math.random() * max).toInt() + 1
fun getNumberInt2(max: Int) = JRandom().nextInt(max) + 1
fun getNumberInt3(max: Int) = JRandom().ints(1, max).findFirst().asInt // stream / 최소값과 최대값으로 범위를 지정가능 / 참고사항 그래도 자료 찾아보기
fun getNumberHedron(hed: Hedron) = (Math.random() * hed.faces).toInt() + 1
fun printDice(d: Dice) = println(d)

typealias HedronToInt = (Hedron) -> Int // Hedron을 입력받아서 Int형으로 / 함수타입을 typealias
typealias Random = (Hedron) -> Int

enum class Hedron(val faces: Int) { // 열거형
    Tetrahedron(4), Cube(6), Octahedron(8), Dodecahedron(12)
}

class Dice(val sides: Hedron) { // random func..
    fun cast(ranFun: (Int) -> Int) = ranFun(sides.faces) // Int형 정수를 받아서 Int형 정수를 return
//    fun castHedron(ranFun: (Hedron) -> Int) = ranFun(sides) // Hedron을 받아서 하기때문에 sides만
fun castHedron(ranFun: Random) = ranFun(sides) // Hedron을 받아서 Int형을 반환 / typealias를 통해 정의된 Random을 사용

    override fun toString(): String {
//        return "Dice(${sides.name}) casts '${getNumberInt(sides.faces)}'"
//        return "Dice(${sides.name}) casts '${cast (fun(n: Int) = (Math.random() * n).toInt() + 1)}'" // 익명함수
//        return "Dice(${sides.name}) casts '${cast({(Math.random() * sides.faces).toInt() + 1})}'" // 람다식
//        return "Dice(${sides.name}) casts '${cast{(Math.random() * sides.faces).toInt() + 1}}'" // cast() 인데 파라미터가 하나이면 생략가능 // 람다 블럭
//        return "Dice(${sides.name}) casts '${cast(::getNumberInt)}'" // :: 함수레퍼런스
//        return "Dice(${sides.name}) casts '${cast(::getNumberInt2)}'" // :: 함수레퍼런스 / Random  메소드 사용
//        return "Dice(${sides.name}) casts '${cast(::getNumberInt3)}'" // :: 함수레퍼런스 / stream 사용
        return "Dice(${sides.name}) casts '${castHedron(::getNumberHedron)}'"

//        함수레퍼런스와 람다블럭을 많이 사용
    }

}

fun main() {
    val dices = listOf<Dice>(Dice(Hedron.Tetrahedron), Dice(Hedron.Cube), Dice(Hedron.Octahedron), Dice(Hedron.Dodecahedron))

    println("\n0. for loop iteration")
    for(d in dices) {
        println("${d.toString()}")
    }

    println("\n1. anonymous function parmeter") // 익명함수
    dices.forEach { fun(dice: Dice) {println(dice.toString())} }

    println("\n2. lambda experssion parmeter") // 람다식
    dices.forEach({dice: Dice -> println(dice.toString())})

    println("\n3. last parameter to external lambda block") // 밖으로 뺴낸 람다식
    dices.forEach() {dice: Dice -> println(dice.toString())}

    println("\n4. () removing for single argument lambda block")
    dices.forEach{dice: Dice -> println(dice.toString())}

    println("\n5. single argument 'it' for lambda expression")
    dices.forEach{println(it)} // toString()도 자동 호출 되기 떄문에 생략가능 / 이 경우에만

    println("\n6. function reference of kotlin.io::println")
    dices.forEach(::println) // 함수파라미터 호출

    println("\n7. custom function reference of ::printDice")
    dices.forEach(::printDice) // 5번과 동일한건데 함수를 만들어서 사용한것

    println("\n8. function reference of System.out::println (JVM) ")
    dices.forEach(System.out::println)
}