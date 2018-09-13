package lzw.com.myapplication.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import lzw.com.myapplication.activity.MainActivity
import lzw.com.myapplication.fragment.CenterFragment
import lzw.com.myapplication.fragment.HomeFragment
import lzw.com.myapplication.fragment.MyFragment

private var lastFragment: Fragment? = null

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitAllowingStateLoss()
}

fun MainActivity.showFragment(tag: String, fragmentId: Int) {
    var fragmentTag: Fragment? = supportFragmentManager.findFragmentByTag(tag)
    if (fragmentTag == null) {
        fragmentTag = createFragment(tag)
        supportFragmentManager.inTransaction {
            if (lastFragment != null) {
                hide(lastFragment)
            }
            add(fragmentId, fragmentTag, tag)
        }
    } else {
        supportFragmentManager.inTransaction {
            if (lastFragment != null) {
                hide(lastFragment)
            }
            show(fragmentTag)
        }
    }
    lastFragment = fragmentTag
}

private fun createFragment(tag: String): Fragment {
    when (tag) {
        "home" -> return HomeFragment()
        "my" -> return MyFragment()
        "center"->return CenterFragment()
    }
    return HomeFragment()
}