package com.stormbreakerstudios.android.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = listOf(0, 1, 2, 3)
    val itemTypes = listOf(99, 199, 299, 399)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            99 -> ArticleOfTheDayViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_of_the_day_vh, parent, false)
            )
            else -> EmptyViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return itemTypes[position]
    }

    class ArticleOfTheDayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}