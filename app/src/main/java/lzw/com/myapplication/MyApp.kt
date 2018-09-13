package lzw.com.myapplication

import android.app.Activity
import android.app.Application
import java.util.*

/**
 * Created by admin on 2018/8/28.
 */

class MyApp : Application() {

    companion object {
        var activityList: ArrayList<Activity>? = null
        var instance: Application? = null
        var isAddOrderSuccess = false
        var isLoginOutSuccess = false
        var isSearchClick = false

        fun removeAll() {
            for (activity in this!!.activityList!!) {
                activity.finish()
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        activityList = ArrayList()
        instance = this
    }


}
