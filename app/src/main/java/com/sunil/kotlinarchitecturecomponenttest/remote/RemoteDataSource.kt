package com.sunil.kotlinarchitecturecomponenttest.remote

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.interceptors.loggingInterceptor
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_object
import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by sunil on 12-09-2017.
 */
object RemoteDataSource : ApiService {

    init {
        FuelManager.instance.basePath = "http://demo2974937.mockable.io/"
        FuelManager.instance.addRequestInterceptor(loggingInterceptor())
    }

    override fun getFriends(): Single<List<FriendsApiModel>> =
                    "getmyfriends"
                    .httpGet()
                    .rx_object(FriendsApiModel.ListDeserializer())
                    .map { it?.component1() ?: throw it?.component2() ?: throw Exception() }
                    .doOnSuccess {
                    }

}
