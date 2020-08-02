package Main

fun main(args: Array<String>) {
    //xor
    val input = "ABCD"
    val password = 0x1234_5678

    println("\n암호화 encryption")

    val encrypted = Array(input.length, {0}) // input의 길의만큼의 배열을 만들고 0으로 초기화

    for((i,ch) in input.withIndex()){ //input값의 순서와 그 자리의 문자도 가져옴 (0, 'A') (1, 'B') (2, 'C') (3, 'D')
        println("i = $i, ch = $ch, val = x${ch.toInt().toString(16)}")
        encrypted[i] = ch.toInt() xor password // 배타적 or
    }

    for(en in encrypted)
        println("en => ${en.toChar()} => ${en}")

    println("\n복호화 dscryption")

    val decryption = Array(input.length, {0})

    for((i, en) in encrypted.withIndex())
        decryption[i] = en xor password

    for(de in decryption)
        println("de => ${de.toChar()} => $de")
}