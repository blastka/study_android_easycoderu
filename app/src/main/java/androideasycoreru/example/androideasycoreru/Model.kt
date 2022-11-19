package androideasycoreru.example.androideasycoreru

import java.util.*

class Model {
    private var timer: Timer? = null
    private val timerTask = object : TimerTask(){
        override fun run() {
            count++
            callback?.updateText(count.toString())
        }

    }

    private var callback: TextCallback? = null
    private var count = 0


    fun start(textCallback: TextCallback){
        callback = textCallback
        timer = Timer()
        timer?.scheduleAtFixedRate(timerTask, 0, 1000)


    }

    fun stop() {
        timer?.cancel()
        timer = null
    }

}