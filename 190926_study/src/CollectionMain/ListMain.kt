package CollectionMain

fun main() {
    //List == Array, Stack, Queue.....

    val myFriends = listOf("hwamin", "jongwoo", "yujoo", "hwamin", "sukyung", "sojung")
    val frList: List<String> = myFriends

    println("myFriends list = ${myFriends}")

    for((i, fr) in frList.withIndex()){
        println("frList[$i] = $fr")
    }
    println("frList[0] = ${frList[0]} ${frList.get(0)}")

    println("frList = ${frList.indexOf("bitna")}") // indexof는 첫번째부터 없는 값이면 -1 출력
    println("frList = ${frList.indexOf("hwamin")}")
    println("frList = ${frList.lastIndexOf("hwamin")}") //lastInedxOf 는 마지막부터 순차적으로 찾는것
    println("frList.subList = ${frList.subList(0,3)}")

    println("-----------------------------------------")
    // mutable
    //frList[6] = "ㅇ" --> 사이즈 추가 불가
    //frList[frList.lastIndex] = "ㅇ" --> 사이즈 추가 불가

    //val myNewFriends = mutableListOf<String>("ㅇ") // 가변리스트
    //val myNewFriends: MutableList<String> = mutableListOf<String>("ㅇ") // 가변리스트 -> 형지정

    val myNewFriends = myFriends.toMutableList() // 불변리스트를 가변으로 담을때 xxx.toMutableList
    myNewFriends.add("ㅇ 하자 ㅇ") // 추가
    println("myNewFriends = ${myNewFriends} / ${myNewFriends.size}")

    myNewFriends.set(frList.lastIndex-1, "shinyujoo") //변경
    println("myNewFriends = ${myFriends} -- ${myNewFriends}")

    myNewFriends.removeAt(myNewFriends.lastIndexOf("hwamin")) // 삭제
    println("myNewFriends = ${myNewFriends}")

    println("-----------------------------------------")
    //정렬 - raw String """ """ // here document? //trimMargin() -> | 이거 삭제해줌
    /*"""Overall, multiplatform is not about compiling all code for all platforms.
                |This model has its obvious limitations, and we understand that modern applications need access to unique features of the platforms they are running on.
                |Kotlin doesn't limit you to the common subset of all APIs in the world.
                |Every component can share as much code as needed with others but can access platform APIs at any time through the expect/actual mechanism provided by the language.""".trimMargin()*/
    // 위에꺼는 원래 썻던거거
   val muStr = """ㅇ 하고 싶다 ㅇ 하고 집 가고 싶다 
        |2020년 ㅇ고 싶다""".trimMargin()



    println(muStr)

    val words: List<String> = muStr.split(' ', '\n') //스페이스나 엔터를 만나면 짜름 //split를 통해서 List<String>에 순차적으로 넣어줌

    for((i, w) in words.withIndex())
        println("words[$i] => $w")

    val words2: List<String> = muStr.split(' ', '\n').sorted() // 정렬 // 오름차순
    println()
    for((i, w) in words2.withIndex())
        println("words2[$i] => $w")

    val words3: List<String> = muStr.split(' ', '\n').sortedDescending() // 정렬 // 내림차순
    println()
    for((i, w) in words3.withIndex())
        println("words2[$i] => $w")

    println()
    val words4: List<String> = muStr.split(' ', '\n').sortedBy { it.length } // 문자의 길이순으로 정렬(짧-길) // 오룸차순
    for((i, w) in words4.withIndex())
        println("words3[$i] => $w")

    println()
    val words5: List<String> = muStr.split(' ', '\n').sortedByDescending { it.length } // 문자의 길이순으로 정(길-짧) // 내림차순
    for((i, w) in words5.withIndex())
        println("words4[$i] => $w")
}