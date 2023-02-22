package com.example.visualplayer

import android.app.DownloadManager.Request
import android.content.Context
import android.content.Intent
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.visualplayer.databinding.VideoViewBinding

class VideoAdapter(private val context: Context, private var videoList: ArrayList<Video>, private val isFolder: Boolean=false): RecyclerView.Adapter<VideoAdapter.MyHolder>() {
    class MyHolder(binding: VideoViewBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.videoName
        val folder = binding.folderName
        val duration = binding.duration
        val image = binding.videoImg
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(VideoViewBinding.inflate(LayoutInflater.from(context),parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = videoList[position].title
        holder.folder.text = videoList[position].folderName
        holder.duration.text = DateUtils.formatElapsedTime(videoList[position].duration/1000)
        Glide.with(context)
            .asBitmap()
            .load(videoList[position].artUri)
            .apply(RequestOptions().placeholder(R.drawable.loading).centerCrop())
            .into(holder.image)

        holder.root.setOnClickListener{
            when{
                isFolder -> {
                    sendIntenet(pos=position, ref = "FolderActivity")
                }
                MainActivity.search-> {
                    sendIntenet(pos=position, ref = "SearchedVideos")
                }
                else -> {
                    sendIntenet(position, ref= "AllVideos")
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    private fun sendIntenet(pos: Int, ref: String){
        PlayerActivity.position = pos
        val intent = Intent(context, PlayerActivity::class.java)
        intent.putExtra("class",ref)
        ContextCompat.startActivity(context, intent,null)
    }

    fun updateList(searchList: ArrayList<Video>){
        videoList = ArrayList()
        videoList.addAll(searchList)
        notifyDataSetChanged()
    }
}