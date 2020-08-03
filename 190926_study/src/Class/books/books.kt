package Class.books

// 책, book
// class Book -> body부분이 없어도 생성 가능함
//class Book {} // -> 새로운 자료형 정의
/*
class Book  {
    // 필드 => 프라퍼티(외부에서 클래스의 내부 내용을 조작할 수 있는 규격?
    val publisher: String = "퇴가사 목표인 원종우" // : String 생략가능 뒤에 들어가는 값으로 추론 가능
    var title: String? = null

    // 행위 = 메소드
    fun showBook() {
        println("'${title ?: "no name"}'책, $publisher 발행")
    }

}
*/

// 주요 생성자를 이용 / 생성자 함수 (프라이머리 컨트럭트)
/*
class Book(var title: String?, var author: String?) {
    // 필드 => 프라퍼티(외부에서 클래스의 내부 내용을 조작할 수 있는 규격?
    val publisher: String = "퇴가사 목표인 원종우" // : String 생략가능 뒤에 들어가는 값으로 추론 가능
    //var title: String? = null


    // 행위 = 메소드
    fun showBook() {
        println("'${title ?: "no name"}'책, ${author ?: "작자미상"} ${if(!author.equals(null)) "지음" else ""} $publisher 발행")
    }

}
*/

// 기본인자 적용 => 네임드 파리마터 적용 가능
class Book(var title: String? = null, var author: String? = "작자미상") {
    val publisher: String = "aa"

    fun showBook() {
        println("'${title ?: "no name"}'책, ${author ?: "작자미상"} ${if(!author.equals("작자미상")) "지음" else ""} ${publisher} 발행")
    }
}

//fun main() {
//    // 새로운 타입을 사용해서 변수/상수를 생성
////    val mybook: Book = Book()  // 생성자 호출 / 개체 (인스턴스화)
////    mybook.publisher // 필드의 내용을 참조
////     mybook.publisher = "ㅇ" -> val => read only / error
////    mybook.title = "ㅇ"
////    val mybook = Book("ㅇ", "원종우")
////    val mybook = Book()
//    val mybook = Book(author = "원종우")
//
//    println("mybook = ${mybook}\t${mybook.javaClass.name}")
//    println("mybook.publissher = ${mybook.publisher}")
//    println("mybook.title = ${mybook.title}")
//    println("mybook.author = ${mybook.author}")
//
//    mybook.title = null
////    mybook.author = null
//
//    mybook.showBook()
//}