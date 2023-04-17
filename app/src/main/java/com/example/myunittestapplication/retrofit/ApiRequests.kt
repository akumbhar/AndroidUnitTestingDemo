package com.example.myunittestapplication.retrofit

import retrofit2.http.*

interface ApiRequests {

    @POST("auth")
    suspend fun authenticateUser(@Body request: Request): ServerResponse

}