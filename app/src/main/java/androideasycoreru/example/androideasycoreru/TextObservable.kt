package androideasycoreru.example.androideasycoreru

import androideasycoreru.example.androideasycoreru.TextCallback

class TextObservable {
    private lateinit var callback: TextCallback

    fun observe(callback: TextCallback){
        this.callback = callback
    }

    fun postValue(text: String){
        callback.updateText(text)
    }
}

