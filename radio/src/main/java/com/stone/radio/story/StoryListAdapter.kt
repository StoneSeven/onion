package com.stone.radio.story

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stone.radio.R

/**
 *   created by stone
 *   on 2020/7/15
 */
class StoryListAdapter(private val dataList: List<Program>, private val context: Context) : RecyclerView.Adapter<StoryListAdapter.ViewHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_story, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size
    }

    override fun onBindViewHolder(holder: StoryListAdapter.ViewHolder, position: Int) {
        var program = dataList[position]
        Glide.with(context).load(program.coverUrl).into(holder.itemIv)
        holder.itemTv.text = program.name
        holder.itemTv.isSelected = true
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener {
                val position = holder.layoutPosition // 1
                mOnItemClickListener!!.onItemClick(holder.itemView, position) // 2
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTv = itemView.findViewById(R.id.itemStoryTv) as TextView
        var itemIv = itemView.findViewById(R.id.itemStoryIv) as ImageView
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

}