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
import android.view.ViewManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.firstbmi.databinding.ActivityMainBinding
import com.example.firstbmi.factory.mainActivityfactory
import com.example.firstbmi.viewmodel.mainActivityviewmodel
import java.util.logging.Handler
import android.os.Bundle as Bundle1


class MainActivity : AppCompatActivity(){


     lateinit var binding: ActivityMainBinding
     lateinit var viewmodel:mainActivityviewmodel
     lateinit var factory:mainActivityfactory





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewmodel=ViewModelProvider(this,factory)[mainActivityviewmodel::class.java]
        var hight_data=binding.height.text.toString()
       var weight_data =binding.weight.text.toString()
        factory=mainActivityfactory(hight_data.toInt(), weight_data.toInt())
        binding.myBMI=viewmodel


        binding.btn.setOnClickListener {
            viewmodel.calculatebmi()
        }





//        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_item,menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.developer -> {
//                val intent = Intent(this, about_developer_Activity::class.java)
//                startActivity(intent)
//                return true
//            }
//
//            R.id.BMI -> {
//
//                val intent=Intent(this, webviewActivity::class.java)
//                startActivity(intent)
//                return true
//
//            }
//
//            R.id.Exit -> {
//                finish()
//                System.exit(0)
//                Toast.makeText(this, "Exit BMI ", Toast.LENGTH_LONG).show()
//                return true
//            }
//
//
//            R.id.contect -> {
//                Toast.makeText(this, "contect us", Toast.LENGTH_LONG).show()
//                val intent = Intent(this,contect_Activity::class.java)
//                startActivity(intent)
//
//            }
//            R.id.ranking->{
//                val intent=Intent(this,rate_us::class.java)
//                startActivity(intent)
//            }
//
//        }
//        return true
//    }
//
//
//
//
//
//    private fun initialiseBinding() {
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//    }
//    private fun calculateBMI() {
//
//
//
//            val height1 = binding.height.text.toString()
//            val weight1 = binding.weight.text.toString()
//
//
//            val heightInCM = height1.toFloat()
//            val weightINKG = weight1.toFloat()
//
//            val heightmeter = heightInCM / 100
//            val heightmetersquare = heightmeter * heightmeter
//            val bmi = weightINKG / heightmetersquare
//
//            val bmidisply = bmi.toString()
//            binding.result.text = bmidisply
//
//            if (bmi < 18.5) {
//                binding.txtmsg.text = "underweight"
//            } else if (bmi >= 18.5 && bmi < 25) {
//                binding.txtmsg.text = "healty"
//            } else if (bmi >= 25 && bmi < 30) {
//                binding.txtmsg.text = "overweight"
//            } else {
//                binding.txtmsg.text = "obese"
//            }
//        }
//
//    override fun onBackPressed() {
//        val eBuilder= AlertDialog.Builder(this)
//        eBuilder.setTitle("Edit")
//        eBuilder.setMessage("do you want Edit ?")
//        eBuilder.setPositiveButton("Yes"){
//            Dialog,which->
//            finish()
//        }
//
//        eBuilder.setNegativeButton("No"){
//            Dialog,which->
//            Toast.makeText(this,"you want  edit press again this button",Toast.LENGTH_SHORT).show()
//        }
//        val createBuild=eBuilder.create()
    //        createBuild.show()
   }

}







