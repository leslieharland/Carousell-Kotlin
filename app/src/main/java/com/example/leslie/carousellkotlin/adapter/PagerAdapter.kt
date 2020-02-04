package com.example.leslie.carousellkotlin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.leslie.store.Chat
import com.example.leslie.carousellkotlin.ui.*

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> GroupFragment()
            2 -> ActivityFragment()
            3-> ProfileFragment()
            else -> {
                return HomeFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Browse"
            1 -> "Groups"
            2 -> "Activity"
            3 -> "Profile"
            else -> {
                return "Browse"
            }
        }
    }
}

class ChatPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ResultFragment.newInstance(0)

            }
            1 ->     ResultFragment.newInstance(1)
            2 ->     ResultFragment.newInstance(2)
            else -> {
                return    ResultFragment.newInstance(3)
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "All"
            1 -> "Buying"
            2 -> "Selling"
            else -> {
                return "All"
            }
        }
    }
}