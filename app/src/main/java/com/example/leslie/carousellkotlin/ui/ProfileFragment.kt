package com.example.leslie.carousellkotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leslie.carousellkotlin.ui.layout.ProfileFragmentLayout

class ProfileFragment : Fragment() {

    private val profileFragmentLayout = ProfileFragmentLayout()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = profileFragmentLayout.bind(this)
       return rootView;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        profileFragmentLayout.unbind(this)
    }
}