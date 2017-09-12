package com.sunil.kotlinarchitecturecomponenttest.db;

/**
 * Created by sunil on 12-09-2017.
 */

import android.arch.persistence.room.Database;

import com.sunil.kotlinarchitecturecomponenttest.remote.FriendsApiModel;

@Database(entities = arrayOf(FriendsApiModel::class), version = 1)
abstract class FriendsDatabase : RoomD {
}
