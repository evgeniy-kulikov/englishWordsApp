package ru.eugenyPets.englishWordsApp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import ru.eugenyPets.englishWordsApp.databinding.ActivityLearmWordBinding
import java.lang.IllegalStateException


class MainActivity : AppCompatActivity() {


    private var _binding: ActivityLearmWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("binding for ActivityLearmWordBinding must not be null")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLearmWordBinding.inflate(layoutInflater)
        setContentView(binding.root)  // получение корневого элемента этой разметки

// нейтральный выбор
// некорректный выбор


        // корректный выбор
        binding.layoutAnswer3.setOnClickListener {
//            it.isVisible = false
            markAnswerCorrect()
        }


    }

    private fun markAnswerCorrect() {
//      фон всей ячейки
        binding.layoutAnswer3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )
//      фон номера ячейки
        binding.tvVariantNumber3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct
        )

//      фон номера
        binding.tvVariantNumber3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

//      фон слова
        binding.tvVariantValue3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )


        
    }
}

