package rsk

interface Time { // no "public" keyword
    fun setTime(hours: Int, minutes: Int = 0, seconds: Int = 0) // no "public" keyword

    fun setTime(time: KevinTime) = // default implementation
        setTime(time.hours)
}

interface EndOfTheWorld {
    fun setTime(time: KevinTime) {
    }
}

class KevinTime {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
}

class YetiTime: Time, EndOfTheWorld { // no implements/extends keyword. 2 interfaces implemented.
    override fun setTime(hours: Int, minutes: Int, seconds: Int) { // override MUST be explicit
        TODO("Not yet implemented")
    }

    override fun setTime(time: KevinTime) { // MUST override even only one method is default
        super<EndOfTheWorld>.setTime(time) // use default from Time
    }
}
