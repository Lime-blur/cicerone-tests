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

private const val imageUrl = "https://images.pexels.com/photos/211485/pexels-photo-211485.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"

class Fragment2: Fragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.layout_fragment_2, container, false)
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
        val currentText = mainActivity()?.getSecondFragmentText()
        val newText = "$currentText\n$string"
        mainActivity()?.setSecondFragmentText(newText)
        root.findViewById<TextView>(R.id.textView2)?.apply { text = newText }
    }

    private fun mainActivity() = activity as? MainActivity

    private fun setupImage() {
        root.findViewById<ImageView>(R.id.imageView2).apply { load(imageUrl) }
    }
}