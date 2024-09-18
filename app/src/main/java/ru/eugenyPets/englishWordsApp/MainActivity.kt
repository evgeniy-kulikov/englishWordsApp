package ru.eugenyPets.englishWordsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            markAnswerNeutral()
        }


        // корректный выбор
        binding.layoutAnswer3.setOnClickListener {
//            it.isVisible = false
            markAnswerCorrect()
        }

        // некорректный выбор
        binding.layoutAnswer1.setOnClickListener {
            markAnswerWrong()
        }

    }

    // функция сброса ответа и перехода к следующиму выбору
    private fun markAnswerNeutral() {
        with(binding) {
            for (layout in listOf(layoutAnswer1, layoutAnswer3)) {
                layout.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_container
                )
            }

            for (textView in listOf(tvVariantValue1, tvVariantValue3)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.textVariantsColor
                    )
                )
            }

            // функция apply {} для переменной textView производит сразу несколько действий
            for (textView in listOf(tvVariantNumber1, tvVariantNumber3)) {
                textView.apply {
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
            }

            layoutResult.isVisible = false
            btnSkip.isVisible = true

        }
    }


    // функция неправильного ответа
    private fun markAnswerWrong() {
//        фон всей ячейки
        binding.layoutAnswer1.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )
//      фон номера ячейки
        binding.tvVariantNumber1.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong
        )

//      фон номера
        binding.tvVariantNumber1.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )

//      фон слова
        binding.tvVariantValue1.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )

        //      Button Continue
        binding.btnSkip.isVisible = false

        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.ic_wrong
            )
        )

        binding.tvResultMessage.text = resources.getString(R.string.title_wrong)

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor
            )
        )

//      включаем видимость после всех действий (для исключения мерцаний элементов на экране)
        binding.layoutResult.isVisible = true

    }



    // функция верного ответа
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

        //      Button Continue
        binding.btnSkip.isVisible = false

        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.ic_correct
            )
        )

        binding.tvResultMessage.text = resources.getString(R.string.title_correct)

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )

//      включаем видимость после всех действий (для исключения мерцаний элементов на экране)
        binding.layoutResult.isVisible = true

    }
}


