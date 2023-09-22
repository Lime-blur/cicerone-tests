package com.example.ciceronetest

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class App : Application() {

    var fragment1Text = "I'm the FIRST!\n"
    var fragment2Text = "I'm the SECOND!\n"
    var fragment3Text = "I'm the THIRD!\n"

    private var cicerone: Cicerone<Router>? = null

    val navigatorHolder: NavigatorHolder?
        get() = cicerone?.getNavigatorHolder()

    val router: Router?
        get() = cicerone?.router

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        cicerone = Cicerone.create()
    }

    companion object {
        var INSTANCE: App? = null
    }
}