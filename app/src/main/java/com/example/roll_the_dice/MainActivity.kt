//here, as the name of the package, we have the applicationId the gradle has to identify this app uniquely
package com.example.roll_the_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roll_the_dice.databinding.ActivityMainBinding


lateinit var rollButton: Button
lateinit var diceImageView: ImageView
private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createBinding()
        giveDefaultViewValues()
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        initListeners()

    }

    fun buttonListener(button: Button){
        button.setOnClickListener {
            viewModel.timer.start()
        }
    }

    private fun rollDice(diceNum: Int) = diceImageView.setImageResource(getDrawableResource(diceNum))

    fun showTextWithToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


    fun getDrawableResource(diceNum: Int) = when (diceNum) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }



    fun initListeners() {
        buttonListener(rollButton)

        viewModel.num.observe(this, Observer { diceNum ->
            rollDice(diceNum)
        })
    }

    fun createBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun giveDefaultViewValues(){
        rollButton = binding.rollButton
        rollButton.text = "Lets Roll"
        diceImageView = binding.diceImage
    }






}