package com.example.visualplayer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.visualplayer.databinding.ActivityVideosFragmentBinding

class VideosFragment : Fragment() {

    private lateinit var adapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_videos_fragment, container, false)
        val binding = ActivityVideosFragmentBinding.bind(view)
        val tempList = ArrayList<String>()
        binding.VideoRV.setHasFixedSize(true)
        binding.VideoRV.setItemViewCacheSize(10)
        binding.VideoRV.layoutManager = LinearLayoutManager(requireContext())
        adapter = VideoAdapter(requireContext(), MainActivity.videoList)
        binding.VideoRV.adapter = adapter
        binding.VideoRV.adapter = VideoAdapter(requireContext(), MainActivity.videoList)
        binding.TotalVideos.text ="Total Videos: ${MainActivity.videoList.size}"
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_view, menu)
        val searchView = menu.findItem(R.id.searchView)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean=true

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null){
                    MainActivity.searchList = ArrayList()
                    for(video in MainActivity.videoList){
                        if(video.title.lowercase().contains(newText.lowercase()))
                            MainActivity.searchList.add(video)
                    }
                    MainActivity.search = true
                    adapter.updateList(searchList = MainActivity.searchList)
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }
}