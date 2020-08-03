package angrybird.other

import angrybird.birds.*
import java.lang.Math.random

interface SonicAttack {
    val SONIC_POWER get() = 100.0
    fun getPowerWithSonicAttack(br: Flock): Double {
        println("\t>> ${br}가 음파공격으로 추가파워 ${SONIC_POWER}를 얻다")
        return SONIC_POWER
    }
}

interface AcceleratorII: AcceleratorI {
    override val MORE_POWER_WEIGHT: Double
        get() = random()*20 + 1.0

    fun getLuckBonusPower(): Double {
        val lucky = (random()*2).toInt() // 0아니면 1이나옴

        return if(lucky == 1) 100.0 else 10.0
    }
}

interface HeroBadge {
    fun showBadge(bird: Flock) { // 정의를 해두더라도 오버라이드해서 재정의가 가능
        println("${bird}의 ((((( HERO ))))) badge")
    }
}

// Outer class : 외부 클래스
class SuperHeroes: HeroBadge {
    private val title: String

    init {
        title = "<< Super Hero >>"
    }

    // netster class : 중첩클래스
    // 상위 클래스에서 상속받은 메소드라도 불러와 사용할 수 없음
    class Red2(_name: String): Red(_name), SonicAttack {
        override val type: String = "Red2" // 외부 클래스에서 private 선언된 것에 대해서는 중첩클래스에서도 참조를 못함

        override fun flyAfterShoot() {
            println("step 3 : ${this}가 발사되어 공중으로 날라가다")
            this.power += getPowerWithSonicAttack(this)
            this.status = Status.FLYING
        }

        override fun crashWithDamage() {
            println("step 4 : ${this}가 장애물에 부딪혀 충격을 준다")
            println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
            this.status = Status.CRASHED
        }
    }

    // inner class : 내부 클래스
    // 나를 감싸고 있는 클래스가 상속 받은것이라면 사용 가능
    inner class Nova(_name: String): Flock (), SonicAttack, AcceleratorII{
        override val color: Color = Color.WHITE
        override val weight: Double = 10.0
        override val type: String = "${title} Nova" // 내부 클래스이기 떄문에 나를 감싼 클래스에서 보이는 것이라면 가져와 사용가능

        init {
            super.name = _name
        }

        override fun flyAfterShoot() {
            println("step 3 : ${this}가 발사되어 공중으로 날라가다")
            accelatorSpeed()
            this.status = Status.FLYING
        }

        override fun crashWithDamage() {
            println("step 4 : ${this}가 장애물에 부딪혀 충격을 준다")
            println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
            this.status = Status.CRASHED
        }

        override fun accelatorSpeed() {
            val sonic = getPowerWithSonicAttack(this)
            this.power += MORE_POWER_WEIGHT * (power + sonic + getLuckBonusPower())
            println("\t>> ${this}가 비행 가속도를 받아서 파워가 ${String.format("%.2f", power)}로 증가하다.")
        }

        fun showMyBadge() {
            super@SuperHeroes.showBadge(this)
        }
    }

}

fun play(bird: Flock) {
    println()
    with(bird) {
        readyForShoot()
        adjusAngleLength()
        flyAfterShoot()
        crashWithDamage()
        landingForEnd()
    }
}

fun main() {
    val r2: SuperHeroes.Red2 = SuperHeroes.Red2("ㅇ")// 중첩클래서 / kotlin에서는 내부클래스라 부르지 않고 중첩클래스라고 부름
//    val nv = SuperHeroes.Nova("ㅇ") // err
    val nv = SuperHeroes().Nova("ㅇ") // 외부클래스에 생성자를 호출해줘야함
    val nv2: SuperHeroes.Nova = SuperHeroes().Nova("ㅇ") // 타입지정할때는 외부클래스 및 자신의 클래스 생성자를 안적어줌

    println("nested class r2 : ${r2.javaClass}")
    println("nested class nv : ${nv.javaClass}")

    play(r2)
    play(nv)
    play(nv2)

    nv.showMyBadge()
}