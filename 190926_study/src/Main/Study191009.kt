package Main

fun main() {
    println(converCharToHex('f'))
    println(converCharToHex('@'))
    println(converCharToHex('t'))
    println(converCharToHex('9'))
    println(converCharToHex('#'))
    println(converCharToHex('A'))
}

fun converCharToHex(ch: Char): Int {
    var result: Int = -1

    if(ch in '0'..'9' || ch in 'A'..'F' || ch in 'a'..'f'){
        when {
            ch.isDigit() -> result = ch.toInt() - '0'.toInt() // 'ch' - '0' // 코드 포인트 값 차이
            ch.isLetter() -> {
                result = if (ch.isUpperCase()) ch.toInt() - 'A'.toInt()
                else ch.toInt() - 'a'.toInt()

                result += 10
            }
            else -> println("${ch} 에러!")
        }
    }
    else{
        println("${ch}는 16진수 심볼이 아닙니다.")
    }
    return result
}