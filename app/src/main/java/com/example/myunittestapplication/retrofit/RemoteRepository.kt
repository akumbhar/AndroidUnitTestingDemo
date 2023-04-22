package com.example.myunittestapplication.retrofit

import kotlinx.coroutines.delay
import javax.inject.Inject

class RemoteRepository @Inject constructor() {

    suspend fun authenticateUser(
        username: String?,
        subDomain: String?,
        password: String?
    ): ServerResponse {
        val apiRequest = ApiBuilder().create<ApiRequests>(subDomain)
        val request = Request(
            Authentication(username = username, password = password),
            method = ApiMethod(ApiMethod.Method.GET_ACCESS_TOKEN)
        )
        delay(2_000)
        return apiRequest.authenticateUser(request)


    }

}