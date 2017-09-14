package com.sunil.kotlinarchitecturecomponenttest.ui

import android.view.View
import android.widget.TextView
import com.sunil.kotlinarchitecturecomponenttest.R
import com.sunil.kotlinarchitecturecomponenttest.base.BaseAdapter
import com.sunil.kotlinarchitecturecomponenttest.base.BaseViewHolder
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends

/**
 * Created by sunil on 13-09-2017.
 */
class FriendsAdapter : BaseAdapter<Friends, FriendsAdapter.FriendsViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): FriendsViewHolder = FriendsViewHolder(view)

    class FriendsViewHolder(itemView: View?) : BaseViewHolder<Friends>(itemView) {

        val tvName by lazy { itemView?.findViewById<TextView?>(R.id.tvName) }
        val tvEmail by lazy { itemView?.findViewById<TextView?>(R.id.tvEmail) }

        override fun onBind(item: Friends) {
            tvName?.text = item.name
            tvEmail?.text = item.email
        }

    }

}