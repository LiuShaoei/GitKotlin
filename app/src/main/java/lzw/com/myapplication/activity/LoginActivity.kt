package lzw.com.myapplication.activity

import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_login.*
import lzw.com.myapplication.base.BaseActivity
import lzw.com.myapplication.bean.Data
import lzw.com.myapplication.bean.LoginBean
import lzw.com.myapplication.contract.LoginContract
import lzw.com.myapplication.presenter.LoginPresenter
import lzw.com.myapplication.utils.SharePrefUtils
import lzw.com.myapplication.utils.toast
import kotlin.com.myapplication.R

class LoginActivity : BaseActivity(), LoginContract.View {

    @BindView(R.id.phone)
    lateinit var mPhone: EditText
    @BindView(R.id.password)
    lateinit var mpwd: EditText

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initPresenter() {
        presenter = LoginPresenter(this)
    }

    override fun loginSuccess(bean: LoginBean<Data>) {

        var token by SharePrefUtils("access_token", "")
        token = bean.data.access_token
        var firstEnter by SharePrefUtils("firstEnter", false)
        firstEnter = true

        //登陆成功,跳转主页
        var intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun error(errMsg: String) {
    }


    override fun getPhone(): EditText {
        return mPhone
    }

    override fun getpwd(): EditText {
        return mpwd
    }

    override lateinit var presenter: LoginContract.Presenter

    override fun initData() {

        mTitle.text = "欢迎登陆"

        var token by SharePrefUtils("access_token", "")
        if (TextUtils.isEmpty(token)) {
            //没有token值需要登录
        } else {
            //不需要登录
            var intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    @OnClick(R.id.login)
    fun onClick(view: View) {
        when (view.id) {
            R.id.login -> {
                //登陆操作
                presenter.toLogin()
            }
        }

    }

}