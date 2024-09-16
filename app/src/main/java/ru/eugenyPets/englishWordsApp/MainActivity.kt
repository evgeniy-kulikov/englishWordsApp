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





    }
}

