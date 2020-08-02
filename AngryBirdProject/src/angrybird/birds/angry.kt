package angrybird.birds

/*
레드(Red): 빨간 새로, 새들의 리더이다. 게임 속에서 특별한 능력을 가진 경우는 드물다[1]. 그러나 '레드의 거대한 깃털'에서는 누르면 누른 쪽으로 빠르게 돌진하며 나무 부수기에 능하다.
블루(The Blues): 파란 새로, 새 세 마리의 이름은 각각 짐, 제이크, 제이이다. 장난기가 넘친다. 게임에서 누르면 셋으로 분열하는 능력을 가지고 있고, 유리와 얼음 부수기에 능하다.
척(Chuck): 노란 새로, 빠르게 달릴 수 있다. 게임에서 누르면 속도가 빨라지며, 나무 부수기에 능하다.
밤(Bomb): 검은 새. 쉽게 폭발한다. 게임에서 누르면 폭발한다. 돌 부수기에 능하다.
마틸다(Matilda): 하얀 새. 평화를 사랑한다. 게임에서 누르면 알 폭탄을 낳는다.
할(Hal): 녹색 새. 테렌스의 친구이다. 부리가 크며 게임에서 누르면 부메랑처럼 뒤로 되돌아온다.
테렌스(Terence): 거대한 새. 엄청난 힘을 갖고 있으며 침묵한다. 게임에서 거대한 몸집으로 구조물을 파괴한다.
버블(Bubbles): 주황색 새. 사탕을 좋아한다. 게임에서 누르면 엄청난 크기로 부풀어오른다.
실버(Silver)[2]:회색 새.주전자처럼 생겼다. 게임에서 누르면 공중에서 한바퀴 돌고 내리꽂는다.
스텔라(Stella): 분홍색 새. 활동적이다. 게임에서 누르면 주위 물건들을 비눗방울에 가둔다.
Flock...
*/

// 새총위에 올려지다. 고무줄을 당기다. 발사되어 날아가다.
// 장애물에 부딪혀 충격을 줌

// 새: 이름, 공격력, 가중치, 상태(올려진상태, 당긴상태, 발사된상태, 부딪힌 상태), 색상

// 색상 열거형 클래스
enum class Color(val hexColor: String) { // 0xFF => 255
    RED("FF0000"), GREEN("00FF00"), BLUE("0000FF"),
    BLACK("000000"), YELLOW("FFFF00"), WHITE("FFFFFF")
}

// 행휘 열거형 클래스
enum class Status(val exp: String) {
    NONE("비행 시작 전의"), READY("새총 위에 준비된"), SHOT("발사된"),
    FLYING("날아가는"), CRASHED("충돌한"), END("비행을 완료")
}

private val LENGTH = 20 // 각도는 아직...... 나중에 따로 구현해봐야됨

//class Red (){
abstract class Flock() {
    lateinit var name: String // 늦은초기화(나중에 초기화)
    var power: Double = 10.0 // 파워 기본은 10
    var status: Status = Status.NONE
    open val color: Color = Color.RED
    open val weight: Double = 1.1 // 가중치 기본은 1.1
    open val type: String = "Red" // 신규추가

//    constructor(name: String): this() {
//        this.name = name
//    }

    override fun toString(): String {
        return "${status.exp} '$name' ${type}새(power=$power, weight=$weight)"
    }

    // concrete 구체화 함수
    protected fun getRandom(max: Int = 10) = (Math.random() * max).toInt() + 1 // 1 ~ max // 상속을 생각해서 protected로 만들어줘야함
    protected fun getDamage() = power * weight * getRandom()

    // 행위
    // 새총위에 올려지다
    fun readyForShoot() {
        println("step 1 : ${this}가 새총위에 올려지다")
        this.status = Status.READY
    }

