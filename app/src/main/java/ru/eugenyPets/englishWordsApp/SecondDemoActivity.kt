package ru.eugenyPets.englishWordsApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.eugenyPets.englishWordsApp.databinding.ActivitySecondDemoBinding

class SecondDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // открытие другой Activity без передачи данных
        with(binding) {
            btnOpenFirst.setOnClickListener {
                // объявляем Intent (намерение) откуда - куда
                val intent = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
                startActivity(intent)  // запуск намерения
            }
            // с передачей данных
            val text = intent.getStringExtra("EXTRA_KEY_ANY_TEXT")
            val number = intent.getIntExtra("EXTRA_KEY_ANY_NUMBER", 0)

            tvText.text = text
            tvNumber.text = number.toString()
        }
    }
}
