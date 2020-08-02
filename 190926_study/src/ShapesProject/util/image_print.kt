package ShapesProject.util

import ShapesProject.*
import ShapesProject.line.*
import ShapesProject.basic.*
import ShapesProject.angle.*
import java.awt.*
import javax.swing.*

// graphics요소가 들어간 클래스

class MyCanvas(): Canvas() {
    val shapes: ArrayList<MyShape> = ArrayList() // arrayListOf(MyShape())
    private var frm: JFrame = JFrame()

    fun add(ms: MyShape){
        this.shapes.add(ms)
    }

    fun drawShapeWithSwing() {
        frm.title = "Shape 페키지 : 그리기 테스트" // 제목
        frm.bounds = Rectangle(200, 200, 1000, 1000) // 200, 200 위치에 1000 * 1000 사이지의 창이 뜸
        frm.defaultCloseOperation = JFrame.EXIT_ON_CLOSE // x를 눌럿을때 프로그램이 종료 되도록 하는것
        frm.layout = BorderLayout() // 동서남북 배치를 가지고 있는 레이아웃

        // 캔버스 처리 필요
        frm.add(this)

        val txt = JTextArea() // 개행문자를 포함하는것은 area / field는 한줄의 문자열만 받을 수 있음
        txt.background = Color.ORANGE // 자바내의 color클래스에서 오렌지색을 백그라운드로 사용한다는 뜻
        txt.text = this.shapes.joinToString("\n")
        frm.add(txt, BorderLayout.NORTH)
        frm.isVisible = true // 보여줄지에 대한것
//        frm.setVisible(true) // 보여줄지에 대한것


    }

    override fun paint(g: Graphics?) { // Canvas를 오버라이딩 // os에서 호출?
//        super.paint(g)
        this.font = Font("Arial", Font.BOLD, 20)
        this.background = Color.WHITE
        this.foreground = Color.BLACK

        for((i, s) in shapes.withIndex()) {
            when(s) {
                is MyPoint -> {
                    g?.fillOval(s.x, s.y, 5, 5) // 점을 원으로 표시한것
                    g?.drawString(s.name, s.x, s.y + 20)
                }
                is MyLine -> {
                    g?.drawLine(s.sp.x, s.sp.y, s.ep.x, s.ep.y)
                    g?.drawString(s.name, s.sp.x, s.sp.y + 20)
                }
                is MyTriangle -> {
                    g?.drawLine(s.pts[0].x, s.pts[0].y, s.pts[1].x, s.pts[1].y)
                    g?.drawLine(s.pts[1].x, s.pts[1].y, s.pts[2].x, s.pts[2].y)
                    g?.drawLine(s.pts[2].x, s.pts[2].y, s.pts[0].x, s.pts[0].y)
                    g?.drawString(s.name, s.pts.first().x, s.pts.first().y + 20)
                }
                else -> { // MyShape ..
                    this.foreground = Color.RED
                    g?.drawString("ERROR : NOT Paintable Shape!", 40, 40)
                }
            }
        }
    }
}

fun main() {
//    val can = MyCanvas()
//    can.add(MyPoint(100,  100, "point A"))
//    can.drawShapeWithSwing()

    val can = MyCanvas()
    can.add(MyPoint(0, 0, "Point A"))
    can.add(MyPoint(10, 0, "Point B"))
    can.add(MyPoint(0, 10, "Point C"))
    can.add(MyPoint(20, 0, "Point D"))
    can.add(MyPoint(0, 20, "Point E"))

    can.add(MyLine(30, 30, 50, 50, "line A"))
    can.add(MyLine(50, 50, 100, 100, "line B"))

    can.add(MyTriangle(MyPoint(200, 200), MyPoint(300, 200), MyPoint(200, 300), "triangle A"))
    can.add(MyTriangle(MyPoint(600, 600), MyPoint(700, 650), MyPoint(770, 690), "triangle B"))

    can.drawShapeWithSwing()

}