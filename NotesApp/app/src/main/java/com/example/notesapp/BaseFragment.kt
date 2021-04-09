package com.example.notesapp

import android.os.Bundle
import kotlinx.coroutines.*
import androidx.fragment.app.Fragment
import kotlin.coroutines.CoroutineContext


abstract class BaseFragment : Fragment(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }



}