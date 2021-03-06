package html

// n x m HTML table

// singleton object (instance)
object MyRecord {
    private var _count = 0
    private val _tables = hashMapOf<String, MyHtml>() // <key, value>

    fun showTableCount() = _count
    fun showTable(): Map<String, MyHtml> = _tables

    fun gen(table: MyHtml){
        _tables.put(table.name, table)
        _count++
    }
}

class MyHtml {
    val name: String
    val row: Int
    val col: Int
    private val HEAD = "<table border='1' cell-spaceing='10' cell-padding='10'>"
    private val TAIL = "</table>"
    private lateinit var comment: String
    private val tableColumns = ArrayList<String>() // 열제목


   private constructor(_name: String, row: Int, col: Int){
        this.name = _name
        this.row = row
        this.col = col
    }

    fun setColumnHeaders(vararg colNames: String) {
        this.tableColumns.addAll(colNames)
    }

    // 3 x 4
    companion object _GenTable{ // inner객체이기 때문에 클래스의 자원에는 접근 가능 -> 클래스의 타입처럼 접근
        fun generateHtmlObject(_name: String, row: Int = 3, col: Int = 4): MyHtml {
            val mh = MyHtml(_name, row, col)
            mh.comment = "<!-- ㄷ auto-generated table bt MyHtml -->"
            // 테이블 객체 기록

            MyRecord.gen(mh)

            return mh
        }
    }

    private inner class Tr { // table row에대한 클래스
        val rowHtmlCode = """
            |<tr>
            | ${"<td> ㄷ </td>\n".repeat(col)}
            |</tr>
        """.trimMargin()
    }

    private inner class Th(val wpx: Int = 40) { // table header row
        val headers = tableColumns.map {
            "<th width='$wpx'> $it </th>"
        }

        val rowHtml = """
            |<tr>
            |  ${headers.joinToString("")}
            |</tr>
        """.trimMargin()
    }

    // 테이블 생성
    fun gennerateTable() =
        """
            |$comment
            |$HEAD
            |${Th().rowHtml}
            |${Tr().rowHtmlCode.repeat(row)} 
            |$TAIL
        """.trimMargin() // <tr>..<td></td>..</tr>

}

fun main() {
//    MyRecord() // 이 자체가 객체기 때문에 생성자 호출 안됨
//    MyHtml("ㄷ", 2, 3) // 생성자가 private이기 떄문에 error

    val first = MyHtml.generateHtmlObject("ㄷ1->ㅇ") // row : 3 col : 4
    first.setColumnHeaders("ㅇ?", "ㅇ?", "ㅇ 확정")
//    println("first.gennerateTable() = ${first.gennerateTable()}")
    val second = MyHtml.generateHtmlObject("ㄷ2")
    second.setColumnHeaders("ㄷ", "ㅇ", "ㅇ", "ㄹ", "ㅎ", "ㄷ", "ㅈ", "ㅂ", "ㅗ")

    val third = MyHtml.generateHtmlObject("ㄷ3", 7, 2)
    third.setColumnHeaders("ㅇ", "ㅗ", "ㅂ")

    println("생성된 table 개수 : ${MyRecord.showTableCount()}")

    for((k, v) in MyRecord.showTable()) {
        println("\n <!-- $k table (${v.row} * ${v.col} -->)")
        println(v.gennerateTable())
        println()
    }
}