package com.example.customlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =  ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.trigger()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect {
                it.show { mes->
                    Snackbar.make(findViewById(R.id.activity_layout),mes,Snackbar.LENGTH_LONG).show()
                }
            }
        }



    }
}