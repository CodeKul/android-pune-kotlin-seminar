package com.codekul.senimar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class DashActivity : AppCompatActivity() {

    companion object {
        val KEY_RES = "res"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        val resInt = intent
        val bnd = resInt.extras
        val usNm  = bnd.getString(MainActivity.KEY_US_NM)
        val pass = bnd.getString(MainActivity.KEY_PASS)

        (findViewById(R.id.txtRes) as TextView).text = """ $usNm  CodeKul  $pass """
    }

    fun onBack(view : View?) {

        val bkInt = Intent()
        bkInt.putExtra(KEY_RES, (findViewById(R.id.txtRes) as TextView).text.toString())
        setResult(Activity.RESULT_OK, null)
        finish()
    }
}
