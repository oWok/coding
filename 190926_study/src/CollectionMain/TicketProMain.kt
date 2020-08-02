package CollectionMain

import java.util.*

/*
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   ***  VIP 티켓 발권  ***    [001]
  '퇴사' event
                                        rank S / 20000원
                                        2020년 5월 7일 까지
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 ============================================================
                   *** 일반 티켓 발권  ***    [002]
  '프로야구' event
                                        rank F / 10000원
                                        2020년 5월 7일 까지
 ============================================================
*/

//티켓 이름, 가격, 유효기간, 티켓 등급
// 주어진 현금으로 티켓을 랜덤하게 발권하여, 그 발권 리스트를 출력
fun main() {
    // JCF (Java Collection Framework) => JAM에서 연결되어 있음
    val eventTitles = listOf<String>("퇴사", "프로야구", "음악회", "요리 축제", "이직")
    val eventRanks: HashMap<Char, Int> = hashMapOf<Char, Int>()
    eventRanks.put('N', 1000) // 노말 등급 1000원
    eventRanks.put('H', 3000) // 하이노말 등급 3000원
    eventRanks.put('F', 5000) // 페밀리 등급 5000원
    eventRanks.put('S', 20000) // 수퍼 등급 20000원

    //티켓발권

    var cash = 60000
    val ticketList = arrayListOf<Map<String, Any?>>()

    while (cash > 0){
        // 랜덤한 이벤트 제목 부여
        val rEvent: Int = (Math.random()*eventTitles.size).toInt() // 1 ~ eventTildes의 크기 - 1
        val rRankNumber: Int = (Math.random()*100).toInt() + 1 // 1 ~ 100

        val rRank: Char = when(rRankNumber){
            in 91..100 -> 'S' // 10%
            in 71..90 -> 'F' // 20%
            in 41..70 -> 'H' // 30%
            else -> 'N' // 40%
        }

        println("eventRanks[$rRank] => ${eventRanks[rRank]}")

        //티켓 발권
        val ticket = mapOf("title" to eventTitles[rEvent], "rank" to rRank, "price" to eventRanks[rRank], "data" to Date())

        cash -= eventRanks.getValue(rRank)

        //println("tictet = ${ticket}")

        ticketList.add(ticket)
    }

    println("티켓 발권 리스트")
//    println("ticketList => ${ticketList.joinToString("\n")}")

    for((i, pt) in ticketList.withIndex())
        printTicket(pt, i)

}

fun printTicket(ticket: Map<String, Any?>, num: Int){
    val df = java.text.SimpleDateFormat("yyyy년 MM월 dd일 까지")
    val printed = """ 
        ${if(ticket.getValue("rank") == 'S') 
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" 
         else 
        "============================================================" }
                       *** ${if(ticket.getValue("rank") == 'S') "VIP" else ""}  티켓 발권  ***    [${String.format("%03d", num+1)}]
            '${ticket.getValue("title")}' event
                                                rank ${ticket.getValue("rank")} / ${ticket.getValue("price")}원
                                            ${df.format(ticket.getValue("data"))}
       ${if(ticket.getValue("rank") == 'S') 
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
       else 
        "============================================================" }"""

    println("${printed}")
}
