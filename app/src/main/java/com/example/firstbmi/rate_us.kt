package com.example.firstbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RatingBar
import android.widget.Toast
import com.example.firstbmi.databinding.ActivityRateUsBinding
import com.example.firstbmi.databinding.ActivityWebviewBinding

class rate_us : AppCompatActivity(), View.OnClickListener, RatingBar.OnRatingBarChangeListener {
    private lateinit var binding: ActivityRateUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRateUsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
        binding.ratingBar.setOnRatingBarChangeListener(this)






    }

    override fun onClick(p0: View?) {


    }

    override fun onRatingChanged(ratingbar: RatingBar?, rating: Float, fromuser: Boolean) {
        val total:String = "Total Stars:: " + ratingbar?.getNumStars()
        val  rating = "Rating :: " + ratingbar?.getRating();
        Toast.makeText(getApplicationContext(), total + "\n" + rating, Toast.LENGTH_LONG).show();




    }


}