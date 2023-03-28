package com.example.firstbmi.viewmodel

import androidx.lifecycle.ViewModel

class mainActivityviewmodel(val height: Int,val weight: Int):ViewModel() {
    var height1:Int=0
    var weight1:Int=0

    init {
        height1=height
        weight1=weight
    }

    fun calculatebmi(){

        val heightInCM = height1.toFloat()
        val weightINKG = weight1.toFloat()

        val heightmeter = heightInCM / 100
        val heightmetersquare = heightmeter * heightmeter
        val bmi = weightINKG / heightmetersquare

        if (bmi < 18.5) {
            println("underweight")
        } else if (bmi >= 18.5 && bmi < 25) {
            println("healty")
        } else if (bmi >= 25 && bmi < 30) {
            println("overweight")
        } else {
            println("obese")
        }
    }
    }
