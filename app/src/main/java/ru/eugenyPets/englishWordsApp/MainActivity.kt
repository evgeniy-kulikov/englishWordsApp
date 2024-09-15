package ru.eugenyPets.englishWordsApp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import ru.eugenyPets.englishWordsApp.databinding.ActivityLearmWordBinding

class MainActivity : AppCompatActivity() {


//    ViewBinding
//    Урок 7: findViewById, ViewBinding, backing property  (timecode 7:00)
//  Объявление переменной для сохранения экземпляра Binding класса
// lateinit - отложенная иницианализация
    private lateinit var binding: ActivityLearmWordBinding  // ActivityLearmWordBinding - класс файла разметки

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//    ViewBinding
//    Урок 7: findViewById, ViewBinding, backing property  (timecode 7:00)
//    https://www.youtube.com/watch?v=ABoZGM6N3mE&list=PLgPRahgE-GctUcLMcQFvl00xsXqpNJOix&index=7
//    Создание экземпляра класса связанного с файлом разметки (со всеми его въюхами)
        binding = ActivityLearmWordBinding.inflate(layoutInflater)
        setContentView(binding.root)  // получение корневого элемента этой разметки
//    Теперь обращаемся к любому элементу данного экзкмпляра класса по ID элемента из разметки
//        binding.tvQuestionWord.text = "Worlds from findViewById"
//        binding.tvQuestionWord.setTextColor(Color.BLUE)

//  Если элементов много, то используем оператор with  (единое обращение к binding)
        with(binding) {
            tvQuestionWord.text = "Worlds from findViewById"
            tvQuestionWord.setTextColor(Color.RED)
            imageButton.isVisible= false
        }


//        setContentView(R.layout.activity_learm_word)  // первоначальные проектные настройки






// Найти элемент по ID
// findViewById
//        val tvQuestionWord: TextView = findViewById(R.id.tvQuestionWord)
//        tvQuestionWord.text = "Worlds from ViewBinding"
//       // получение цвета из стандартной библиотеки
//        tvQuestionWord.setTextColor(Color.BLUE)
//        // получение цвета из HEX кодв
//        tvQuestionWord.setTextColor(Color.parseColor(("#FDD600")))
//        // получение цвета из собственных ресурсов
//        tvQuestionWord.setTextColor(ContextCompat.getColor(this, R.color.textVariantsColor2))


    }
}



// Найти элемент по ID
// Два подхода решения этой задачи:

// findViewById
// ViewBinding