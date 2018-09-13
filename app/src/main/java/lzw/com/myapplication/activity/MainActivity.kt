package lzw.com.myapplication.activity

import android.view.View
import butterknife.OnClick
import lzw.com.myapplication.base.BaseActivity
import lzw.com.myapplication.utils.showFragment
import kotlin.com.myapplication.R

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter() {
    }

    override fun initData() {
        showFragment("home", R.id.frame)
    }

    @OnClick(R.id.radio_home, R.id.radio_my,R.id.radio_finance)
    fun onClick(view: View) {
        when (view.id) {
            R.id.radio_home -> showFragment("home", R.id.frame)
            R.id.radio_my -> showFragment("my", R.id.frame)
            R.id.radio_finance -> showFragment("center", R.id.frame)
        }
    }
}