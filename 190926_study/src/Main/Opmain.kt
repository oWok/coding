package Main

fun main() {
    val z = 33

    when{
        false ->println("3 > 4 false")
        1 == 1 ->
            when(z){
                in 30..33 -> println("퇴사 $z")
                else -> println("z not in")
            }
        else -> println("none")
    }
}