package com.example.mvm

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvm.Database.SubRepository
import com.example.mvm.Database.Subscriber
import kotlinx.coroutines.launch

class SubViewModel(private val repository: SubRepository) :ViewModel(),Observable{
    val subscriber = repository.sub
 @Bindable
    val username = MutableLiveData<String>()
    @Bindable
    val tittle = MutableLiveData<String>()
     fun saveOrUpdate(){
        val name:String = username.value!!
        val tittle:String = tittle.value!!
        insert(Subscriber(0,name,tittle,))
         Log.i("my","added user")

    }
     fun deleteOrClearAll(){
        delete()
         Log.i("my","delete user")
    }

     fun insert(subscriber: Subscriber){
        viewModelScope.launch {
            repository.insertSub(subscriber)
        }
    }
     fun update(subscriber: Subscriber){
        viewModelScope.launch {
            repository.updateUser(subscriber)
        }
    }
      fun delete(){
        viewModelScope.launch {
            repository.deleteSub()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}