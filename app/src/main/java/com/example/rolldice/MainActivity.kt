//here, as the name of the package, we have the applicationId the gradle has to identify this app uniquely
package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.rolldice.databinding.ActivityMainBinding


lateinit var rollButton: Button
lateinit var diceImageView: ImageView
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createBinding()
        giveDefaultViewValues()
        initListeners()
    }

    fun buttonListener(button: Button){
        button.setOnClickListener {
            //showTextWithToast("clicked!")
            rollDice()
        }
    }

    private fun rollDice() = diceImageView.setImageResource(getDrawableResource())

    fun showTextWithToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


    fun getRandomNumberInRange(from: Int, to: Int): Int = (from..to).random()


    fun getDrawableResource() = when (getRandomNumberInRange(from = 1, to = 6)) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    fun initListeners() = buttonListener(rollButton)

    fun createBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    fun giveDefaultViewValues(){
        rollButton = binding.rollButton
        rollButton.text = "Lets Roll"
        diceImageView = binding.diceImage
    }
}