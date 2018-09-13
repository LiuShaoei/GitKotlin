package lzw.com.myapplication.base

interface BaseView<T> {
    var presenter: T
    fun error(errMsg : String)
}