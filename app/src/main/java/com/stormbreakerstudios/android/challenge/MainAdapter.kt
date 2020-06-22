package com.stormbreakerstudios.android.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_of_the_day_vh.view.*
import kotlinx.android.synthetic.main.article_showcase_vh.view.*
import kotlinx.android.synthetic.main.image_vh.view.*

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = listOf(0, 1, 2, 3)
    val itemTypes = listOf(99, 199, 299, 399)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            99 -> ArticleOfTheDayViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_of_the_day_vh, parent, false)
            )
            199 -> FeaturedArticles(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_showcase_vh, parent, false)
            )
            299 -> TopicsArticles(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_showcase_vh, parent, false)
            )
            else -> TimeToReadArticles(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_showcase_vh, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ArticleOfTheDayViewHolder) {
            holder.bind()
        }
        if (holder is FeaturedArticles) {
            holder.itemView.rv_article_showcase.adapter = ShowcaseAdapter(
                listOf(
                    ShowcaseFakeData("Lotus Focus", R.drawable.lotus),
                    ShowcaseFakeData("Peaceful thoughts: How to", R.drawable.peaceful_thoughts),
                    ShowcaseFakeData("Sand", R.drawable.sand)
                )
            )
            holder.itemView.tv_title.text = "Featured Articles"
        }
        if (holder is TopicsArticles) {
            holder.itemView.rv_article_showcase.adapter =
                ShowcaseAdapter(
                    listOf(
                        ShowcaseFakeData("Peace", R.drawable.peace),
                        ShowcaseFakeData("Balance", R.drawable.stonestack),
                        ShowcaseFakeData("Night", R.drawable.night)
                    )
                )
            holder.itemView.tv_title.text = "Topics"
        }
        if (holder is TimeToReadArticles) {
            holder.itemView.rv_article_showcase.adapter =
                ShowcaseAdapter(
                    listOf(
                        ShowcaseFakeData("5 min", R.drawable.couch),
                        ShowcaseFakeData("10 min", R.drawable.blonde),
                        ShowcaseFakeData("20 min", R.drawable.flower)
                    )
                )
            holder.itemView.tv_title.text = "Time to Read"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemTypes[position]
    }

    class ShowcaseFakeData(val text: String, val img: Int)
    class ArticleOfTheDayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       fun bind() {
           Picasso.get()
               .load(R.drawable.article_of_day)
               .fit()
               .into(itemView.iv_article_of_the_day)
       }
    }
    class FeaturedArticles(itemView: View) : RecyclerView.ViewHolder(itemView)
    class TopicsArticles(itemView: View) : RecyclerView.ViewHolder(itemView)
    class TimeToReadArticles(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ShowcaseAdapter(private val showcaseFakeData: List<ShowcaseFakeData>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val items = listOf(0, 1, 3)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return ArticleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_vh, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (position) {
                0 -> {
                    Picasso.get().load(showcaseFakeData[position].img).fit().into(holder.itemView.iv_article)
                    holder.itemView.tv_article_title.text = showcaseFakeData[position].text
                }
                1 -> {
                    Picasso.get().load(showcaseFakeData[position].img).fit().into(holder.itemView.iv_article)
                    holder.itemView.tv_article_title.text = showcaseFakeData[position].text
                }
                2 -> {
                    Picasso.get().load(showcaseFakeData[position].img).fit().into(holder.itemView.iv_article)
                    holder.itemView.tv_article_title.text = showcaseFakeData[position].text
                }
            }
        }

        class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}