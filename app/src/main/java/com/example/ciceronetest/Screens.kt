package com.example.ciceronetest

import com.example.ciceronetest.fragment.Fragment1
import com.example.ciceronetest.fragment.Fragment2
import com.example.ciceronetest.fragment.Fragment3
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun firstFragment() = FragmentScreen { Fragment1() }
    fun secondFragment() = FragmentScreen { Fragment2() }
    fun thirdFragment() = FragmentScreen { Fragment3() }
}