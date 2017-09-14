package com.sunil.kotlinarchitecturecomponenttest.ui

import com.sunil.kotlinarchitecturecomponenttest.db.entities.Friends
import com.sunil.kotlinarchitecturecomponenttest.db.source.FriendsDataSource
import com.sunil.kotlinarchitecturecomponenttest.db.source.FriendsLocalSource
import com.sunil.kotlinarchitecturecomponenttest.remote.FriendsApiModel
import com.sunil.kotlinarchitecturecomponenttest.remote.RemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.internal.disposables.DisposableHelper.isDisposed
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe



/**
 * Created by sunil on 13-09-2017.
 */
object FriendsRepository : FriendsDataSource {
    override fun getCount(): Int {
       return FriendsLocalSource.getCount();
    }

    override fun getFriendsRemote(): Single<List<FriendsApiModel>> {
       return RemoteDataSource.getFriends()
                .doOnSuccess { saveFriendsIntoDb(it) }
    }

    override fun getFriends(): Single<List<Friends>> =
            FriendsLocalSource
                .getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }



/*private fun getObservable(): Observable<List<ApiUser>> {
    return Observable.create<List<ApiUser>> { e ->
        if (!e.isDisposed) {
            e.onNext(Utils.getApiUserList())
            e.onComplete()
        }
    }
}*/


    fun saveFriendsIntoDb(list: List<FriendsApiModel>){
        var listFriends = ArrayList<Friends>()
        for (FriendsApiModel in list) {
            var listUsers = FriendsApiModel!!.user;
            listUsers?.let {
                for (users in it) {
                    listFriends.add(Friends(users.id, users.name, users.email))
                }
            }
           }
         FriendsLocalSource.saveFriends(listFriends)
        }

 /*   override fun getRepositories(organization: String): Single<List<Repo>>
            = ReposLocalDataSource
            .getRepositories(organization)
            .onErrorResumeNext {
                ReposRemoteDataSource.getRepositories(organization)
                        .doOnSuccess { ReposLocalDataSource.saveRepositories(it) }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}*/