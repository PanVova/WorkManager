package com.panvova.conductor_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.panvova.conductor_example.databinding.ControllerHomeBinding

class HomeController : Controller() {

    private lateinit var binding: ControllerHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        binding = ControllerHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onAttach(view: View) {
        super.onAttach(view)

        binding.button.setOnClickListener {
            router.pushController(
                RouterTransaction.with(FirstController())
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler())
            )
        }
    }
}