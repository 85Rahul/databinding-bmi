package com.example.firstbmi.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstbmi.viewmodel.mainActivityviewmodel

class mainActivityfactory(val height:Int,val weight:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(mainActivityviewmodel::class.java)){
            return mainActivityviewmodel(height, weight) as T
        }
        throw IllegalArgumentException("Unknown class")
    }





}