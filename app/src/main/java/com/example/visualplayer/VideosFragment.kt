package com.example.visualplayer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.visualplayer.databinding.ActivityVideosFragmentBinding

class VideosFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_videos_fragment, container, false)
        val binding = ActivityVideosFragmentBinding.bind(view)
        val tempList = ArrayList<String>()
        binding.VideoRV.setHasFixedSize(true)
        binding.VideoRV.setItemViewCacheSize(10)
        binding.VideoRV.layoutManager = LinearLayoutManager(requireContext())
        binding.VideoRV.adapter = VideoAdapter(requireContext(), MainActivity.videoList)
        binding.TotalVideos.text ="Total Videos: ${MainActivity.videoList.size}"
        return view
    }
}