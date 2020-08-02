package Main

fun main() {
    whichType(123.22)
    whichType(11)
    whichType("퇴사")
    whichType('가')
    whichType(true)
    whichType(123L)

}

fun whichType(data: Any){
//    if(data is String){
//
//    }
//    else{
//
//    }

    when(data){
        is String -> {
            println("data.length의 길이 : ${data.length}")
//            val result: String = data as String
//            println("result.length의 길이 : ${result.length}")
        }
        is Int -> {
            println("data의 두배 값 : ${data*2}")
//            val result: Int = data as Int
//            println("result의 두배 값 : ${result*2}")
        }
        else -> {
            println("${data}는 String도 아니고 Int도 아니다 ${data.javaClass} 형이다")
            val result = data as? Float
            println("${data}를 강제로 float로 변환 = ${result}")
        }
    }
}