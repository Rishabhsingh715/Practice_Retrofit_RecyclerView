package com.cv.prac_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                val users: List<User> = obj.retro_obj.getAllUsers()

                val adapter = ServiceAdapter(users)

                RV.layoutManager = LinearLayoutManager(this@MainActivity)
                RV.adapter = adapter




            } catch (e: Exception) {
                Log.d("MainActivity", " Failed${e.toString()}")


            }

        }

    }
}