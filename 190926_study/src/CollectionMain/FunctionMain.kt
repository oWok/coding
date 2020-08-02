package CollectionMain

fun main() {
    //함수 호출
//    println(thisisFunction2(3, null))

    val starGuild = mutableMapOf<String, String>()
    joinToGuild(starGuild, null)
    joinToGuild(starGuild, "권수경", 50)
    joinToGuild(starGuild, "손화민", 190, 3)
    joinToGuild(starGuild, "화민", 190, 0, -65f)
    joinToGuild(starGuild, "원종우", 189, 6, 150f)
    joinToGuild(starGuild, "20200507원종우", 0, 7, 150f)
    joinToGuild(starGuild, "종우", stat = 150f) // 네임드파라마터 -> 특정값만 함수에 넣고 싶을때 해당 하는 변수 = 값으로 넣을 수 있음
    joinToGuild(starGuild, "1종우", stat = 150f, level = 189) // namedparmeter -> 특정값만 함수에 넣고 싶을때 해당 하는 변수 = 값으로 넣을 수 있음


    println("startGuild => ${starGuild.toList().joinToString("\n")}")
}

//코틀린은 디폴트 파라미터가 있음 //코틀린은 오버로딩도 가능하지만 디폴트 파라미터를 이용하여 함수 생성 가능
//코틀린스타일의 오버로딩은 함수 하나로 충분히 가능 -> 코틀린은 이러한 형태를 지향함
fun joinToGuild(guild: MutableMap<String, String>, nick: String?, level: Int = 10, type: Int = 0, stat: Float = 5f) {
    val playerTypes = arrayOf("직원", "검사", "마법사", "궁수", "성직자", "도적", "퇴사예정자", "퇴사자")
    val name = nick ?: "이름없음"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val checkStat = if(stat < 0 ) 10f else stat
    val member = "퇴사예정자 $name level $level, type ${playerTypes[typeNumber]}, stat $checkStat"


    //가입
    if(guild.containsKey(name)) println("$name 퇴사예정자가 이미 가입되어 있습니다.") //닉네임 중복이 발생한다면
    else
        guild.put(name, member)
}

/*fun joinToGuild(guild: MutableMap<String, String>, nick: String?) {
    val name = nick ?: "이름없음"
    val member = "퇴사예정자 $name level 1, type 검사, stat 1.0"

    //가입
    if(guild.containsKey(name)) println("$name 퇴사예정자가 이미 가입되어 있습니다.") //닉네임 중복이 발생한다면
    else
        guild.put(name, member)
}

//overloading 오버로딩
fun joinToGuild(guild: MutableMap<String, String>, nick: String?, level: Int) {
    val name = nick ?: "이름없음"
    val member = "퇴사예정자 $name level $level, type 검사, stat 1.0"

    //가입
    if(guild.containsKey(name)) println("$name 퇴사예정자가 이미 가입되어 있습니다.") //닉네임 중복이 발생한다면
    else
        guild.put(name, member)
}

//overloading 오버로딩
fun joinToGuild(guild: MutableMap<String, String>, nick: String?, level: Int, type: Int) {
    val playerTypes = arrayOf("직원", "검사", "마법사", "궁수", "성직자", "도적", "퇴사예정자", "퇴사자")
    val name = nick ?: "이름없음"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val member = "퇴사예정자 $name level $level, type ${playerTypes[typeNumber]}, stat 1.0"

    //가입
    if(guild.containsKey(name)) println("$name 퇴사예정자가 이미 가입되어 있습니다.") //닉네임 중복이 발생한다면
    else
        guild.put(name, member)
}

//overloading 오버로딩
fun joinToGuild(guild: MutableMap<String, String>, nick: String?, level: Int, type: Int, stat: Float) {
    val playerTypes = arrayOf("직원", "검사", "마법사", "궁수", "성직자", "도적", "퇴사예정자", "퇴사자")
    val name = nick ?: "이름없음"
    val typeNumber = if(type in 0..playerTypes.lastIndex) type else 0
    val checkStat = if(stat < 0 ) 10 else stat
    val member = "퇴사예정자 $name level $level, type ${playerTypes[typeNumber]}, stat $checkStat"


    //가입
    if(guild.containsKey(name)) println("$name 퇴사예정자가 이미 가입되어 있습니다.") //닉네임 중복이 발생한다면
    else
        guild.put(name, member)
}*/

//함수 정의
//fun thisisFunction(argument: Int, parameter: Int?): Int {
//    val a = 3
//    println("a = $a")
//    return // 함수 종료
//    println("not arrived......")

//    return argument * 3 // 단일 식일 때는 축약가능(바디생략가능)
//}

//fun thisisFunction2(argument: Int, parameter: Int?): Int = argument * 3 // 단일식일때는 이런식으로 축약가능
// fun thisisFunction2(argument: Int, parameter: Int?) = argument * 3 // 타입추론으로 인해 한번더 축약