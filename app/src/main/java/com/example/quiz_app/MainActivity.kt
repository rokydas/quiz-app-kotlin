package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private var countries: List<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startBtn.setOnClickListener {
            if(editName.text.toString() == "") {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("name", editName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}