package com.example.firstbmi

import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.telephony.SignalThresholdInfo
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firstbmi.databinding.ActivityMainBinding
import java.util.logging.Handler
import android.os.Bundle as Bundle1


class MainActivity : AppCompatActivity(){


    private lateinit var binding: ActivityMainBinding





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contect)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)












        initialiseBinding()
        binding.btn.setOnClickListener {
            calculateBMI()
        }










    }








    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.developer -> {
                val intent = Intent(this, about_developer_Activity::class.java)
                startActivity(intent)
                return true
            }

            R.id.BMI -> {

               val progress= ProgressDialog(this)
                    progress.setCancelable(false)
                    progress.setTitle(resources.getString(R.string.app_name))
                    progress.setMessage("please wait")
                    progress.setProgressStyle(ProgressDialog.STYLE_SPINNER)


                progress.show()

                val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/healthyweight/assessing/bmi/index.html"))
                startActivity(intent)
                return true

            }

            R.id.Exit -> {
                finish()
                System.exit(0)
                Toast.makeText(this, "Exit BMI ", Toast.LENGTH_LONG).show()
                return true
            }


            R.id.contect -> {
                Toast.makeText(this, "contect us", Toast.LENGTH_LONG).show()
                val intent = Intent(this,contect_Activity::class.java)
                startActivity(intent)

            }

        }
        return true
    }





    private fun initialiseBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun calculateBMI() {



            val height1 = binding.height.text.toString()
            val weight1 = binding.weight.text.toString()


            val heightInCM = height1.toFloat()
            val weightINKG = weight1.toFloat()

            val heightmeter = heightInCM / 100
            val heightmetersquare = heightmeter * heightmeter
            val bmi = weightINKG / heightmetersquare

            val bmidisply = bmi.toString()
            binding.result.text = bmidisply

            if (bmi < 18.5) {
                binding.txtmsg.text = "underweight"
            } else if (bmi >= 18.5 && bmi < 25) {
                binding.txtmsg.text = "healty"
            } else if (bmi >= 25 && bmi < 30) {
                binding.txtmsg.text = "overweight"
            } else {
                binding.txtmsg.text = "obese"
            }
        }

    override fun onBackPressed() {
        val eBuilder= AlertDialog.Builder(this)
        eBuilder.setTitle("Edit")
        eBuilder.setMessage("do you want Edit ?")
        eBuilder.setPositiveButton("Yes"){
            Dialog,which->
            finish()
        }

        eBuilder.setNegativeButton("No"){
            Dialog,which->
            Toast.makeText(this,"you want  edit press again this button",Toast.LENGTH_SHORT).show()
        }
        val createBuild=eBuilder.create()
        createBuild.show()
    }


}







