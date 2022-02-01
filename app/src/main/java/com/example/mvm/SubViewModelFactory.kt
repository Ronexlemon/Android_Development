package com.example.mvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvm.Database.SubRepository

class SubViewModelFactory(private val repository: SubRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SubViewModel::class.java)){

        return SubViewModel(repository) as T}
        throw IllegalArgumentException("Unknown class")
    }


}