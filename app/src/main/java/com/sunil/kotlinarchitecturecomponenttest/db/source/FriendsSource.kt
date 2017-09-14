package com.sunil.kotlinarchitecturecomponenttest.db.source

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import io.reactivex.Flowable

/**
 * Created by sunil on 13-09-2017.
 */

@Dao
interface FriendsSource {

    @Query("SELECT * FROM friends")
    fun loadAllFriends(): Flowable<List<Friends>>

    @Query("SELECT * FROM friends WHERE friend_id = :friend_id")
    fun loadFriend(friend_id: String?): Flowable<List<Friends>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: MutableList<Friends>) : Unit

    @Query("SELECT COUNT(*) from friends")
    fun countFriends(): Int
}