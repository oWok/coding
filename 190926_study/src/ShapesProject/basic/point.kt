package ShapesProject.basic

import ShapesProject.BLACK
import ShapesProject.BLUE
import ShapesProject.MyShape
import ShapesProject.POINT

// 코틀린은 모든 클래스기 디폴트로는 상속이 불가능한 final이 생략되 어있음
// 상속하기 위해서는 클래스 앞에 open을 명시 해줘야 함
class MyPoint(_x: Int = 0, _y: Int = 0, _name: String ="원점"): MyShape(POINT) { // 2d
    var x: Int
    var y: Int

    init {
        name = _name // super.name = _name / super -> 상위 클래스 객체
        this.x = _x
        this.y = _y
    }

    fun printPoint() {
        println("pt(x, y) => ($x, $y)")
    }

    fun pos() = Pair(this.x, y) // 점좌표를 쌍으로 리턴
    //var (firstName, lastName) = Pair("Suneet", "Agrawal") 이런식으로도 사용가능
    // 출력 할때는 pair.first pair.second 이런식으로
}

fun drawLineWithTwoPoint(sp: MyPoint?, ep: MyPoint?, name: String?, color: String = BLACK) {
    if(ep == null || sp == null){
        println("입력값이 없는 것이 존재 합니다")
        return
    }

    // 두점사이의 거리 = sqrt((x2-x1)^2 + (y2-y1)^2)
    //val distance_pow = Math.sqrt(Math.pow(ep.x.toDouble() -sp.x.toDouble(), 2.0) + Math.pow(ep.y.toDouble() - sp.y.toDouble(), 2.0))
    val distance = Math.sqrt((ep.y - sp.y)*(ep.y - sp.y).toDouble() + (ep.x - sp.x)*(ep.x - sp.x).toDouble())

    println("""
        |이름 : $name
        |타입 : 선, 색상 : $color
        |시작점 : ${sp.pos()} => 끝점 : ${ep.pos()} // 
        |길이 : ${String.format("%.2f", distance)}
    """.trimMargin())
}

fun main() {
    val sp: MyPoint = MyPoint() // 원점
    val ep: MyPoint = MyPoint(10, 10, "도착점")
    val ep2: MyPoint = MyPoint(30, 30, "도착점2")

//    sp.color = BLUE
//    sp.showStatus()
//    sp.printPoint()

    drawLineWithTwoPoint(sp, null, "null 테스트")
    drawLineWithTwoPoint(sp, ep, "퇴사")
    drawLineWithTwoPoint(sp, ep2, "퇴사2")
}