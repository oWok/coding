package Main

import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val inputString: String = readLine().toString().trim()

    val test = inputString.split("")

    for(i in 1..inputString.length)
        print("${test[i]} \t")



}


//base, radix
//    val a = 255
//    val b = 0xff
//    val c = 0xf0 + 0x0f
//    var d = '\u00ff'
//    val e = 0x00_00_00_ff
//    val f = 0b1111_1111
//
//    println("$a $b $c ${d.toInt()} $e $f")
//    val a: Byte = 63
//    val b: Short = 30000
//    val c: Int = 6000
//    val d: Long = 1235_1231_1111L
//    val e: Float = 3.14f
//    val f: Double = 1212123.123123
//
//    println("a.javaClass = ${a.javaClass} ${Byte.MIN_VALUE} ~ ${Byte.MAX_VALUE}")
//    println("b.javaClass = ${b.javaClass} ${Short.MIN_VALUE} ~ ${Short.MAX_VALUE}")
//    println("c.javaClass = ${c.javaClass} ${Int.MIN_VALUE} ~ ${Int.MAX_VALUE}")
//    println("d.javaClass = ${d.javaClass} ${Long.MIN_VALUE} ~ ${Long.MAX_VALUE}")
//    println("e.javaClass = ${e.javaClass} ${Float.MIN_VALUE} ~ ${Float.MAX_VALUE}")
//    println("f.javaClass = ${f.javaClass} ${Double.MIN_VALUE} ~ ${Double.MAX_VALUE}")
//    val obj1 = User("원종우", 26)
//    val obj2 = NoData("퇴사", 213)
//
//    println(obj1.toString())
//    println(obj2)
//    var obj = Address()
//
//    Main.getBw.write(obj.name + "\n")
//    Main.getBw.flush()
//    Main.getBw.close()
//    var testt = readLine()
//    var number = readLine()!!.toInt()
//    var numm = readLine()!!.toInt()
//    test().ex(testt)
//    test().number(number)
//    test().number(numm)
//---------------------------------
//    val test = TestA_B()
//    test.f()
//    Main.getBww.flush()
//    Main.getBww.close()
//    println(sumTwoNums(125,42))
//
//    val a: Byte = 63
//    val b: Short = 30000
//    val c: Int = 6000
//    val d: Long = 1235_1231_1111L
//    val e: Float = 3.14f
//    val f: Double = 1212123.123123
//
//    println("a.javaClass = ${a.javaClass} ${Byte.MIN_VALUE} ~ ${Byte.MAX_VALUE}")
//    println("b.javaClass = ${b.javaClass} ${Short.MIN_VALUE} ~ ${Short.MAX_VALUE}")
//    println("c.javaClass = ${c.javaClass} ${Int.MIN_VALUE} ~ ${Int.MAX_VALUE}")
//    println("d.javaClass = ${d.javaClass} ${Long.MIN_VALUE} ~ ${Long.MAX_VALUE}")
//    println("e.javaClass = ${e.javaClass} ${Float.MIN_VALUE} ~ ${Float.MAX_VALUE}")
//    println("f.javaClass = ${f.javaClass} ${Double.MIN_VALUE} ~ ${Double.MAX_VALUE}")
//    val obj1 = User("원종우", 26)
//    val obj2 = NoData("퇴사", 213)
//
//    println(obj1.toString())
//    println(obj2)
//    var obj = Address()
//
//    Main.getBw.write(obj.name + "\n")
//    Main.getBw.flush()
//    Main.getBw.close()
//    var testt = readLine()
//    var number = readLine()!!.toInt()
//    var numm = readLine()!!.toInt()
//    test().ex(testt)
//    test().number(number)
//    test().number(numm)
//---------------------------------
//    val test = TestA_B()
//    test.f()
//    Main.getBww.flush()
//    Main.getBww.close()
//fun sumTwoNums(first: Byte, second: Byte): Byte{
//    var result = first + second
//
//    return result.toByte()
//}


//data class User(val name:String, val age:Int)
//class NoData(val name:String, val age:Int)
//class Address {
//    var name: String = "Kotlin"
//    get() {
//        return field + "!!!"
//    }
//    set(value) {
//        field = value
//    }
//}

//
//open class TestA(){
//    open fun f(){
//        //println("AAAAAAAAAAAAAAAAAAA")
//        Main.getBww.write("AAAAAAAAAAAAAAAAAAAAAAA\n")
//    }
//}
//
//interface TestA_A {
//  fun f(){
////      println("BBBBBBBBBBBBBBBBBBBBBBBBBBB")
//      Main.getBww.write("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB\n")
//  }
//}
//
//class TestA_B: TestA(), TestA_A {
//    override fun f() {
//        //println("1----------------------")
//        Main.getBww.write("1----------------------\n")
//        super<TestA>.f()
////        println("2----------------------")
//        Main.getBww.write("2----------------------\n")
//        super<TestA_A>.f()
//    }
//}


//open class AA(x: Int, xx: Int){
//
//}
//
//
//class BB : AA {
//    constructor() : super(12, 15)
//
//    constructor(x: Int) : this()
//
//    constructor(x: Int, xx: Int) : super(x, xx)
//}



//class test constructor() {
//    fun ex(name : String) {
//        when(name) {
//            "퇴사하고싶다" -> println("5월 6일 혹은 5월 7일")
//            else -> println("퇴사해야지 왜 안함")
//        }
//    }
//
//    fun number(num : Int){
//        when(num){
//            in 0..9 -> println("한자리")
//            else -> println("퇴사")
//        }
//    }
//}
