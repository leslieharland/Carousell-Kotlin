package com.example.leslie.carousellkotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leslie.carousellkotlin.R

class ResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.activity_chat, container, false)
    }

    companion object {
        fun newInstance(position: Int): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            displayResults(position)
            return fragment
        }

        private fun displayResults(position: Int) {

        }
    }
}