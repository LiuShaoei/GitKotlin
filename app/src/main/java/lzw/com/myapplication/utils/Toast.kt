package lzw.com.myapplication.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    var t:Toast? = null

    if(t  == null) {
        t = Toast.makeText(this, message, duration)
    }
    t!!.show()
}