    // 고무줄을 당기다
    fun adjusAngleLength() {
        println("step 2 : ${this}가 고무줄이 당겨져 발사되다")
        this.power += getRandom(LENGTH) * getDamage()
        println("\t>> 결정된 파워 : ${String.format("%.2f",power)}")
        this.status = Status.SHOT
    }

    // 발사되어 날라가다.
    abstract fun flyAfterShoot()  // 추상화에서는 body 부분이 없어야함 // 추상매소드가 있기위해서는 해당 클래스도 추상클래스가 되어야함 // 자식클래스에서 재정의 해서 사용
    // abstract 앞에 open public가 생략되어 있음
    //fun flyAfterShoot() {
//        println("step 3 : ${this}가 발사되어 공중으로 날라가다") // 실제 게임구현에서는 에니메이션스프라이트롤 통해 에니메이션을 그려줘야함 / 사운드도 추가
//        this.status = Status.FLYING
//    }

    // 장애물에 부딪혀 충격을주다
    abstract fun crashWithDamage()
//    fun crashWithDamage() {
//        println("step 4 : ${this}가 장애물에 부딪혀 충격을 준다")
//        println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
//        this.status = Status.CRASHED
//    }

    // 비행을 마치다
    fun landingForEnd() {
        println("step 5 : ${this}가 비행을 마치다")
        println("-".repeat(80) + "\n")
        this.status = Status.END
    }
}
//class Red(_name: String): Flock()
open class Red(_name: String): Flock() { // Flock class를 상속 받아옴
    // 주석부분은 상위 클래스에서 정의된 부분
    init {
        super.name = _name
    }

//    lateinit var name: String // 늦은초기화(나중에 초기화)
//    var power: Double = 10.0 // 파워 기본은 10
//    var status: Status = Status.NONE
//    val color: Color = Color.RED
//    val weight: Double = 1.1 // 가중치 기본은 1.1
//    val type: String = "Red" // 신규추가
//
//    constructor(name: String): this() {
//        this.name = name
//    }

//    override fun toString(): String {
//        return "${status.exp} '$name' ${type}새(power=$power, weight=$weight)"
//    }

    // concrete 구체화 함수
//    protected fun getRandom(max: Int = 10) = (Math.random() * max).toInt() + 1 // 1 ~ max // 상속을 생각해서 protected로 만들어줘야함
//    protected fun getDamage() = power * weight * getRandom()

    // 행위
    // 새총위에 올려지다
//    fun readyForShoot() {
//        println("step 1 : ${this}가 새총위에 올려지다")
//        this.status = Status.READY
//    }

    // 고무줄을 당기다
//    fun adjusAngleLength() {
//        println("step 2 : ${this}가 고무줄이 당겨져 발사되다")
//        this.power += getRandom(LENGTH) * getDamage()
//        println("\t>> 결정된 파워 : ${power}")
//        this.status = Status.SHOT
//    }

    // 발사되어 날라가다.
    // 재정의 해야함
    override fun flyAfterShoot() {
        println("step 3 : ${this}가 발사되어 공중으로 날라가다") // 실제 게임구현에서는 에니메이션스프라이트롤 통해 에니메이션을 그려줘야함 / 사운드도 추가
        this.status = Status.FLYING
    }

    // 장애물에 부딪혀 충격을주다
    // 재정의 해야함
    override fun crashWithDamage() {
        println("step 4 : ${this}가 장애물에 부딪혀 충격을 준다")
        println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
        this.status = Status.CRASHED
    }

    // 비행을 마치다
//    fun landingForEnd() {
//        println("step 5 : ${this}가 비행을 마치다")
//        println("-".repeat(80) + "\n")
//        this.status = Status.END
//    }
}

interface Spliter {
    fun splitBirds() // 앞에 public open이 생략되어 있음
    fun splitDamage(vararg birds: String)
}

