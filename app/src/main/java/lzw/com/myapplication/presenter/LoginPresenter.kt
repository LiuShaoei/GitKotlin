package lzw.com.myapplication.presenter

import android.text.TextUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lzw.com.myapplication.bean.Data
import lzw.com.myapplication.bean.LoginBean
import lzw.com.myapplication.contract.LoginContract
import lzw.com.myapplication.net.NetClient
import lzw.com.myapplication.net.SimpleSubscriber
import lzw.com.myapplication.utils.ToastUtil

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {
    init {
        view.presenter = this
    }

    override fun toLogin() {
        var phone: String = view.getPhone().text.toString().trim()
        var pwd: String = view.getpwd().text.toString().trim()
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.show("手机号不为空")
            return
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtil.show("密码不为空")
            return
        }
        NetClient.apiService.login(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SimpleSubscriber<LoginBean<Data>>() {
                    override fun success(t: LoginBean<Data>) {
                        view.loginSuccess(t)
                    }
                    override fun error(msg: String) {
                        ToastUtil.show(msg)
                    }

                })
    }
}