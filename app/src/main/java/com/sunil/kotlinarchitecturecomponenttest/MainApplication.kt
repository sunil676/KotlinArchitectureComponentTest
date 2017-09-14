package com.sunil.kotlinarchitecturecomponenttest

import android.app.Application
import com.sunil.kotlinarchitecturecomponenttest.db.database.DatabaseCreator

/**
 * Created by sunil on 12-09-2017.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseCreator.createDb(this)
    }
}