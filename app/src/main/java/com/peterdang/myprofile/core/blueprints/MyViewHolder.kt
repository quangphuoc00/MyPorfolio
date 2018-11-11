package com.peterdang.myprofile.core.blueprints

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.peterdang.myprofile.BR


class MyViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: T?) {
        if (obj == null)
            return
        binding.setVariable(BR.row, obj)
        binding.executePendingBindings()
    }
}