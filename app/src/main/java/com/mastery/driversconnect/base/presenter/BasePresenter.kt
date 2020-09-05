package com.mastery.driversconnect.base.presenter

import com.mastery.driversconnect.base.view.IBaseView
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException

open class BasePresenter<View : IBaseView> : IBasePresenter<View> {

    var view: View? = null

    override fun attachView(view: View) {
        this.view = view
    }

    fun <T> subscribe(
        flowable: Flowable<T>,
        onSuccess: (t: T) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        view?.onDataFetchStarted()
        flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({ response ->
            view?.onSuccess()
            onSuccess(response)
        }, { t ->

            if (t is UnknownHostException) {
                view?.onConnectionError()
            } else {
                view?.onError(t)
                print(t)
            }
            onError(t)
        })
    }

    override fun detachView() {
        view = null
    }

}