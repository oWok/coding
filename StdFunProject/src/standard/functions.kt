package standard


class StandardFunction {
    init {
        letFunc()
        mapFunc()
        withFunc()
        applyFunc()
        runFunc()
        alsoFunc()
    }

    fun letFunc(): Unit {
        val obj: String = "ㄷ!"
        var count = 0
        val result: Char = obj.let {
            println("[${count}] in the let() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
            println("it = ${it}")
//            return
            return@let '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
        }

        println("result = ${result} and count => ${count}\n\n")
    }
    fun mapFunc(): Unit {
        val obj: List<Char> = "ㄷ!".toList()
        var count = 0
        val result = obj.map {
            println("[${count}] in the map() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
            println("it = ${it}")
//            return
//            return@map '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
//            return '툇'
//            '툇'
            it.toLowerCase()
        }
        println("result => ${result} and count => ${count}\n\n")
    }


    fun withFunc(): Unit {
        val obj: Toy = Toy("종우", ㄱ, ToyType.CAR)
        var count = 0
        val result = with(obj) {// with는 일반함수 처럼 동작
            println("[${count}] in the with() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
//            println("it = ${it}") // error
            this.name += "야 ㅂ까지 열심히 공부해서 준비하자"
            price = 20200429
            category = ToyType.SPACHSHIP
//            return
//            return@map '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
//            return '툇'
            '툇'
        }
        println("result => ${result} and count => ${count}\nobj => ${obj}\n\n")
    }
    fun applyFunc(): Unit {
        val obj: Toy = Toy("ㅂ ")
        var count = 0
        val result = obj.apply {// apply는 일반함수 처럼 동작
            println("[${count}] in the apply() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
//            println("it = ${it}") // error
            this.name += ": ㄱ"
            price = 20200501
            category = ToyType.SPACHSHIP
//            return
//            return@map '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
//            return '툇'
            '툇'
        }
        println("result => ${result} and count => ${count} \nobj => ${obj}\n\n")
    }
    fun runFunc(): Unit {
        val obj: Toy = Toy("ㅂ ")
        val obj2: Toy = Toy("ㅂ").apply { name += " -> ㄱ" }.apply { price = 152 }.apply { category = ToyType.BRICK } // 빌드를 통해 이렇게도 가능
        var count = 0
        val result = obj.run {// run은 일반함수 처럼 동작
            println("[${count}] in the run() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
//            println("it = ${it}") // error
            name += ": ㄱ"
            price = 20200429
            category = ToyType.CAR
//            return
//            return@map '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
//            return '툇'
            '툇'
        }
        println("result => ${result} and count => ${count} \nobj => ${obj}\n\n")
    }
    fun alsoFunc(): Unit {
        val obj: Toy = Toy("ㅂ ")
        var count = 0
        val result = obj.also {
            println("[${count}] in the also() function: ")
            count++
            println("this = ${this}")
            println("this@StandardFunction = ${this@StandardFunction}")
            println("it = ${it}")
//            this.name += ": ㄱ" // error
//            price = 20200501 // error
//            category = ToyType.SPACHSHIP // error
//            also에서는 this는 standardfunction을 나타내는 것이지 obj를 나타 내는것이 아님
            it.name += "하자"
            it.price = 152
            it.category = ToyType.SPACHSHIP
//            return
//            return@map '툇'// let이라는 함수형 확장함수의 호출 람다블럭의 리턴 (지역블럭에 대한 리턴)
//            return '툇'
            '툇'
        }
        println("result => ${result} and count => ${count} \nobj => ${obj}\n\n")
    }

}

enum class ToyType {
    NONE, ROBOT, DOLL, CAR, BRICK, SPACHSHIP
}

data class Toy(var name: String, var price: Int = 0, var category: ToyType = ToyType.NONE)

fun main() {
//    StandardFunction().letFunc()
    StandardFunction()
}