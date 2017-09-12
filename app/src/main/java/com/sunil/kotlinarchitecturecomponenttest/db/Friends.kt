package com.sunil.kotlinarchitecturecomponenttest.db

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
        @PrimaryKey var id: Long?,
        var name: String?,
        var full_name: String?,
        var description: String?,
        var organization: String?) {

    class ListDeserializer : ResponseDeserializable<List<Repo>> {
        override fun deserialize(content: String) =
                Gson().fromJson<List<Repo>>(content, object : TypeToken<List<Repo>>() {}.type)
    }

}