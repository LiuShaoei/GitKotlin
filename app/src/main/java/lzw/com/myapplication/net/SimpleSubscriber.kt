package lzw.com.myapplication.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import lzw.com.myapplication.bean.DataResultException

abstract class SimpleSubscriber<T> : Observer<T> {
    constructor()

    companion object {
        var msg: String? = null
        var mDisposable: Disposable? = null
    }

    override fun onComplete() {
        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }

    override fun onSubscribe(d: Disposable) {
        mDisposable = d
    }

    override fun onNext(t: T) {
        if (t != null) {
            success(t)
        }
    }

    override fun onError(e: Throwable) {
        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
        if(e is DataResultException){
            error(e.data!!)
        }else{
            error("请求异常")
        }
    }

    abstract fun success(t: T)
    abstract fun error(msg: String)

}