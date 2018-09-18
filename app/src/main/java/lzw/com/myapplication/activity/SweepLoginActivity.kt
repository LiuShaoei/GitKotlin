package lzw.com.myapplication.activity

import android.text.TextUtils
import android.view.View
import butterknife.OnClick
import lzw.com.myapplication.base.BaseActivity
import lzw.com.myapplication.bean.DataSuccess
import lzw.com.myapplication.bean.SweepData
import lzw.com.myapplication.bean.SweepLoginBean
import lzw.com.myapplication.bean.SweepLoginSuccessBean
import lzw.com.myapplication.contract.SweepLoginContract
import lzw.com.myapplication.presenter.SweepLoginPresenter
import lzw.com.myapplication.utils.SharePrefUtils
import lzw.com.myapplication.utils.toast
import kotlin.com.myapplication.R

/**
 * Created by Administrator on 2018/9/13 0013.
 */
class SweepLoginActivity : BaseActivity(), SweepLoginContract.View {

    var uuid: String = ""
    override fun sweepLoginSuccess(bean: SweepLoginSuccessBean<DataSuccess>) {
        toast("登陆成功")
        finish()
    }

    override lateinit var presenter: SweepLoginContract.Presenter

    override fun sendSuccess(bean: SweepLoginBean<SweepData>) {
        toast("扫描成功")
    }

    override fun error(errMsg: String) {
    }

    override fun initPresenter() {
        presenter = SweepLoginPresenter(this)
    }

    override fun initData() {
        uuid = intent.getStringExtra("result")
        var token by SharePrefUtils("access_token", "")
        if (TextUtils.isEmpty(token)) {
            toast("当前未登录,请登录后操作")
            return
        }
        presenter.firstSend(token, uuid)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_sweep_login
    }

    @OnClick(R.id.sweep_login)
    fun OnClick(view: View) {
        when (view.id) {
            R.id.sweep_login -> {
                var token by SharePrefUtils("access_token", "");
                if (TextUtils.isEmpty(token)) {
                    toast("当前未登录,请登录后操作")
                    return
                }
                presenter.sureSend(token, uuid)
            }
        }
    }
}