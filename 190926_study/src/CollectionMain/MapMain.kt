package CollectionMain

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    //Map, Dictionary, Hash
    //Map 은 Key 에 대응되는 Value 가 존제

    val students = mapOf("종우" to 26, "화민" to 24)
    val stMap: Map<String, Int> = students //key -> type value -> 수치형

    println("${stMap} with size -> ${stMap.size}") //map은 value의 값의 중복은 허용하나 key값의 중복은 허용하지 않음
    println("${stMap.keys} / ${stMap.values}")
    println("stMap[\"종우\"] = ${stMap["종우"]} // ${stMap["ㅇ"]}") // .get(key)와 동일 key 에 대응되는 value 가 나옴
    println("stMap[\"종우\"] = ${stMap["종우"]} // ${stMap.get("화민")}")
    println("stMap[\"종우\"] = ${stMap.getValue("종우")} // ${stMap["ㅇ"]}")
    //println("stMap[\"종우\"] = ${stMap.getValue("종우")} // ${stMap.getValue("ㅇ")}") // getValue 는 값이 없으면 예외가 발생함

    println("---------------------------------------")
    val studentScores: Map<String, Float> = mapOf("종우" to 5.5f, "화민".to(5.6f), Pair("ㅇ", 3.5f)) //Pair(Key, Value) -> Key.to(Value) or Key to Value Entry(Key, Value)
    println("studentScores = ${studentScores} with size -> ${studentScores.size}")
    println("studentScores.keys = ${studentScores.keys}")
    println("studentScores.keys = ${studentScores.values}")

    println("---------------------------------------")
    //map 에도 가변성과 불변성이 존재함
    //studentScores["종우"] = 12.3f -> 불변

    val studentScores_Mutable: MutableMap<String, Float> = mutableMapOf("종우" to 5.5f, "화민".to(5.6f), Pair("ㅇ", 3.5f))
    studentScores_Mutable["화민"] = 5.5f

    println("stduentScores_Mutable = ${studentScores_Mutable} with size -> ${studentScores_Mutable.size}")
    println("studentScores_Mutable = ${studentScores_Mutable.keys}")
    println("studentScores_Mutable = ${studentScores_Mutable.values}")

    //추가
    studentScores_Mutable["ㅇ"] = 4.1f // == set(), put()
    //studentScores_Mutable["ㅇ"] = 2.2f
    studentScores_Mutable.put("ㅇ", 2.2f)
    //삭제
    studentScores_Mutable.remove("ㅇ")

    println("stduentScores_Mutable = ${studentScores_Mutable} with size -> ${studentScores_Mutable.size}")
    println("studentScores_Mutable = ${studentScores_Mutable.keys}")
    println("studentScores_Mutable = ${studentScores_Mutable.values}")

    println("---------------------------------------")
    //예제 이메일 (won@kakao.com) @를 기준으로 앞 아이디(유일무의->key 값) 뒤 소속(중복가능->value)
    print("입력 횟수를 입력 : ")
    val input_count: Int = readLine()!!.toInt()
    var input_email: String
    val mapOfemail = mutableMapOf<String, String>()

    for(i in 0 until input_count){
        input_email = readLine()
        insertNewEmailToMemberBook(input_email, mapOfemail)
    }

    println("mapOfemail => ${mapOfemail}")
    println("ID : ${mapOfemail.keys}")
    println("DOMAIN : ${mapOfemail.values}")

    for(id in mapOfemail.keys)
        println("ID : $id => DOMAIN : ${mapOfemail["$id"]}")
}

val NOT_FOUND = -1

fun insertNewEmailToMemberBook(email: String?, mbBook: MutableMap<String, String>){
    if (email == null){
        println("email주소가 누락되었습니다.")
        return
    }

    val atPos = email.indexOf('@') // 입력된 문자를 못찾으면 -1을 출력하고 찾으면 그 문자의 인덱스 번호를 출력
    if(atPos == NOT_FOUND || atPos == email.lastIndex){
        println("주소 입력 형식이 잘못 되었습니다.")
        return
    }

    //이메일 주소를 @ 기준으로 분리
    val id = email.substring(0 until atPos)
    //val id = email.split('@')
    val domain = email.substring(atPos+1 until email.length)
    //val domain = email.split('@')

    mbBook.put(id, domain)
}

/*    val mySet: HashSet<Char> = hashSetOf()
    val myList: ArrayList<Char> = arrayListOf()
    val myMap: HashMap<String, Char> = hashMapOf()

    mySet.add('A') // 생성 Create
    myList.add('B')
    myMap.put("first", 'C')

    println("mySet = ${mySet}, myList = ${if (myList.isEmpty()) "none" else myList[0]}")
    println("myMap = ${myMap["first"]}") //읽어옴 Read

    myList.set(0, 'Q') //갱신 Update
    mySet.remove('A') //사제 Delete
    myMap.clear()

    println("mySet = ${mySet}, myList = ${if (myList.isEmpty()) "none" else myList[0]}")
    println("myMap = ${myMap["first"]}")
*/