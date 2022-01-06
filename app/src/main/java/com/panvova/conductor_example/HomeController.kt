package com.panvova.conductor_example

import android.view.View
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.panvova.conductor_example.databinding.ControllerHomeBinding

class HomeController : BaseController<ControllerHomeBinding>(ControllerHomeBinding::inflate) {

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