package androideasycoreru.example.androideasycoreru

import org.junit.Assert.assertEquals
import org.junit.Test

internal class ModelTest{

    @Test
    fun start_model(){
        //нужно создать нашу model
        val testDataSource = TestDataSource()
        val testTimeTicker = TestTimeTicker()
        val model = Model(testDataSource, testTimeTicker)
        val textCallback = TestTextCallback()
        model.start(textCallback)
    }

    //две тестовые реализации входящих аргументов
    //на datasourse
    //какое-то значение получить нужно не существующее
    class TestDataSource : DataSource{
        private var int = Int.MIN_VALUE
        //приходящее сохранить
        override fun saveInt(key: String, value: Int) {
            int = value
        }
        //его же получить
        override fun getInt(key: String): Int {
            return int
        }

    }


    //на таймер
    class TestTimeTicker: TimeTicker{
        var callback: TimeTicker.Callback? = null
        var state = 0
    //заменяем реализацию методов
        override fun start(callback: TimeTicker.Callback, period: Long) {
            this.callback = callback
            state = 1 //а почему 1?
        }

        override fun stop() {
            callback = null
            state = -1
        }
    }

    //и так как в модели текстовый колбэк, его реализацию тоже нужно заменить
    class TestTextCallback : TextCallback{
        //сначала будет пустая
        var text = ""
        //присваиваем
        override fun updateText(str: String) {
            text = str
        }

    }
}