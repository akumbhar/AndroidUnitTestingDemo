package com.example.myunittestapplication.retrofit


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiBuilder {

    companion object {
        val gson: Gson = GsonBuilder().create()
    }

    private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .readTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(0, 5, TimeUnit.MINUTES))
            .addInterceptor(httpLoggingInterceptor)

    val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))


    inline fun <reified T> create(subDomain: String? = null, isAuthenticationRequired: Boolean = false): T {

        val baseUrl = "https://$subDomain.entrata.com/api/em/"
        retrofitBuilder.baseUrl(baseUrl)
        retrofitBuilder.client(httpClientBuilder.build())
        return retrofitBuilder.build().create(T::class.java)
    }

}