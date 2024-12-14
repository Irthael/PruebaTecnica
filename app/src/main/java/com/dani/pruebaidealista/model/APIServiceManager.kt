package com.dani.pruebaidealista.model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.http2.ConnectionShutdownException
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class APIServiceManager(baseUrl: String) {

    val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(
            MyInterceptor()
        ).build()
    }

    val service: APIService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().run {
            create(APIService::class.java)
        }
}

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response  {
        try {
            return chain.proceed(chain.request())
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is SocketTimeoutException -> "Timeout - Please check your internet connection"
                is UnknownHostException -> "Unable to make a connection. Please check your internet"
                is ConnectionShutdownException -> "Connection shutdown. Please check your internet"
                is IOException -> "Server is unreachable, please try again later."
                else -> e.message.orEmpty()
            }
            throw IOException(errorMessage)
        }
    }
}
