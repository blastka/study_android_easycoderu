package androideasycoreru.example.androideasycoreru

interface DataSource {
    fun saveInt(key: String, value: Int)
    fun getInt(key: String): Int
}