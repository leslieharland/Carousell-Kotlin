package com.example.leslie.carousellkotlin.profile

import com.example.leslie.carousellkotlin.ControllerView
import com.example.leslie.store.*
import java.lang.ref.WeakReference

class ProfileControllerView(
        val profileViewCallback: WeakReference<ProfileViewCallback>,
        store: Store,
        mainThread: ThreadExecutor? = null)
    : ControllerView(store, mainThread) {

    fun fetchDetails(title: String) =
            store.dispatch(ReadAction.FetchItemsAction(title))

    fun updateDetails(userId: Long) =
            store.dispatch(ReadAction.FetchLikedItemsAction(userId))

    fun backScreen(item: Listing) =
            store.dispatch(NavigationAction.EditItemScreenAction(item))


    override fun handleState(state: State) {
        when (state.navigation) {
            Navigation.EDIT_ITEM -> profileViewCallback.get()?.updateProfile(state.editItemScreen.currentItem as Profile)
        }
    }
}