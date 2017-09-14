package com.sunil.kotlinarchitecturecomponenttest.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends

/**
 * Created by sunil on 13-09-2017.
 */
open class FriendsViewModel (application: Application?) : AndroidViewModel(application) {

    private val organizationLiveData = MutableLiveData<String>()

    val resultLiveData = FriendsLiveData().apply {
        this.addSource(organizationLiveData) { it?.let {  } }
    }

    val isLoadingLiveData = MediatorLiveData<Boolean>().apply {
        this.addSource(resultLiveData) { this.value = false }
    }

    val throwableLiveData = MediatorLiveData<Throwable>().apply {
        this.addSource(resultLiveData) { it?.second?.let { this.value = it } }
    }

    val friendsLiveData = MediatorLiveData<List<Friends>>().apply {
        this.addSource(resultLiveData) { it?.first?.let { this.value = it } }
    }

}