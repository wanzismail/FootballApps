package com.wanztudio.gdk.matchschedule.util

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class SchedulerProvider {

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }


    fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }


    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }


    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }

    private fun getIOThreadScheduler() = Schedulers.io()

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()

}