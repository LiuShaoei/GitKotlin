package lzw.com.myapplication.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lzw.com.myapplication.bean.DataSuccess
import lzw.com.myapplication.bean.SweepData
import lzw.com.myapplication.bean.SweepLoginBean
import lzw.com.myapplication.bean.SweepLoginSuccessBean
import lzw.com.myapplication.contract.SweepLoginContract
import lzw.com.myapplication.net.NetClient
import lzw.com.myapplication.net.SimpleSubscriber
import lzw.com.myapplication.utils.ToastUtil

/**
 * Created by Administrator on 2018/9/13 0013.
 */
class SweepLoginPresenter(val view: SweepLoginContract.View): SweepLoginContract.Presenter{
    init {
        view.presenter = this
    }

    override fun firstSend(token: String, code: String) {
        NetClient.apiService.sweepLogin(token,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SimpleSubscriber<SweepLoginBean<SweepData>>() {
                    override fun success(t: SweepLoginBean<SweepData>) {
                        view.sendSuccess(t)
                    }
                    override fun error(msg: String) {
                        ToastUtil.show(msg)
                    }

                })

    }

    override fun sureSend(token: String, code: String) {
        NetClient.apiService.sureSweepLogin(token,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SimpleSubscriber<SweepLoginSuccessBean<DataSuccess>>() {
                    override fun success(t: SweepLoginSuccessBean<DataSuccess>) {
                         view.sweepLoginSuccess(t)
                    }
                    override fun error(msg: String) {
                        ToastUtil.show(msg)
                    }

                })

    }

}