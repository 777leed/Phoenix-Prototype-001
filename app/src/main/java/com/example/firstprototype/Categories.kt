package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val relativeLayout1 = findViewById<RelativeLayout>(R.id.web)
        relativeLayout1.setOnClickListener{
            startActivity(Intent ( this@Categories,lessons_c2::class.java))
        }
        val relativeLayout2 = findViewById<RelativeLayout>(R.id.oop)
        relativeLayout2.setOnClickListener{
            startActivity(Intent ( this@Categories,lessons_c1::class.java))
        }
        val relativeLayout3 = findViewById<RelativeLayout>(R.id.r3)
        relativeLayout3.setOnClickListener{
            startActivity(Intent ( this@Categories,lessons_c3::class.java))
        }
    }
}