package com.example.mvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvm.Database.SubDataBase
import com.example.mvm.Database.SubRepository
import com.example.mvm.Database.SubScriberDAO
import com.example.mvm.SubViewModel
import com.example.mvm.SubViewModelFactory
import com.example.mvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var binding :ActivityMainBinding
    private lateinit var subscribermodelview : SubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao :SubScriberDAO = SubDataBase.getInstance(application).subDao
        val repo  = SubRepository(dao)
        val factory = SubViewModelFactory(repo)
        subscribermodelview = ViewModelProvider(this,factory).get(SubViewModel::class.java)

        binding.lifecycleOwner = this
        binding.myListView = subscribermodelview


   initRecycleView()

    }
    private fun initRecycleView(){
        //set the layout manager
        binding.recycleview.layoutManager= LinearLayoutManager(this)
        display()
    }
private fun display(){

    subscribermodelview.subscriber.observe(this, Observer {
     Log.i("my tag",it.toString())
        binding.recycleview.adapter = CustomAdapter(it)


    })
}
}