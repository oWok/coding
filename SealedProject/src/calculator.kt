import java.lang.ArithmeticException

// sealed class vs enum class
// 계산기 calculator (+, -, *, /, %, pow, sqrt)
// 코틀린에서 재공되는 연산자 오버로딩을 사용해야함 원래

sealed class Calculator { // 제한된 상속 개층 범위를 지정 // 그자체가 추상클래스기 떄문에 생성자를 만들 수 없음
	// 상속 받은 클래스를 외부에 있어도 가능
	class Sum(val a: Int, val b: Int): Calculator()
	class Subtract(val a: Int, val b: Int): Calculator()
	class Multiply(val a: Int, val b: Int): Calculator()
	class Divide(val a: Int, val b: Int): Calculator()
	class Remainder(val a: Int, val b: Int): Calculator()
//    class Pow(val a: Int, val b: Int): Calculator()

	companion object { // static에 준하는 함수
		fun cul(op: Calculator)= when(op) {
			is Sum -> op.a + op.b
			is Subtract -> op.a - op.b
			is Multiply -> op.a * op.b
			is Divide ->
				if(op.b == 0) {
					throw ArithmeticException("Divide by zero for Divide")
				}
				else op.a / op.b.toDouble()
			is Remainder ->
				if(op.b == 0) {
					throw ArithmeticException("Divide by zero for Remainder")
				}
				else op.a % op.b
			is Pow -> {
				var z = 1
				for(i in 1..op.b) z *= op.a
				z // 마지막의 값이 리턴되어 나감
			}
//            else -> throw IllegalArgumentException("Unknown Calculator SubType")
//                else -> {} // sealed에서 타입을 다 체크하기 떄문에 지금과 같은 상황에서는 필요 없음 / 덜 불러왔다면 필요는 하겟지만 권장하는 코드는 아님

		}
	}
}

class Pow(val a: Int, val b: Int): Calculator()

//typealias a = package1.ABC -> 타입 별칭(typealias)
typealias Cal = Calculator
typealias CSum = Calculator.Sum
typealias CSub = Calculator.Subtract
typealias CMul = Calculator.Multiply
typealias CDiv = Calculator.Divide
typealias CRem = Calculator.Remainder

class Dummy

enum class Operation(val a: Int, val b: Int){
	SUM(1, 3) { // 객체지만 추상메소드를 만들어야함 // 같은 이름으로는 오직 1개만 생성가능
		override fun cul(): Int {
			return a + b
		}
	},
	SUB(8, 9) {
		override fun cul(): Int {
			return a - b
		}
	}, MUL(2, 3) {
		override fun cul(): Int {
			return a * b
		}
	}, DIV(3, 1) {
		override fun cul(): Int {
			return if(b == 0) throw ArithmeticException("0으로 나누지 마라")
			else a / b
		}
	};

	abstract fun cul(): Int
}
fun main() {
//    val ex0: Calculator = Calculator() / sealed class -> pravite / 추상클래스 / error, abstract
	val ex1: Calculator = CSub(20200430, 20191121)
	val val1 = Calculator.cul(ex1) as Int
	println("val1 = ${val1}")

//    val ex2: Calculator = Dummy()
	val ex2: Calculator = CSub(12,3)

	val result = Cal.cul(CMul(Cal.cul(CSum(3, 5)) as Int, (Cal.cul(CDiv(33, 11)) as Double).toInt()))

	println("(3+5)*(33/11) = ${result}")

	// (8-13)^2 // pow
	val result2 = Cal.cul(Pow(Cal.cul(ex2) as Int, 0))
	println("result2 = ${result2}")
}