package com.panvova.conductor_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.panvova.conductor_example.databinding.ActivityMainBinding
import com.bluelinelabs.conductor.RouterTransaction




class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        router = Conductor.attachRouter(
            this,
            container = binding.controllerContainer,
            savedInstanceState
        )
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(HomeController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}