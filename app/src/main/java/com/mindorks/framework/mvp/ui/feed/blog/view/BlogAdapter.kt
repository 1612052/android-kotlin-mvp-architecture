package com.mindorks.framework.mvp.ui.feed.blog.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.data.network.Blog
import kotlinx.android.synthetic.main.item_blog_list.view.*


/**
 * Created by jyotidubey on 14/01/18.
 */
class BlogAdapter(blogListItems: MutableList<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private val blogListItems: MutableList<Blog> = blogListItems

    override fun getItemCount(): Int {
        return this.blogListItems.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.clear()
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BlogViewHolder {
        return BlogViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_blog_list, parent, false))
    }

    internal fun addBlogsToList(blogs: List<Blog>) {
        this.blogListItems.addAll(blogs)
        notifyDataSetChanged()
    }

    inner class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int) {
            val blog = blogListItems[position]
            if (blog.coverImgUrl != null) {
                Glide.with(itemView.context)
                        .load(blog.coverImgUrl)
                        .asBitmap()
                        .centerCrop()
                        .into(itemView.coverImageView)
            }
            blog.title?.let { itemView.titleTextView.text = it }
            blog.author?.let { itemView.authorTextView.text = it }
            blog.date?.let { itemView.dateTextView.text = it }
            blog.description?.let { itemView.contentTextView.text = it }

            itemView.setOnClickListener {
                blog.blogUrl?.let {
                    try {
                        val intent = Intent()
                        intent.action = Intent.ACTION_VIEW
                        intent.addCategory(Intent.CATEGORY_BROWSABLE)
                        intent.data = Uri.parse(it)
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                    }
                }

            }
        }
    }
}