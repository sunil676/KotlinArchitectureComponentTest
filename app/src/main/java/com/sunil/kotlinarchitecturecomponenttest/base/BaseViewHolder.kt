package com.sunil.kotlinarchitecturecomponenttest.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by sunil on 13-09-2017.
 */
abstract class BaseViewHolder<D>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: D)

}