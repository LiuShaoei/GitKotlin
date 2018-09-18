package lzw.com.myapplication.contract

import lzw.com.myapplication.base.BaseView
import lzw.com.myapplication.bean.DataSuccess
import lzw.com.myapplication.bean.SweepData
import lzw.com.myapplication.bean.SweepLoginBean
import lzw.com.myapplication.bean.SweepLoginSuccessBean

/**
 * Created by Administrator on 2018/9/13 0013.
 */
interface SweepLoginContract {
    interface View : BaseView<Presenter>{
        fun sendSuccess(bean : SweepLoginBean<SweepData>)
        fun sweepLoginSuccess(bean : SweepLoginSuccessBean<DataSuccess>)
    }
    interface Presenter{
        fun firstSend(token :String ,code : String)
        fun sureSend(token :String ,code : String)
    }
}