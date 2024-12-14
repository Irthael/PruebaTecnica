package com.dani.pruebaidealista.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.dani.pruebaidealista.R

class SplashFragment : Fragment() {

    companion object {
        private const val SPLASH_DURATION_IN_MILLISECONDS = 2000L
    }

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ):
            View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
        }, SPLASH_DURATION_IN_MILLISECONDS)
    }
}