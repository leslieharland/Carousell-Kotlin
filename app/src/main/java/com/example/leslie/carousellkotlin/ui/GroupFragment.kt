package com.example.leslie.carousellkotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leslie.carousellkotlin.R

class GroupFragment : Fragment() {

    internal var recycView: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.group_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
       // RecyclerViewExt.addItemClickListener(recycView, object : AdapterView.OnItemClickListener {
            //fun onItemClick(viewHolder: RecyclerView.ViewHolder, position: Int) {
              /*  if (detailContainer != null) {
                    val arguments = Bundle()
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, (viewHolder as SimpleItemRecyclerViewAdapter.ViewHolder).mItem.id)
                    val fragment = ItemDetailFragment()
                    fragment.setArguments(arguments)
                    activity.fragmentManager.beginTransaction().replace(R.id.item_detail_container, fragment).commit()
                } else {*/
                  /*  intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, (viewHolder as SimpleItemRecyclerViewAdapter.ViewHolder).mItem.id)
                    startActivity(intent)*/
                }



}