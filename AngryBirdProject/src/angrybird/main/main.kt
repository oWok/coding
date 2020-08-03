package angrybird.main

import angrybird.birds.*

class GameStageI {
    fun run() {
//        // Any 클래스 기본 상속 다형성
//        val a: Int = 3
//        val b: String = "B"
//        val c: Any = a
//        val d: Any = b
//
//        println("c = ${c} / c type = ${c.javaClass}, d = ${d} / d type = ${d.javaClass}")
//    }

//    클래스 상속 다형성 Flock => Red, Blues, Chuck
        listOf<Flock>(Red("ㅇ"), Red("ㅇ"), Blues("ㅇ"), Blues("ㅇ"), Chuck("2020"), Chuck("0430")).forEach {
            with(it) {
                readyForShoot() // Flock에서 상속
                adjusAngleLength() // Flock에서 상속
                flyAfterShoot() // Flock에서 상속 받아 재정의 해서 각 클래스마다 고유함     +
                crashWithDamage() // Flock에서 상속 받아 재정의 해서 각 클래스마다 고유함
                landingForEnd() // Flock에서 상속
            }
        }
    }
}

fun main() {
    GameStageI().run()
}