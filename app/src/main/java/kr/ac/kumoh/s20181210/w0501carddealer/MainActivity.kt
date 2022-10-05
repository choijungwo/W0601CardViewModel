package kr.ac.kumoh.s20181210.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20181210.w0501carddealer.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //binding.card1.setImageResource(R.drawable.c_10_of_clubs)
        val c = Random.nextInt(52)
        Log.i("Test","$c : ${getCardName(c)}")

        val res = resources.getIdentifier(
            getCardName(c),
            "drawable",
            packageName
        )

        binding.card1.setImageResource(res)
    }
}

private fun getCardName(c: Int) : String{
    val shape = when(c/13) {
        0 -> "spades"
        1 -> "diamonds"
        2 -> "hearts"
        3 -> "clubs"
        else -> "error"
    }

    val number = when (c % 13) {
        0 -> "ace"
        in 1..9 -> (c % 13 +1).toString()
        10 -> "jack"
        11 -> "queen"
        12 -> "king"
        else -> "error"
    }
    return "c_${number}_of_${shape}"
}