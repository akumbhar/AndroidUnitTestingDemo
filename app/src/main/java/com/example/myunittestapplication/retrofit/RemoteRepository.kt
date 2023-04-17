package com.example.myunittestapplication.retrofit

import javax.inject.Inject

class RemoteRepository @Inject constructor() {

    suspend fun authenticateUser(
        username: String,
        subDomain: String,
        password: String
    ): ServerResponse {
        val apiRequest = ApiBuilder().create<ApiRequests>(subDomain)
        val request = Request(
            Authentication(username = username, password = password),
            method = ApiMethod(ApiMethod.Method.GET_ACCESS_TOKEN)
        )
        return apiRequest.authenticateUser(request)


    }

}