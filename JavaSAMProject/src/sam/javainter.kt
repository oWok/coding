package sam

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


fun main() {
//  1.  object expression
    val objHuman = object {
        val name = "einstein"
        val job = "scientist"
    }

    println("objHuman = ${objHuman}, objHuman.name = ${objHuman.name}, objHumane.job = ${objHuman.job}")

    val numbers = arrayListOf<Int>(1, 2, 65, 7, 2 , 3, 7, 1, 23, 37, 14, 4)
    numbers.sort() // 오름차순
    println("numbers.sort() = ${numbers}")
    numbers.sortDescending() // 내림차순
    println("numbers.sortDescendingh() = ${numbers}")
    println("numbers.sorted() = ${numbers.sorted()}")
    println("numbers.apply(ArrayList<Int>::sort) = ${numbers.apply(ArrayList<Int>::sort)}") // ArrayList를 sort해서 적용

    Collections.sort(numbers, Comparator<Int> { // java.util.Comparator<T> SAM FI
//        object: Comparator<Int>
//        override fun compare(o1: Int, o2: Int): Int {
//            return o1 - o2
//            // o2 - o1 => 내림차순
//            // o1 - o2 => 오름차순
//        }
        o1, o2 -> o1 - o2 // 람다식을 통해 축약
    })
    Collections.sort(numbers, {o1, o2 ->  o1 - o2})
    Collections.sort(numbers) {
        o1, o2 -> o1 - o2
    }

    val objComarable = object: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    }

    Collections.sort(numbers, objComarable)

    // custom SAM
    val objCountJava = object: MyCountable {
        override fun myCount(list: MutableList<Int>?): Int = list?.size?: 0
//        {
//         return list?.size?: 0
//        }
    }

    val objCountJava2 = MyCountable {
        list -> list?.size?: 0
    }

    val objCountJava3 = MyCountable { it?.size?: 0 } // 가장 최종표현

    println("java SAMFI objCount3.myCount(null) = ${objCountJava3.myCount(null)}")
    println("java SAMFI objCount3.myCount(numbers) = ${objCountJava3.myCount(numbers)}")

    val objCountKt = object: MyCountableKT{
        override fun Mycount(list: List<Int>): Int {
            return list.size
        }
    }

    println("objCountKt = ${objCountKt.Mycount(numbers)}")

//    val objCountKt2 = object: MyCountableKT{ list: List<Int> -> list.size }
//    val objCountKt2 = object: MyCountableKT{ it.size }
//    생성자가 없기때문에 위에 2개는 오류가 남

    val objCountTypeAlias: MyCountableTypeAlias = object: MyCountableTypeAlias {
        override fun invoke(p1: MutableList<Int>): Int { // invoke -> 연산자 오버로딩 / () call 하는 기호?
            return p1.size // 축약식 가능 = p1.size
        }
    }

    val objCountTypeAlias2: MyCountableTypeAlias = object: MyCountableTypeAlias {
        override fun invoke(p1: MutableList<Int>): Int = p1.size
    }

    println("objCountTypeAlias = ${objCountTypeAlias(numbers)}")
    println("objCountTypeAlias = ${objCountTypeAlias.invoke(numbers)}")

    val objCountTypeAliasLambda: MyCountableTypeAlias = { list: MutableList<Int> -> list.size }
    val objCountTypeAliasAnony = fun(list: MutableList<Int>) = list.size

    println("objCountTypeAliasLambda = ${objCountTypeAliasLambda(numbers)}")
    println("objCountTypeAliasAnony = ${objCountTypeAliasAnony(numbers)}")

    val mcList: List<MyCountableTypeAlias> = listOf(objCountTypeAlias, objCountTypeAliasLambda, objCountTypeAliasAnony)

    mcList.map { it(numbers) }.forEach(::println)
}

typealias MyCountableTypeAlias = (MutableList<Int>) -> Int // (MutableList<Int>) -> Input / 뒤에 Int -> Int형으로 return

interface MyCountableKT {
    fun Mycount(list: List<Int>): Int
}