package com.sunil.kotlinarchitecturecomponenttest.db.source

import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.remote.FriendsApiModel
import io.reactivex.Single

/**
 * Created by sunil on 13-09-2017.
 */
interface FriendsDataSource {

    fun getFriends(): Single<List<Friends>>

    fun getFriendsRemote(): Single<List<FriendsApiModel>>

    fun saveFriends(list: List<Friends>) : Unit = Unit

    fun getCount(): Int
}