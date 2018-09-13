package lzw.com.myapplication.utils

import android.widget.Toast
import lzw.com.myapplication.MyApp

object ToastUtil {
    private var TOAST: Toast? = null
    fun show(text: String,duration: Int = Toast.LENGTH_SHORT) {
        if (TOAST == null) {
            TOAST = Toast.makeText(MyApp.instance, text, duration)
        } else {
            TOAST?.setText(text)
        }
        TOAST?.show()
    }
}