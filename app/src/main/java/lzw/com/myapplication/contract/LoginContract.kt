package lzw.com.myapplication.contract

import android.widget.EditText
import lzw.com.myapplication.base.BaseView
import lzw.com.myapplication.bean.Data
import lzw.com.myapplication.bean.LoginBean

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun loginSuccess(bean : LoginBean<Data>)
        fun getPhone(): EditText
        fun getpwd(): EditText
    }

    interface Presenter {
        fun toLogin()
    }
}