package Class.main

import Class.books.Book // 클래스 임포트 (class import)

fun main() {
    val mybook1: Book = Book("퇴사", "원종우")
    val mybook2: Book = Book()
    val mybook3: Book = Book("2020년 5월 6 ~ 7일 퇴사")
    val mybook4: Book = Book(author = "종우")
    val mybook5: Book = mybook1 // mybook5에 mybook1을 넣어줌
    mybook5.author = "퇴사한 종우"

//    mybook1.showBook()
//    mybook2.showBook()
//    mybook3.showBook()
//    mybook4.showBook()
//    mybook5.showBook()

    // class의 배열화
    val mybooks = arrayOf(mybook1, mybook2, mybook3, mybook4, mybook5)
//  val mybooks: Array<Book> = arrayOf(mybook1, mybook2, mybook3, mybook4, mybook5) // 아래 위가 같음 // 배열의 요소의 타입

    for((i, book) in mybooks.withIndex()) {
        print("books[$i] = ")
        book.showBook()
    }

}