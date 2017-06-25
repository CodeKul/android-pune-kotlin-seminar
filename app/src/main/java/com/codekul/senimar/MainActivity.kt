package com.codekul.senimar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    companion object {
        val REQ_DASH = 2178
        val KEY_US_NM : String = "usNm"
        val KEY_PASS  = "pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val st: String = "codekul.com"

        var st1: String = "codekul"
        st1 = "again codekul"

        val cd: Code = Code()
    }

    fun onOkay(view: View?) {

        val kCls: KClass<DashActivity> = DashActivity::class
        val cls: Class<DashActivity> = kCls.java
        val nxtInt = Intent(this, cls)

        val usNm = (findViewById(R.id.etUserName) as EditText).text.toString()
        val pass = (findViewById(R.id.etPassword) as EditText).text.toString()

        val bnd : Bundle = Bundle()
        bnd.putString(KEY_US_NM, usNm)
        bnd.putString(KEY_PASS, pass)
        nxtInt.putExtras(bnd)

        startActivityForResult(nxtInt, REQ_DASH)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_DASH) {
            if(resultCode == Activity.RESULT_OK) {
                val bnd  = data?.extras
                val res = bnd?.getString(DashActivity.KEY_RES)
                (findViewById(R.id.txtInfo) as TextView).text = res
            }
        }
    }
}
