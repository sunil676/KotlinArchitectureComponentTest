package com.sunil.kotlinarchitecturecomponenttest.ui

import android.arch.lifecycle.MediatorLiveData
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.db.source.FriendsLocalSource
import com.sunil.kotlinarchitecturecomponenttest.remote.FriendsApiModel
import io.reactivex.disposables.Disposable

/**
 * Created by sunil on 13-09-2017.
 */
class FriendsLiveData : MediatorLiveData<Pair<List<Friends>?, Throwable?>>() {

    private var disposable: Disposable? = null

        set(value) {
            value?.let {
                if ( FriendsLocalSource.getCount() > 0){
                    disposable = FriendsLocalSource
                            .getFriends()
                            .subscribe { data, error -> this@FriendsLiveData.value = Pair(data, error)}
                }else{
                    disposable = FriendsRepository
                            .getFriendsRemote()
                            .subscribe { data, error -> this@FriendsLiveData.value = Pair(convert(data), error)}
                }
            }
        }

    fun convert(list: List<FriendsApiModel>) : List<Friends>{
        var listFriends = ArrayList<Friends>()
        for (FriendsApiModel in list) {
            var listUsers = FriendsApiModel!!.user;
            listUsers?.let {
                for (users in it) {
                    listFriends.add(Friends(users.id, users.name, users.email))
                }
            }
        }
        return listFriends
    }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}
