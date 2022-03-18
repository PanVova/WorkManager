package com.panvova.conductor_example

import android.view.View
import androidx.work.Constraints
import androidx.work.NetworkType.CONNECTED
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.panvova.conductor_example.databinding.ControllerHomeBinding
import com.panvova.conductor_example.worker.MyWorker
import java.util.concurrent.TimeUnit.MINUTES
import java.util.concurrent.TimeUnit.SECONDS

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
    binding.workManager.setOnClickListener {
      val myWork = OneTimeWorkRequest.Builder(MyWorker::class.java)
        .setInitialDelay(3, SECONDS)
        .build()
      WorkManager.getInstance(applicationContext!!).enqueue(myWork)
    }
    // for this it's better to add condition if the proccess is already active
    val constraints = Constraints.Builder()
      .setRequiredNetworkType(CONNECTED)
      .build()
    val periodicWork = PeriodicWorkRequestBuilder<MyWorker>(30, MINUTES)
      .setConstraints(constraints)
      .build()
    WorkManager.getInstance(applicationContext!!).enqueue(periodicWork)
  }
}