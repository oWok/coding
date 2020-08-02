package Main

fun main(){
    //map -> key, vbalue pair
    //{"name":"senti"}

    var map = mapOf(Pair("퇴사", "하고싶다"))
    var mapp = mutableMapOf<String, String>()
    mapp.put("퇴사", "하고싶다")
    mapp.put("2020년", "5월6일")


    println(mapp.keys)
//    for(map in mapp){
//        println(map)
//        println(map.key)
//        println(map.value)
//    }


}