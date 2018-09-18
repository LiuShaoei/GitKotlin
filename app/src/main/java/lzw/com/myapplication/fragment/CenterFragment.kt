package lzw.com.myapplication.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.PermissionListener
import kotlinx.android.synthetic.main.fragment_center.*
import lzw.com.myapplication.activity.LoginActivity
import lzw.com.myapplication.activity.ScanerCodeActivity
import lzw.com.myapplication.utils.SharePrefUtils
import org.jetbrains.anko.support.v4.toast
import kotlin.com.myapplication.R

class CenterFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_center, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        saoyisao.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.saoyisao -> {
                var firstEnter by SharePrefUtils("firstEnter", false)
                if(firstEnter){
                    if (Build.VERSION.SDK_INT >= 23) {
                        AndPermission.with(this)
                                .requestCode(200)
                                .permission(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                .callback(listener)
                                .start()
                    } else {
                        var intent = Intent()
                        intent.setClass(activity, ScanerCodeActivity::class.java)
                        startActivity(intent)
                    }
                }else{
                    //当前检测到未登录,跳转到的登陆
                    toast("当前未登录,请登录后操作")
                    var intent = Intent()
                    intent.setClass(activity,LoginActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    private val listener = object : PermissionListener {
        override fun onSucceed(requestCode: Int, grantedPermissions: List<String>) {
            // 权限申请成功回调。
            if (requestCode == 200) {
                val intent2 = Intent(activity, ScanerCodeActivity::class.java)
                startActivity(intent2)
            }
        }

        override fun onFailed(requestCode: Int, deniedPermissions: List<String>) {
        }
    }
}
