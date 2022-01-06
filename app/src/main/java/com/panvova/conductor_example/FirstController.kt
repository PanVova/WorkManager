package com.panvova.conductor_example

import android.view.View
import com.bluelinelabs.conductor.RouterTransaction
import com.panvova.conductor_example.databinding.ControllerFirstBinding

class FirstController : BaseController<ControllerFirstBinding>(ControllerFirstBinding::inflate) {

    override fun onAttach(view: View) {
        super.onAttach(view)

        with(binding){
            button2.setOnClickListener {
                router.pushController(RouterTransaction.with(HomeController()))
            }
            button3.setOnClickListener {
                router.pushController(RouterTransaction.with(SecondController()))
            }
        }
    }
}