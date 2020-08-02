package ShapesProject

import java.awt.Point

// 패키지 공통 상수 정의
val POINT: String = "점"
val LINE: String = "선"
val TRIANGLE: String = "삼각형"
val RECTANGLE: String = "사각형"
val BLACK: String = "0x000000" // RGB 컬러 표현
val RED: String = "0xFF0000"
val GREEN: String = "0x00FF00"
val BLUE: String = "0x0000FF"
val WHITE: String = "0xFFFFFF"

// shape 공통 클래스 생성
open class MyShape(val type: String? = null) { // open으로 열어 둬야 다른곳에서 상속 받을수 있음
    var name: String? = null
    var color: String = BLACK

    open fun showStatus() { // 다른클래스에서 재정의 하기 위해서는 앞에 open을 붙여야 함
        println("""
            |*Shape
            |이름 : $name
            |타입 : $type, 색상 : $color
        """.trimMargin())
    }
}

fun main() {
    val ms = MyShape(POINT)
    ms.name = "원점"
    ms.color = RED
    ms.showStatus()
}
