package com.example.quiz_app

import android.R.attr
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.load
import kotlinx.android.synthetic.main.activity_quiz.*
import android.R.attr.button
import android.content.Intent
import android.graphics.Color

import androidx.core.graphics.drawable.DrawableCompat

import android.graphics.drawable.Drawable
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class QuizActivity : AppCompatActivity() {

    private var selectedOption = -1
    private lateinit var optionList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        optionList = mutableListOf(option1, option2, option3, option4)

        var isSubmitted= false
        var currentIndex = 0
        var point = 0

        val name = intent.getStringExtra("name")

        val questions: List<Question> = QuestionContainer.getQuestions()

        fun setQuestionUI(question: Question) {
            questionTitle.text = question.questionTitle
            flag.load(question.imageUrl)

            option1.text = question.options[0]
            option2.text = question.options[1]
            option3.text = question.options[2]
            option4.text = question.options[3]

            submitAndNext.text = "Submit"
        }

        setQuestionUI(questions[0])

        for(i in optionList.indices) {
           optionList[i].setOnClickListener {
               showSelectedAns(i+1, optionList[i])
           }
        }

        submitAndNext.setOnClickListener {
            if(isSubmitted) {
                clearOptionColor()
                enableOptions()
                isSubmitted = false
                if(currentIndex == questions.size - 1) {
                    intent = Intent(this, FinishActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("point", point)
                    startActivity(intent)
                    finish()
                }
                else {
                    currentIndex++
                }
                setQuestionUI(questions[currentIndex])
            } else {
                if(currentIndex == questions.size - 1) {
                    submitAndNext.text = "Finish"
                } else {
                    submitAndNext.text = "Next Question"
                }

                isSubmitted = true
                val rightAns = questions[currentIndex].rightAns
                if(questions[currentIndex].rightAns == selectedOption) {
                    point++
                    Log.d("ekhane", point.toString())
                }
                showRightAns(rightAns)
            }
        }

    }

    private fun showSelectedAns(n: Int, option: Button) {
        selectedOption = n

        var buttonDrawable: Drawable? = option.background
        buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
        DrawableCompat.setTint(buttonDrawable, Color.YELLOW)
        option.background = buttonDrawable

        disableOptions()

    }

    private fun clearOptionColor() {
        for(option in optionList) {
            var buttonDrawable: Drawable? = option.background
            buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
            DrawableCompat.setTint(buttonDrawable, 14079702)
            option.background = buttonDrawable
        }
    }

    private fun showRightAns(n: Int) {
        for(i in optionList.indices) {
            if(i+1 == n) {
                var buttonDrawable: Drawable? = optionList[i].background
                buttonDrawable = DrawableCompat.wrap(buttonDrawable!!)
                DrawableCompat.setTint(buttonDrawable, Color.GREEN)
                optionList[i].background = buttonDrawable
            }
        }
    }

    private fun disableOptions() {
        for(option in optionList) {
            option.isClickable = false
        }
    }

    private fun enableOptions() {
        for(option in optionList) {
            option.isClickable = true
        }
    }
}