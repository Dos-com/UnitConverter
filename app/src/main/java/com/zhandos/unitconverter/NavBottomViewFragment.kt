package com.zhandos.unitconverter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class NavBottomViewFragment : Fragment() {
    private lateinit var navigationView: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_bottom_nav_view_fragment, container, false)

        navigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav_view)


        val navHostFragment = childFragmentManager?.findFragmentById(R.id.nav_fragment)
        val navController = navHostFragment?.findNavController()



        navController?.let { navigationView.setupWithNavController(it) }



        return view
    }


    companion object{
        fun newInstance() :NavBottomViewFragment{
            return NavBottomViewFragment()
        }
    }
}