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

        with(binding) {
            btnOpenFirst.setOnClickListener {
                // объявляем Intent (намерение) откуда - куда
                val intent = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
                startActivity(intent)  // запуск намерения
            }
        }
    }
}
