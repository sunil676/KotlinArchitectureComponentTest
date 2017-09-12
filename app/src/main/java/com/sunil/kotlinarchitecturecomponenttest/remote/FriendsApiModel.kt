package com.sunil.kotlinarchitecturecomponenttest.remote

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

/**
 * Created by sunil on 12-09-2017.
 */
class FriendsApiModel {


    @SerializedName("user")
    @Expose
    var user: List<User>? = null

    class User {

        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("email")
        @Expose
        var email: String? = null

        constructor(id: String?, name: String?, email: String?) {
            this.id = id
            this.name = name
            this.email = email
        }
    }

    class ListDeserializer : ResponseDeserializable<List<FriendsApiModel>> {
        override fun deserialize(content: String) =
                Gson().fromJson<List<FriendsApiModel>>(content, object : TypeToken<List<FriendsApiModel>>() {}.type)
    }
}