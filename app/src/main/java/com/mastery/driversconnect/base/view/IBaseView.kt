package com.mastery.driversconnect.base.view

interface IBaseView {

    fun onDataFetchStarted()
    fun onSuccess()
    fun onError(throwable: Throwable)
    fun onConnectionError()
}