//abstract class Blues: FLock() -> error
//class Blues(_name: String): Flock() {
class Blues(_name: String): Flock(), Spliter{
    init {
        super.name = _name
        super.power = 8.0
        status = Status.NONE
//        color = Color.BLUE
//        weight = 1.3
//        val이기때문에 그냥 수정하면 오류남
    }

//    때문에 오버라이드를 이용하여 값을 바꿔줘야함 / 상위 클래스에서 open을  시켜 줫기 때문에 가능
    override val color: Color = Color.BLUE
    override val weight: Double = 1.3
    override val type: String = "Blues"

    // 재정의 from Spliter
    override fun splitBirds() {
        println("\t>> 짐, 제이크, 제이 세마리 새들로 분리되어 날아간다")
    }

    // 재정의 from Spliter
    override fun splitDamage(vararg birds: String) {
        for(bird in birds){
            println("\t>> '${bird}'가 장애물에 부딪힘 충격을 가함.")
            println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
        }
    }

    //    fun splitBirds() { // vararg -> 배열로 받겟다
//        println("\t>> 짐, 제이크, 제이 세마리 새들로 분리되어 날아간다")
//    }
//
//    fun splitDamage(vararg birds: String) {
//        for(bird in birds){
//            println("\t>> '${bird}'가 장애물에 부딪힘 충격을 가함.")
//            println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
//        }
//    }

    // 재정의 from Flock
    override fun flyAfterShoot() {
        println("step 3 : ${this}가 발사되어 공중으로 날라가다")
        this.splitBirds() // this생략가능
        this.status = Status.FLYING
    }

    // 재정의 from Flock
    override fun crashWithDamage() {
        println("step 4 : ${this}")
        this.splitDamage("JIM Blue새", "JAKE Blue새", "JAY Blue새") // this생략가능
        this.status = Status.CRASHED
    }
}

interface AcceleratorI {
    val MORE_POWER_WEIGHT // = 3 / 인터페이스 안에서는 초기화가 안됨 할려면 get를 정의해서 해야함
        get() = Math.random() * 10 + 1.0 // 불르는 순간에 계산되는 식

    fun accelatorSpeed()
}

class Chuck(_name: String): Flock(), AcceleratorI {
    init {
        super.name = _name
        power = 9.0
        status = Status.NONE
    }

    override val color: Color = Color.YELLOW
    override val weight: Double = 1.2
    override val type: String = "Chuck"

    // 척새 고유기능 from AcceratorI
    override fun accelatorSpeed() {
        this.power += MORE_POWER_WEIGHT * power
        println("\t>> ${this}가 비행 가속도를 받아 파워가 ${String.format("%.2f", power)}로 증가하다")
    }

    // from Flock
    override fun flyAfterShoot() {
        println("step 3 : ${this}가 발사되어 공중으로 날라가다")
        accelatorSpeed() // 고유기능 호출
        this.status = Status.FLYING
    }

    // from Flock
    override fun crashWithDamage() {
        println("step 4 : ${this}가 장애물에 부딪혀 충격을 준다")
        println("\t>> 총 입힌 데미지 : ${java.lang.String.format("%.2f", getDamage())} 점")
        this.status = Status.CRASHED
    }
}

//fun main() {
//    val bird1 = Red()
//    bird1.name = "레드1"

//    val bird1 = Red("종우")
//    println("bird1 = ${bird1}") // toString()
//    bird1.readyForShoot()
//    bird1.adjusAngleLength()
//    bird1.flyAfterShoot()
//    bird1.crashWithDamage()
//    bird1.landingForEnd()

//    listOf<Red>(Red("종우"), Red("화민"), Red("퇴사"), Red("20200430")).forEach {
//        it.readyForShoot()
//        it.adjusAngleLength()
//        it.flyAfterShoot()
//        it.crashWithDamage()
//        it.landingForEnd()
//    }

//    listOf<Blues>(Blues("종우"), Blues("화민"), Blues("수경")).forEach {
//        with(it) {
//            readyForShoot()
//            adjusAngleLength()
//            flyAfterShoot()
//            crashWithDamage()
//            landingForEnd()
//        }
//    }
//}