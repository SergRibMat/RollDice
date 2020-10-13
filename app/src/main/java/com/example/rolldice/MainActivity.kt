//here, as the name of the package, we have the applicationId the gradle has to identify this app uniquely
package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


lateinit var rollButton: Button
lateinit var diceImageView: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    fun initViews(){
        rollButton = findViewById(R.id.roll_button)
        rollButton.text = "Lets Roll"
        diceImageView = getDiceImageView()

    }

    fun initViewWithViewBinding(){

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


    fun getDiceImageView(): ImageView = findViewById(R.id.dice_image)

    fun getDrawableResource() = when (getRandomNumberInRange(from = 1, to = 6)) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    fun initListeners() = buttonListener(rollButton)
}