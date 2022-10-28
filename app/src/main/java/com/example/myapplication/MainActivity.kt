package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.rd_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        btnRiddle.setOnClickListener {
            var index = (Math.random() * 5).toInt()
            val riddleList = mutableListOf(
                "0000,猜一句成語。：四大皆空",
                "人有他大，天沒他大。猜一個字：一",
                "台灣女孩，猜一個字。：始",
                "九十九，猜一個字。：白",
                "早不說晚不說,猜一個字。:許"
            )

            edAnswer.text = null
            tvResult.text = null
            btnRiddle.setOnClickListener {
                val countRiddle = riddleList.count()
                val (riddle, answer) = riddleList[index].split(":")
                tvRiddle.text = "謎題:$riddle"
                index++
                if (index >= countRiddle)
                    index = 0

                btnAnswer.setOnClickListener {
                    val ans = edAnswer.text
                    if (ans.toString() == answer) {
                        tvResult.text = "你好棒, 你答對了!"
                        Toast.makeText(this, edAnswer.text, Toast.LENGTH_SHORT).show()
                    } else run {
                        tvResult.text = "沒猜中,再試一下吧!"
                    }
                }

                btnReAnswer.setOnClickListener {
                    edAnswer.text = null
                    tvResult.text = null
                }

                btnShowAnswer.setOnClickListener {
                    tvResult.text = "謎底是:$answer"
                }
            }
        }
    }
}