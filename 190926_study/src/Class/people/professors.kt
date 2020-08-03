package Class.people

// 교수님 클래스 // init 블럭
class Professor(_name: String, _age: Int = 30) {
    var name: String? = null
    val age: Int = _age

    init { // 주요생성자의 초기화 블럭
        name = if(_name.isNotEmpty() && _name.isNotBlank()) _name.toUpperCase() else "외부"

        println("${name} 교수 (${age}) 인스턴스")
    }
}

// 2nd constructors -> 2차 생성자
class Professor2(_name: String, _age: Int = 30){
    var name: String? = null
    val age: Int = _age
    var major: String = "공학"
    var fav: Double = 0.0

    init { // 주요생성자의 초기화 블럭
        name = if(_name.isNotEmpty() && _name.isNotBlank()) _name.toUpperCase() else "외부"
        println("${name} 교수 (${age}) 인스턴스")
        fav = 30.0
    }

    //init을 먼저 처리 후 2차 생성자로 옴
    constructor(_name: String, _age: Int, _major: String): this(_name, _age) {
//        this.name = _name
//        this.age = _age
        this.major = _major
    }

    constructor(_name: String, _age: Int, _major: String, fav: Double): this(_name, _age, _major) {
        this.fav = fav
    }

    fun showStatus(num: Int) {
        val status = """
            =========== ${num} 교수 재직 증명 ===========
                이름   : $name  ${if(fav > 60.0) "##우수 교수##" else ""}
                나이   : $age 세
                전공   : ${this.major}
                평가   : ${this.fav} pt 
             ===========================================""".trimIndent()
        // 전공   : ${this.major} / this.fav == fav
        println(status)
    }

}

fun main() {
    val p1 = Professor("원종우", 26) // p.c
    val p2 = Professor("ㅇㅇㅇ") // p.c
    val p3 = Professor2("종우", 26, "ㅂ") // s1.c
    val p4 = Professor2("ㅇㅇ", 24, "ㅂ", 100.0) // s1.c
    val p5 = Professor2("ㅈ", 25, "ㅂ") // s1.c

//    p3.showStatus(1)
//    p4.showStatus(2)
//    p5.showStatus(3)

    val pfs: List<Professor2> = arrayListOf<Professor2>(p3, p4, p5)
    val piter = pfs.iterator()
    var num = 1

    while(piter.hasNext()) {
        val pf: Professor2 = piter.next()
        pf.showStatus(num++)
    }



}