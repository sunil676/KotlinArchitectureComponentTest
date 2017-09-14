package com.sunil.kotlinarchitecturecomponenttest.remote

import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import io.reactivex.Single

/**
 * Created by sunil on 12-09-2017.
 */
interface ApiService {
    fun getFriends(): Single<List<FriendsApiModel>>
}