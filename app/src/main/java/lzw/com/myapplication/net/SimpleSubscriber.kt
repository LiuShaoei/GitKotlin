package lzw.com.myapplication.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

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
        error("请求异常")

        if (mDisposable != null && !mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }

    }

    abstract fun success(t: T)
    abstract fun error(msg: String)

}