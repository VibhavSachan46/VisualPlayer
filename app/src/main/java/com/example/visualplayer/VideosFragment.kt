package com.example.visualplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.visualplayer.databinding.FragmentVideosBinding

class VideosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_videos_fragment, container, false)
//        val binding = FragmentVideosBinding.bind(view)
//        val tempList = ArrayList<String>()
//        tempList.add("First Video")
//        tempList.add("Second Video")
//        tempList.add("Third Video")
//        tempList.add("Fourth Video")
//        tempList.add("Fifth Video")
//        binding.VideoRV.setHasFixedSize(true)
//        binding.VideoRV.setItemViewCacheSize(10)
//        binding.VideoRV.layoutManager = LinearLayoutManager(requireContext())
//        binding.VideoRV.adapter = VideoAdapter(requireContext(), tempList)
        return view
    }
}