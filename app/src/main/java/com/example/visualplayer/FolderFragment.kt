package com.example.visualplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.visualplayer.databinding.ActivityFolderFragmentBinding
//import com.example.visualplayer.databinding.ActivityVideosFragmentBinding

class FoldersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_folder_fragment, container, false)
        val tempList = ArrayList<String>()
        tempList.add("First")
        tempList.add("First")
        tempList.add("First")
        tempList.add("First")

        val binding = ActivityFolderFragmentBinding.bind(view)
        binding.FolderRV.setHasFixedSize(true)
        binding.FolderRV.setItemViewCacheSize(10)
        binding.FolderRV.layoutManager = LinearLayoutManager(requireContext())
        binding.FolderRV.adapter = FoldersAdapter(requireContext(), tempList)
        return view
    }
}