package com.sunil.kotlinarchitecturecomponenttest.db.source

import com.sunil.kotlinarchitecturecomponenttest.db.database.DatabaseCreator
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.remote.FriendsApiModel
import io.reactivex.Single

/**
 * Created by sunil on 13-09-2017.
 */
object FriendsLocalSource : FriendsDataSource {
    override fun getCount(): Int {
        return friendsDao.countFriends()
    }

    override fun getFriendsRemote(): Single<List<FriendsApiModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val friendsDao = DatabaseCreator.database.friendsDao()

    override fun getFriends(): Single<List<Friends>> {
        return friendsDao.loadAllFriends()
                .firstOrError()
                .doOnSuccess {
                    if (it.isEmpty()) throw Exception()
                }
    }

    override fun saveFriends(list: List<Friends>) {
        friendsDao.insertAll(list.toMutableList())
    }
}