package com.sunil.kotlinarchitecturecomponenttest

/**
 * Created by sunil on 13-09-2017.
 */
/**
 * A thread unsafe lazy function.
 * This function 'must' be called only on single thread.
 */
fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)