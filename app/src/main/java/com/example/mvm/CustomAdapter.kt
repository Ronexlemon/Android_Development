package com.example.mvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvm.Database.Subscriber
import com.example.mvm.databinding.CustomViewBinding

class CustomAdapter(private val nameLists: List<Subscriber>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val binding : CustomViewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.custom_view,parent,false)

    return MyViewHolder(binding) }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
   holder.bind(nameLists[position])
    }

    override fun getItemCount(): Int {
return nameLists.size
    }
}
class MyViewHolder(val binding:CustomViewBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber){
        binding.custname.text=subscriber.name
        binding.custtittle.text=subscriber.tittle
    }
}