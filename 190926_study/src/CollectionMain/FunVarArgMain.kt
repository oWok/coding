package CollectionMain

//가변 인자 함수 vararg
// 0 ~ n개 인자개수가 가변

fun main() {
//    var nums: IntArray = intArrayOf(1,2,3)
//    varargFunction(11,22,33,44,55,66,77)
//    varargFunction(*nums)

    putIceCreams("원종우", "돼지바", "딸기맛", "수박바", "옥수수바", "빵또아")
    putIceCreams("손화민", "수박바", "슈퍼콘", "쿠크앤", "메로나", "슈크르바")
    putIceCreams("원종우", "메로나", "아프리코타")
    putIceCreams("원종우", "퇴사맛")

//    println("basket => ${basket.toList().joinToString("\n")}")

    // 뷰(view) 불변인자에 가변인자를 넣어 수정을 못하게 함
    val checkoutBasket: Map<String, String> = basket // 계산하려고 불변인자에 가변인자 값을 넣음
    //basket["원종우"] = "퇴사하자 2020년 5월 7일에" // 가능
    //checkoutBasket["원종우"] = "퇴사하자 2020년 5월 7일에" // err

    putIceCreams("손화민", "엄청 이쁨") // 불변뷰라도 가변뷰가 변경된다면 바뀜 -> 중요함

    val bonusIceCreams = arrayOf("빠삐코", "포도맛", "홍삼맛", "인삼맛", "20200507")
    putIceCreams("원종우", "퇴사", "70500202", *bonusIceCreams, "대구") //배열 앞에 * 있으면 배열이 펼처지는 되는 효과 / * -> 펼침 연산자

    for(b in checkoutBasket)
        println("${b.key} => ${b.value}")
}

val basket = mutableMapOf<String, String>() // 바구니

fun putIceCreams(customer: String, vararg ic: String){
    if(ic.size < 1)
        return

    val prevCustomer = basket[customer]
    basket.put(customer, (if(prevCustomer == null) "" else prevCustomer + ", " ) + ic.joinToString(", ")) // 기존에 MAP에 들어있다면 그것을 포함해서 추가


}

fun varargFunction(vararg numbers: Int){
    println("numbers.javaClass => ${numbers.javaClass}")
    println("numbers.sum => ${numbers.sum()}")
    println("numbers.average => ${numbers.average()}")
    println("numbers.asList => ${numbers.asList()}")
    println("numbers.size => ${numbers.size}")
}