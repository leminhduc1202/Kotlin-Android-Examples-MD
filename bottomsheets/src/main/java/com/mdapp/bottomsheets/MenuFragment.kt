package com.mdapp.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mdapp.bottomsheets.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var fragmentbinding: FragmentMenuBinding? = null
    lateinit var pos: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        val string = bundle?.getString("key")
        when (string) {
            "0" -> {
                pos = "0"
            }
            "1" -> {
                pos = "1"
            }
            "2" -> {
                pos = "2"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)
        fragmentbinding = binding

        when (pos) {
            "0" -> {
                val imageList = listOf<Int>(
                    R.drawable.ic_local_gas_station_grey_700_24dp,
                    R.drawable.ic_local_grocery_store_grey_700_24dp,
                    R.drawable.ic_local_atm_grey_700_24dp,
                    R.drawable.ic_local_pharmacy_grey_700_24dp
                )
                val menuAdapter = MenuAdapter(requireActivity().applicationContext, imageList)
                val grid = GridLayoutManager(activity, 2)
                binding.recyclerView.layoutManager = grid
                binding.recyclerView.adapter = menuAdapter


            }
            "1" ->{

            }
            "2" ->{

            }
        }
        return binding.root
    }

}