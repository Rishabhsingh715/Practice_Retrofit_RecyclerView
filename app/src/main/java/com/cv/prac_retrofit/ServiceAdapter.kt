package com.cv.prac_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user.view.*

class ServiceAdapter(val users: List<User>): RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {



    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {

        val view = ServiceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user, parent, false
            )
        )

        return view
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.itemView.tv1.text = users[position].login
        holder.itemView.tv2.text = users[position].id

          Glide.with(holder.itemView.context).load(users[position].avatar_url).into(holder.itemView.Iview)

    }

    override fun getItemCount(): Int {
       return users.size
    }
}