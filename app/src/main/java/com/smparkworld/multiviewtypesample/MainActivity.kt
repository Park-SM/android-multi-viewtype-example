package com.smparkworld.multiviewtypesample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.smparkworld.feature.mypage.ui.MyPageActivity
import com.smparkworld.feature.search.SearchActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_my_page).setOnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
        findViewById<Button>(R.id.button_search).setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }
}