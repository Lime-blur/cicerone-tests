package com.example.ciceronetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.example.ciceronetest.R
import com.example.ciceronetest.activity.MainActivity

private const val imageUrl = "https://images.pexels.com/photos/762687/pexels-photo-762687.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"

class Fragment1: Fragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.layout_fragment_1, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImage()
    }

    override fun onStart() {
        setText("onStart")
        super.onStart()
    }

    override fun onPause() {
        setText("onPause")
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        setText("onResume")
    }

    override fun onStop() {
        super.onStop()
        setText("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setText("onDestroyView")
    }

    private fun setText(string: String) {
        val currentText = mainActivity()?.getFirstFragmentText()
        val newText = "$currentText\n$string"
        mainActivity()?.setFirstFragmentText(newText)
        root.findViewById<TextView>(R.id.textView)?.apply { text = newText }
    }

    private fun mainActivity() = activity as? MainActivity

    private fun setupImage() {
        root.findViewById<ImageView>(R.id.imageView).apply { load(imageUrl) }
    }
}