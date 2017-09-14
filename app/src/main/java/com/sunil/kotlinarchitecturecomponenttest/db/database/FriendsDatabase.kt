package com.sunil.kotlinarchitecturecomponenttest.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.db.source.FriendsSource

/**
 * Created by sunil on 12-09-2017.
 */

@Database(entities = arrayOf(Friends::class), version = 1)
abstract class FriendsDatabase : RoomDatabase() {

    abstract fun friendsDao(): FriendsSource

    companion object {
        const val DATABASE_NAME = "friends-db"
    }

}
