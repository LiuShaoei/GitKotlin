package lzw.com.myapplication.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import lzw.com.myapplication.MyApp
import kotlin.com.myapplication.R

abstract class BaseActivity : AppCompatActivity() {
    lateinit var unbind: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        unbind = ButterKnife.bind(this)
        MyApp.activityList!!.add(this)
        initPresenter()
        initData()
    }

    //得到布局Id
    abstract fun getLayoutId(): Int

    //初始化p层
    abstract fun initPresenter()

    //初始化数据
    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        unbind!!.unbind()
     //   MyApp!!.removeAll()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        enterActivityAnimation()
    }

    private fun enterActivityAnimation() {

        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    override fun finish() {
        super.finish()
        exitActivityAnimation()
    }

    private fun exitActivityAnimation() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }


}