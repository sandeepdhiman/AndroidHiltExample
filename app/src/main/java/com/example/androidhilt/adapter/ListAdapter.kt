package com.example.androidhilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhilt.R
import com.example.androidhilt.model.Post
import kotlinx.android.synthetic.main.item_layout.view.*
class ListAdapter (  private val list:MutableList<Post>):
    RecyclerView.Adapter<ListAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
         itemView.textViewUserId.text= post.id.toString()
            itemView.textViewTitle.text=post.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount()=list.size
    fun addData(mlist: List<Post>) {
        list.addAll(mlist)
    }
}