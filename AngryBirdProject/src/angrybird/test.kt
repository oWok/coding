package angrybird

interface Sing {
    fun singAsong(sub: String = "")
}

interface SingWell: Sing {
    fun singAsongVeryWell(sub: String = "Very Well") {
        singAsong(sub)
    }
}

interface SingPro: Sing, SingWell {
    fun singAsongLikePro() {
        singAsongVeryWell("Very Well Like a Pro!")
    }
}

class Singer: SingPro {
    override fun singAsong(sub: String) {
        println("I Sing a song $sub")
    }
}

fun main() {
    Singer().singAsong()
    Singer().singAsongVeryWell()
    Singer().singAsongLikePro()
}