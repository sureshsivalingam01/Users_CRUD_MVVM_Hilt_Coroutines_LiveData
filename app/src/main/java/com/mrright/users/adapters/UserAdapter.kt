package com.mrright.users.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrright.users.databinding.RecyclerViewUserBinding
import com.mrright.users.models.User

class UserAdapter(private val userList: List<User>, val onUserClick: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserVH>() {


    inner class UserVH(val binding: RecyclerViewUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onUserClick.invoke(userList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewUserBinding.inflate(layoutInflater, parent, false)
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.binding.tvName.text = userList[position].name
        holder.binding.tvAge.text = userList[position].age.toString()

    }

    override fun getItemCount() = userList.size
}