package com.mastery.driversconnect.base.model.service

import com.mastery.driversconnect.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseService {

    private var retrofitApi: Retrofit? = null

    init {
        retrofitApi = Retrofit.Builder()
            .baseUrl(BuildConfig.HOST_URL)
            .client(getClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun getClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val interceptor = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
        return client.build()
    }

    fun <Interface> createApiProxy(interfaceType: Class<Interface>): Interface {
        return retrofitApi!!.create(interfaceType)
    }

}