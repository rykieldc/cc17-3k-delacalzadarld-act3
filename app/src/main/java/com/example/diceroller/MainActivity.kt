package com.example.diceroller

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rollResult: TextView
    private lateinit var resultImages : ImageView
    private lateinit var rollButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rollResult = findViewById(R.id.roll_text)
        resultImages = findViewById(R.id.dice_img)
        rollButton = findViewById(R.id.roll_button)

        rollButton.setOnClickListener{
            val animation : Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.animation)
            resultImages.startAnimation(animation)

            rollDice()
        }
    }

    private fun rollDice(){
        val randomInt = (1..6).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val resultNumber = randomInt.toString()
        resultImages.setImageResource(drawableResource)
        rollResult.text = getString(R.string.dice_roll, resultNumber)

    }

}