package com.example.myunittestapplication.di

import android.content.Context
import android.content.SharedPreferences
import com.example.myunittestapplication.MyApplication
import com.example.myunittestapplication.retrofit.ApiBuilder
import com.example.myunittestapplication.retrofit.ApiRequests
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideAPI(subDomain: String) = ApiBuilder().create<ApiRequests>(subDomain)

    @Provides
    fun provideApplication() = MyApplication.instance

    @Provides
    fun provideSharedPrefs(context: MyApplication): SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

}