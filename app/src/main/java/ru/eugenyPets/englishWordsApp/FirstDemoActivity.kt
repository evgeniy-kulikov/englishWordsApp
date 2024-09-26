package ru.eugenyPets.englishWordsApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.eugenyPets.englishWordsApp.databinding.ActivityFitstDemoBinding

class FirstDemoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFitstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFitstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // открытие другой Activity без передачи данных
//        with(binding) {
//            btnOpenSecond.setOnClickListener {
//                // объявляем Intent (намерение) откуда - куда
//                val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java)
//                startActivity(intent)  // запуск намерения
//            }
//        }

        // открытие другой Activity с передачей данных
        binding.btnOpenSecond.setOnClickListener {
            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java)
            intent.putExtra("EXTRA_KEY_ANY_TEXT", "Any User Text")
            intent.putExtra("EXTRA_KEY_ANY_NUMBER", 2024)
            startActivity(intent)
        }

    }
}
