package sergio.ribera.roll_the_dice

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val ONE_SECOND = 1000L

class MainActivityViewModel: ViewModel() {

    var num = MutableLiveData<Int>()

    init {
        num.value = 1
    }

    fun getRandomNumberInRange(from: Int, to: Int): Int = (from..to).random()


    val timer = object : CountDownTimer(ONE_SECOND * 2, ONE_SECOND / 5) {

        override fun onTick(millisUntilFinished: Long) {
            assignNumberToNum()
        }

        override fun onFinish() {
            assignNumberToNum()
            cancel()
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun assignNumberToNum(){
        num.value = getRandomNumberInRange(1, 6)
    }
}