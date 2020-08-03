package Main

fun main(){
    //map -> key, vbalue pair
    //{"name":"senti"}

    var map = mapOf(Pair("ㅇ", "하고싶다"))
    var mapp = mutableMapOf<String, String>()
    mapp.put("ㅇ", "하고싶다")
    mapp.put("3", "2")


    println(mapp.keys)
//    for(map in mapp){
//        println(map)
//        println(map.key)
//        println(map.value)
//    }


}