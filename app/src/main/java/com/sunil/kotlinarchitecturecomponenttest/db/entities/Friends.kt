package com.sunil.kotlinarchitecturecomponenttest.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by sunil on 12-09-2017.
 */
@Entity(tableName = "friends")
data class Friends (
        @PrimaryKey var friend_id: String?,
        var name: String?,
        var email: String?) {

    class ListDeserializer : ResponseDeserializable<List<Friends>> {
        override fun deserialize(content: String) =
                Gson().fromJson<List<Friends>>(content, object : TypeToken<List<Friends>>() {}.type)
    }

}