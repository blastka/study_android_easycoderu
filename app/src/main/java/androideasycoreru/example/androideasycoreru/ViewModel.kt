package androideasycoreru.example.androideasycoreru

import androideasycoreru.example.androideasycoreru.Model
import androideasycoreru.example.androideasycoreru.TextCallback
import androideasycoreru.example.androideasycoreru.TextObservable

class ViewModel(private val model: Model) {

    private var textObservable: TextObservable? = null

    private val textCallback = object : TextCallback {
        override fun updateText(str: String) {
            textObservable?.postValue(str)
        }

    }

    fun init(textObservable: TextObservable){
        this.textObservable = textObservable
    }

    fun clear(){
        textObservable = null
    }

    fun resumeCounting() {
        model.start(textCallback)
    }

    fun pauseCounting() {
        model.stop()
    }
}
