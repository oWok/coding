package mosters

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

// lateinit -> 늦은 초기화
// by lazy -> 게으른 초기화 (프라퍼티 위임 초기화)
class Player {
    // var nick: String ?= "" // 이런식으로 초기화를 하거나 init를 통해 초기화를 해줘야 함 / 널러블이라도 초기화를 해줘야함
    lateinit var nick: String
    lateinit var leadMonster: Monster // 나중에 초기화 하겟다고 앞에 lateinit를 명시해줌

    val clan: Clan by lazy { // 예전에는 ?= null 과 같이 널처리를 했었음
        // 클렌 결정 초기화 코드 블록
        // 처음 호출될때 한번 초기화가 진행되고 해당 변수? 에대해서는 더이상 초기화가 되지 않음
        this.selectClan()
    }

    private fun selectClan(): Clan {
        var mySide: Clan = Clan.Darkside

        try {
            Clan.values().forEach {
                println("${it.ordinal} : ${it.name} 진영")
            }

            print("진영을 선택 : ")
            var br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

            val sel = br.readLine()

            if (sel == "1")
                mySide = Clan.LightSide

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return mySide
    }

    override fun toString(): String {
        return "Player(nick='$nick', leadMonster=$leadMonster, clan=$clan)"
    }


}

enum class Monster { // 열거형 클래스
    WaterMon, FireMon, EarthMon, WIndMon // ordinal_number 0 ~ 3
}

enum class Clan { // 열거형 클래스
    Darkside, LightSide
}

fun main() {
    val p1: Player = Player()
    // println(p1.nick) // Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property nick has not been initialized
    p1.nick = "퇴사" + (Math.random() * 200).toInt()
    p1.leadMonster = Monster.FireMon
    println(p1.nick)
    println(p1.leadMonster)
    println("p1.clan = ${p1.clan}") // 늦은 위임 초기화가 진행 (처음 호출될때 한번만 실행)
    println("p1.clan = ${p1.clan}")

    println("플레이어 : ${p1}")
}