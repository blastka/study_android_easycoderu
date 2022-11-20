package androideasycoreru.example.androideasycoreru

interface TimeTicker {

    fun start(callback: Callback, period: Long = 1000)

    fun stop()

    interface Callback{
        fun tick()
    }
}