package lzw.com.myapplication.contract

import android.widget.EditText
import lzw.com.myapplication.base.BaseView
import lzw.com.myapplication.bean.LoginBean
import lzw.com.myapplication.bean.LoginData
import lzw.com.myapplication.bean.LoginUser

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun loginSuccess(bean: LoginBean<LoginData<LoginUser>>)
        fun getPhone(): EditText
        fun getpwd(): EditText
    }

    interface Presenter {
        fun toLogin()
    }
}