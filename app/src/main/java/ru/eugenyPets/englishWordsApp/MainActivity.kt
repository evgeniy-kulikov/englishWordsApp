package ru.eugenyPets.englishWordsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
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
        binding.btnContinue.setOnClickListener {
            markAnswerNeutral(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1,
                )

            markAnswerNeutral(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3,
            )
        }


        // корректный выбор
        binding.layoutAnswer3.setOnClickListener {
            markAnswerCorrect(
                binding.layoutAnswer3,
                binding.tvVariantNumber3,
                binding.tvVariantValue3,
            )
            showResultMessage(true)
        }

        // некорректный выбор
        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong(
                binding.layoutAnswer1,
                binding.tvVariantNumber1,
                binding.tvVariantValue1,
            )
            showResultMessage(false)
        }

    }

    // функция сброса ответа и перехода к следующиму выбору
    private fun markAnswerNeutral(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
        ) {

        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_container
            )

        // функция apply {} для переменной textView производит сразу несколько действий
        tvVariantValue.apply {
            background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_variants,
            )
            setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.textVariantsColor,
                )
            )
        }

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.textVariantsColor
                )
            )
        }


    // функция неправильного ответа
    private fun markAnswerWrong(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
//        фон всей ячейки
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )
//      фон номера ячейки
        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong
        )

//      фон цифры номера
        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

//      фон слова
        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )
    }


    // функция верного ответа
    private fun markAnswerCorrect(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {
        // фон всей ячейки
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )
        // фон номера ячейки
        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct
        )

        // фон номера
        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

        //  цвет текста слова
        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )
    }

// Действия с инфотабло при верном/неверном ответе
    private fun showResultMessage(isCorrect: Boolean) {
        val color: Int
        val messageText: String
        val resultIconResource: Int
        if (isCorrect) {
            color = ContextCompat.getColor(this, R.color.correctAnswerColor)
            resultIconResource = R.drawable.ic_correct
            messageText = "Correct!" // TODO get from string resources
        } else {
            color = ContextCompat.getColor(this, R.color.wrongAnswerColor)
            resultIconResource = R.drawable.ic_wrong
            messageText = "Incorrect!" // TODO get from string resources
        }

        with(binding) {
            btnSkip.isVisible = false
            layoutResult.isVisible = true
            btnContinue.setTextColor(color)
            layoutResult.setBackgroundColor(color)
            tvResultMessage.text = messageText
            ivResultIcon.setImageResource(resultIconResource)
        }
    }


}


