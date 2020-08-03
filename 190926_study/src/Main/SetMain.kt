package Main

fun main() {
    println("setof() = ${setOf(1,2,5,5,3,3)}")

    val myNumberSet = setOf(12, 11, 31, 53, 22, 66, 11)
    val myNumberList = listOf(12, 11, 31, 53, 22, 66, 11)
    val myDistinctNumber = myNumberList.distinct().sorted()

    println("myNuberSet = ${myNumberSet} => ${myNumberSet.size}")
    println("myNuberSet = ${myNumberList} => ${myNumberList.size}")
    println("myNuberSet = ${myDistinctNumber} => ${myDistinctNumber.size}")

    for(n in myNumberSet)
        println("set n => $n")

    for((i, n) in myNumberSet.withIndex())
        println("set[$i] => $n")

    println("-----------------------------------------------------------")

    val mySet: Set<Int> = myNumberSet
    println("${mySet}")
    println("mySet.isEmpty() = ${mySet.isEmpty()}")
    println("6 in my Set = ${6 in mySet}")
    println("mySet.contains(6) = ${mySet.contains(6)}")

    println("-----------------------------------------------------------")
    //iteration , iterator -> 하나씩 순차적으로 접근해서 해결(list와 같은 순서번호가 있는것에 유리) // 배열이나 대용량 자료처리에 많이 나옴

    val myAlphabets = setOf<Char>('A', 'B', 'C', 'D', 69.toChar(), 'F', 71.toChar(), '퇴', '년', 'N') //69.toChar() == E 71.toChar() == G
    //val myAlphabets = "ABCDEFG".toSet() // 위의 것과 같은것 (String 형태의 문자 집합)
    val it = myAlphabets.iterator()

    while(it.hasNext()){
        val outPutAlpabats = it.next()
        print("$outPutAlpabats \t")
    }
    println()

    println("-----------------------------------------------------------")
    //Set 집합의 연산
    //부분집합

    val myName = "WON".toSet()
    val yourName = "ㅇ".toSet()
    val hisName = "2020년 5월 7일 ㅇ 하자".toSet()

    println("myAlphabets.containsAll() = ${myAlphabets.containsAll(myName)}")
    println("myAlphabets.containsAll() = ${myAlphabets.containsAll(yourName)}")
    println("myAlphabets.containsAll() = ${myAlphabets.containsAll(hisName)}")

    println("-----------------------------------------------------------")
    //교집합

    println("myAlphabets.intersect() = ${myAlphabets intersect myName}")
    println("myAlphabets.intersect() = ${myAlphabets intersect yourName}")
    println("myAlphabets.intersect() = ${myAlphabets intersect hisName}")

    println("-----------------------------------------------------------")
    //합집합

    println("myAlphabets union myName = ${myAlphabets union myName}")
    println("myAlphabets + myName = ${myAlphabets + myName}")
    println("myAlphabets union yourName = ${myAlphabets union yourName}")
    println("myAlphabets + yourName = ${myAlphabets + yourName}")
    println("myAlphabets union hisName = ${myAlphabets union hisName}")
    println("myAlphabets + hisName = ${myAlphabets + hisName}")

    println("-----------------------------------------------------------")
    // 차집합

    println("myAlphabets subtract myName = ${myAlphabets subtract myName}")
    println("myAlphabets - myName = ${myAlphabets - myName}")
    println("myAlphabets subtract yourName = ${myAlphabets subtract yourName}")
    println("myAlphabets - yourName = ${myAlphabets - yourName}")
    println("myAlphabets subtract hisName = ${myAlphabets subtract hisName}")
    println("myAlphabets - hisName = ${myAlphabets - hisName}")

    println("-----------------------------------------------------------")
    //불변 가변
    val herName = setOf('h', 'w', 'a', 'm', 'i', 'n')
    //herName.add('w') // error 불변 -> immutable
    val herName2 = mutableSetOf<Char>('h', 'w', 'a', 'm', 'i', 'n') //가변 mutable
    herName2.add('e')
    println("${herName2}")
    herName2.remove('e')
    herName2.addAll(setOf('j', 'o', 'n', 'g', 'w', 'o', 'o'))
    println("${herName2}")


}