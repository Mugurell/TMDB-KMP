package com.petru.tmdbkmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.petru.tbdbkmp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textMessage.text = createApplicationScreenMessage()
    }
}
