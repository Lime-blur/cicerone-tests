package com.example.ciceronetest.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ciceronetest.App
import com.example.ciceronetest.R
import com.example.ciceronetest.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fcvMainFragmentsContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        getNavigatorHolder()?.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        getNavigatorHolder()?.removeNavigator()
    }
    
    override fun onBackPressed() {
        getRouter()?.exit()
    }

    fun getFirstFragmentText() = App.INSTANCE?.fragment1Text

    fun setFirstFragmentText(text: String) { App.INSTANCE?.fragment1Text = text }

    fun getSecondFragmentText() = App.INSTANCE?.fragment2Text

    fun setSecondFragmentText(text: String) { App.INSTANCE?.fragment2Text = text }

    fun getThirdFragmentText() = App.INSTANCE?.fragment3Text

    fun setThirdFragmentText(text: String) { App.INSTANCE?.fragment3Text = text }

    private fun getNavigatorHolder() = App.INSTANCE?.navigatorHolder

    private fun getRouter() = App.INSTANCE?.router

    private fun setupListeners() {
        findViewById<Button>(R.id.button).apply {
            setOnClickListener { getRouter()?.navigateTo(Screens.firstFragment()) }
        }
        findViewById<Button>(R.id.button2).apply {
            setOnClickListener { getRouter()?.navigateTo(Screens.secondFragment()) }
        }
        findViewById<Button>(R.id.button3).apply {
            setOnClickListener { getRouter()?.navigateTo(Screens.thirdFragment()) }
        }
    }
}