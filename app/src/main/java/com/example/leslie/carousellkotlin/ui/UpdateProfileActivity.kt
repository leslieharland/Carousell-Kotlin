package com.example.leslie.carousellkotlin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.leslie.MainThread
import com.example.leslie.ViewActivity
import com.example.leslie.carousellkotlin.AppStore
import com.example.leslie.carousellkotlin.profile.ProfileControllerView
import com.example.leslie.carousellkotlin.profile.ProfileViewCallback
import com.example.leslie.carousellkotlin.ui.layout.UpdateProfileLayout
import com.example.leslie.store.Profile
import java.lang.ref.WeakReference

class UpdateProfileActivity : ViewActivity<ProfileControllerView>(), ProfileViewCallback {
    override fun updateProfile(profile: Profile) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val mainLayout = UpdateProfileLayout()



    override fun setupControllerView() {
        val controllerView = ProfileControllerView(
                profileViewCallback = WeakReference(this),
                store = AppStore,
                mainThread = MainThread(WeakReference(this)))
        registerControllerViewForLifecycle(controllerView)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupControllerView()
        bindViews()
    }

    @SuppressLint("NewApi")
    private fun bindViews() {
        setContentView(mainLayout.bind(this))
    }


}