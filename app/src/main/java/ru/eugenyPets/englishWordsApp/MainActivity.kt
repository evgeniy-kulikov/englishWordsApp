package ru.eugenyPets.englishWordsApp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.TextView
import androidx.core.content.ContextCompat
import ru.eugenyPets.englishWordsApp.databinding.ActivityLearmWordBinding

class MainActivity : AppCompatActivity() {

    //    Урок 7: findViewById, ViewBinding, backing property  (timecode 7:00)
//    private lateinit var binding: ActivityLearmWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//    Урок 7: findViewById, ViewBinding, backing property  (timecode 7:00)
//    https://www.youtube.com/watch?v=ABoZGM6N3mE&list=PLgPRahgE-GctUcLMcQFvl00xsXqpNJOix&index=7
//        binding = ActivityLearmWordBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_learm_word)  // первоначальные проектные настройки
//        setContentView(binding.root)


//        binding.tvQuestionWord.text = "AndroidSprint.ru"

//        val tvQuestionWord: TextView = findViewById(R.id.tvQuestionWord)
//        tvQuestionWord.text = "42"
//        tvQuestionWord.setTextColor(Color.BLUE)
//        tvQuestionWord.setTextColor(Color.parseColor(("#FDD600")))
//        tvQuestionWord.setTextColor(ContextCompat.getColor(this, R.color.buttonBlueColor))


    }
}

// Найти элемент по ID
// findViewById
// ViewBinding