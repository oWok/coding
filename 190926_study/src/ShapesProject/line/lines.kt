package ShapesProject.line
import ShapesProject.LINE
import ShapesProject.MyShape
import ShapesProject.basic.MyPoint

open class MyLine(_name: String = "테스트"): MyShape(LINE){
    var sp: MyPoint
    var ep: MyPoint
    var thick: Int = 1
//    private val strokeType = "solid" // solid : 실선
    open protected val strokeType = "solid" // private는 자신 이외에 아무도 못쓰지만 protected는 자손과 자기 자신만 사용가능 / 오버라이딩하기 위해서는 open을 써줘야함

    init {
        super.name = _name
        sp = MyPoint()
        ep = MyPoint()
    }

    constructor(_sp: MyPoint ?= MyPoint(), _ep: MyPoint?, _name: String): this(_name) { //_name 초기화를 위임
        this.sp = _sp ?: MyPoint()
        this.ep = _ep ?: MyPoint(10, 10)

    }

    constructor(x1: Int = 0, y1: Int = 0, x2: Int = 0, y2: Int = 0, _name: String): this(_name){
        sp = MyPoint(x1, y1)
        ep = MyPoint(x2, y2)
    }

    fun getDistance() = Math.sqrt((ep.y - sp.y)*(ep.y - sp.y).toDouble() + (ep.x - sp.x)*(ep.x - sp.x).toDouble())

    fun pos() = Pair(sp, ep)

    private fun printLine() {
        println("""
        |선종류 : $strokeType, 선두께: $thick pt
        |시작점 : ${sp.pos()} => 끝점 : ${ep.pos()} 
        |길이 : ${String.format("%.2f", getDistance())}
    """.trimMargin())
    }

    final override fun showStatus() { // 상속받은 함수 // final이 붙으면 자신 밑으로는 다시 재정의 할수 없다
        super.showStatus()
        printLine()
    }
}

class MyDootedLine: MyLine {
    init {
        super.thick = 2
    }

    override val strokeType: String = "dotted" // 프라퍼티 오버라이딩
        //get() = super.strokeType -> 생략가능


    constructor(_sp: MyPoint ?= MyPoint(), _ep: MyPoint?, _name: String): super(_sp, _ep, _name)  // :super -> 부모의 생성자를 호출함 /this는 또다른 생성자를 호출함
    constructor(x1: Int = 0, y1: Int = 0, x2: Int = 0, y2: Int = 0, _name: String): super(x1, y1, x2, y2, _name)


}

class MyDashedLine: MyLine {
    init {
        super.thick = 3
    }

    override val strokeType: String = "dashed" // 프라퍼티 오버라이딩
    //get() = super.strokeType -> 생략가능


    constructor(_sp: MyPoint ?= MyPoint(), _ep: MyPoint?, _name: String): super(_sp, _ep, _name)  // :super -> 부모의 생성자를 호출함 /this는 또다른 생성자를 호출함
    constructor(x1: Int = 0, y1: Int = 0, x2: Int = 0, y2: Int = 0, _name: String): super(x1, y1, x2, y2, _name)

}

//fun main() {
//    val line1: MyLine = MyLine()
//    val line2: MyLine = MyLine("퇴사")
//    val line3: MyLine = MyLine(10,10,50,70, "20200430퇴사")
//    val line4: MyLine = MyLine(MyPoint(), MyPoint(50,30), "20200501대구로 가자")
//    val line5: MyDootedLine = MyDootedLine(10, 10, 50, 20, "툇")
//    val line6: MyDashedLine = MyDashedLine(10, 10, 50, 20, "툇")
//
//
//    val myLines = arrayListOf<MyLine>(line1, line2, line3, line4, line5, line6)
//
//    for(ln in myLines)
//        ln.showStatus()
//
//
//}