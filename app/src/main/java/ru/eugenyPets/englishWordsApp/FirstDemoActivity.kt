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

        with(binding) {
            btnOpenSecond.setOnClickListener {
                // объявляем Intent (намерение) откуда - куда
                val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java)
                startActivity(intent)  // запуск намерения
            }
        }
    }
}
