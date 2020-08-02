package ShapesProject.angle

import ShapesProject.MyShape
import ShapesProject.RECTANGLE
import ShapesProject.TRIANGLE
import ShapesProject.basic.MyPoint
import ShapesProject.line.MyLine

class MyTriangle: MyShape {
//    val pt0: MyPoint? = null
//    val pt1: MyPoint? = null
//    val pt2: MyPoint? = null

    val pts: ArrayList<MyPoint> = ArrayList()
    val lines: ArrayList<MyLine> = ArrayList()

    constructor(pt0: MyPoint, pt1: MyPoint, pt2: MyPoint, _name: String): super(TRIANGLE) {
        name = _name // 앞에 있는 name에는 super이 생략되어있음
        pts.add(pt0)
        pts.add(pt1)
        pts.add(pt2)

//        (0..2).mapTo(lines) { // it -> 0, 1, 2
//            MyLine(pts[it], pts[if(it==2) 0 else it+1], "삼각형의 변$it")
//        }
        // 위에것과 동일함
        lines.add(MyLine(pt0, pt1, "삼각형의 변1"))
        lines.add(MyLine(pt1, pt2, "삼각형의 변2"))
        lines.add(MyLine(pt2, pt0, "삼각형의 변3"))
    }

    constructor(pts: Array<MyPoint>, _name: String): super(TRIANGLE) {
        name = _name
//        this.pts = pts // val이기 떄문에 error
        if(pts.size != 3) throw IllegalAccessException("점이 3개가 아닙니다")
            this.pts.addAll(pts)

        (0..2).mapTo(lines) { // it -> 0, 1, 2
            MyLine(pts[it], pts[if(it==2) 0 else it+1], "삼각형의 변$it")
        }
    }

    private fun printTrangle() {
        println("""
            |점0 : ${pts[0].pos()} => 점1: ${pts[1].pos()} => 점2 : ${pts[2].pos()}
            |넓이 : ${String.format("%.4f", getArea())} pt^2
            |
        """.trimMargin())
    }

    fun pos() = Triple(pts[0], pts[1], pts[2])

    // 해론의 공식 -> 넓이
    fun getArea(): Double {
        val ds = doubleArrayOf(lines[0].getDistance(), lines[1].getDistance(), lines[2].getDistance())
        val s = ds.sum()/2 // semi-perimeter
        val area = Math.sqrt(s * (s - ds[0]) * (s - ds[1]) * (s - ds[2]))

        return area
    }

    final override fun showStatus() {
        super.showStatus()
        printTrangle()
    }
}

class MyRectangle: MyShape(RECTANGLE) {

}

// class MyPentagon: MyShape(PENTAGON) // 오각형

fun main() {
    val triA: MyTriangle = MyTriangle(MyPoint(), MyPoint(40, 10), MyPoint(10, 40), "삼각형A")
    val triB: MyTriangle = MyTriangle(arrayOf(MyPoint(), MyPoint(30, 0), MyPoint(0, 30)), "직각삼각형B")

    triA.showStatus()
    triB.showStatus()
    triA.lines.forEach() { it.showStatus() }
}