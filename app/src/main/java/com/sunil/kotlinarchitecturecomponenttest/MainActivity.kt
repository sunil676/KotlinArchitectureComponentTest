package com.sunil.kotlinarchitecturecomponenttest

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.sunil.kotlinarchitecturecomponenttest.base.BaseLifecycleActivity
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.ui.FriendsAdapter
import com.sunil.kotlinarchitecturecomponenttest.ui.FriendsViewModel

class MainActivity : BaseLifecycleActivity<FriendsViewModel>() , SwipeRefreshLayout.OnRefreshListener {

    override val viewModelClass = FriendsViewModel::class.java

    private val rv by unsafeLazy { findViewById<RecyclerView>(R.id.rv) }

    private val vRefresh by unsafeLazy { findViewById<SwipeRefreshLayout>(R.id.lRefresh) }

    private val adapter = FriendsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.setHasFixedSize(true)
        rv.adapter = adapter
        vRefresh.setOnRefreshListener(this)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer<Boolean> {
            it?.let { vRefresh.isRefreshing = it }
        })
        viewModel.friendsLiveData.observe(this, Observer<List<Friends>> {
            it?.let { adapter.dataSource = it }
        })
        viewModel.throwableLiveData.observe(this, Observer<Throwable> {
            it?.let { Snackbar.make(rv, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
        })
    }

    override fun onRefresh() {
       // viewModel.setOrganization("yalantis")
    }
}
