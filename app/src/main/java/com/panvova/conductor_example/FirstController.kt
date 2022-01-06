package com.panvova.conductor_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.panvova.conductor_example.databinding.ControllerFirstBinding

class FirstController : Controller() {
    private lateinit var binding: ControllerFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        binding = ControllerFirstBinding.inflate(inflater)
        return binding.root
    }
}