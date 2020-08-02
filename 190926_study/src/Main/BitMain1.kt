package Main

fun main(args: Array<String>) {
    // 비트의 자리수 자체가 데이터인 멀티 CCTV 카메라 스위치 제어
    val cctvA: Int = 0b0000_0001 // 0x00_00_00_01
    val cctvB: Int = 0b0000_0010 // 0x00_00_00_02
    val cctvC: Int = 0b0000_0100 // 0x00_00_00_04
    val cctvD: Int = 0b0000_1000 // 0x00_00_00_08
    val cctvE: Int = 0b0001_0000 // 0x00_00_00_10
    var cctvStatus = 0b0000_0000 // 리셋. 모두 off

    // 초기 상태 획인
    checkStatus(cctvA, cctvStatus)
    checkStatus(cctvB, cctvStatus)
    checkStatus(cctvC, cctvStatus)
    checkStatus(cctvD, cctvStatus)
    checkStatus(cctvE, cctvStatus)

    println("-----------------------------------------")
    cctvStatus = switchOn(cctvA, cctvStatus)
    cctvStatus = switchOn(cctvC, cctvStatus)
    cctvStatus = switchOn(cctvE, cctvStatus)

    println("-----------------------------------------")
    //스위치 조작후 상태
    checkStatus(cctvA, cctvStatus)
    checkStatus(cctvB, cctvStatus)
    checkStatus(cctvC, cctvStatus)
    checkStatus(cctvD, cctvStatus)
    checkStatus(cctvE, cctvStatus)

    println("-----------------------------------------")
    cctvStatus = switchOn(cctvA, cctvStatus)
    cctvStatus = switchOff(cctvC, cctvStatus)

    println("-----------------------------------------")
    //스위치 조작후 상태
    checkStatus(cctvA, cctvStatus)
    checkStatus(cctvB, cctvStatus)
    checkStatus(cctvC, cctvStatus)
    checkStatus(cctvD, cctvStatus)
    checkStatus(cctvE, cctvStatus)
}

fun switchOn(target: Int, status: Int): Int {
    println("CCTV($target) 스위치 ON")
    return status or target
}

fun switchOff(target: Int, status: Int): Int{
    println("CCTV($target) 스위치 OFF")
    return status and target.inv() // 해당되는 변수의 이진값을 반전
}

fun checkStatus(target: Int, status: Int){
    if(status and target == 0b0000_0000)
        println("CCTV($target)은 현제 OFF 상태")
    else
        println("CCTV($target)은 현제 ON 상태")


}