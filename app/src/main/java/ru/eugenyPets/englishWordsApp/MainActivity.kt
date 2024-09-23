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
        get() = _binding
            ?: throw IllegalStateException("binding for ActivityLearmWordBinding must not be null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLearmWordBinding.inflate(layoutInflater)
        setContentView(binding.root)  // получение корневого элемента этой разметки

//        Создаем экзкмпляр класса LearnWordsTrainer
        val trainer = LearnWordsTrainer()
        showNextQuestion(trainer)

        // Окрашиваем все поля в нейтральный цвет
        with(binding) {
            btnContinue.setOnClickListener {
                layoutResult.isVisible = false
                markAnswerNeutral(layoutAnswer1, tvVariantNumber1, tvVariantValue1)
                markAnswerNeutral(layoutAnswer2, tvVariantNumber2, tvVariantValue2)
                markAnswerNeutral(layoutAnswer3, tvVariantNumber3, tvVariantValue3)
                markAnswerNeutral(layoutAnswer4, tvVariantNumber4, tvVariantValue4)
                showNextQuestion(trainer)
            }

            // В случае отказа отвечать - показываем следующее слово для изучения
            btnSkip.setOnClickListener {
                showNextQuestion(trainer)
            }
        }

    }


    private fun showNextQuestion(trainer: LearnWordsTrainer) {
        val firstQuestion: Question? = trainer.getNextQuestion()
        with(binding) {
            if (firstQuestion == null || firstQuestion.variants.size < NUMBER_OF_ANSWERS) {
                tvQuestionWord.isVisible = false
                layoutVariants.isVisible = false
                btnSkip.text = "Complete"
            } else {
                btnSkip.isVisible = true
                tvQuestionWord.isVisible = true
                tvQuestionWord.text = firstQuestion.correctAnswer.original

                tvVariantValue1.text = firstQuestion.variants[0].translate
                tvVariantValue2.text = firstQuestion.variants[1].translate
                tvVariantValue3.text = firstQuestion.variants[2].translate
                tvVariantValue4.text = firstQuestion.variants[3].translate

                layoutAnswer1.setOnClickListener {
                    if (trainer.checkAnswer(0)) {
                        markAnswerCorrect(layoutAnswer1, tvVariantNumber1, tvVariantValue1)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong(layoutAnswer1, tvVariantNumber1, tvVariantValue1)
                        showResultMessage(false)
                    }
                }

                layoutAnswer2.setOnClickListener {
                    if (trainer.checkAnswer(1)) {
                        markAnswerCorrect(layoutAnswer2, tvVariantNumber2, tvVariantValue2)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong(layoutAnswer2, tvVariantNumber2, tvVariantValue2)
                        showResultMessage(false)
                    }
                }

                layoutAnswer3.setOnClickListener {
                    if (trainer.checkAnswer(2)) {
                        markAnswerCorrect(layoutAnswer3, tvVariantNumber3, tvVariantValue3)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong(layoutAnswer3, tvVariantNumber3, tvVariantValue3)
                        showResultMessage(false)
                    }
                }

                layoutAnswer4.setOnClickListener {
                    if (trainer.checkAnswer(3)) {
                        markAnswerCorrect(layoutAnswer4, tvVariantNumber4, tvVariantValue4)
                        showResultMessage(true)
                    } else {
                        markAnswerWrong(layoutAnswer4, tvVariantNumber4, tvVariantValue4)
                        showResultMessage(false)
                    }
                }
            }
        }
    }




    // функция apply {} для переменной textView производит сразу несколько действий
    private fun markAnswerNeutral(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView,
    ) {

        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers,
        )

        // функция сброса ответа и перехода к следующиму выбору
        tvVariantNumber.apply {
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

        tvVariantValue.setTextColor(
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





