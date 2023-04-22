package com.example.myunittestapplication.login

import com.example.myunittestapplication.retrofit.LocalRepository
import com.example.myunittestapplication.retrofit.RemoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) {

    suspend fun loginUser(
        username: String?,
        subDomain: String?,
        password: String?
    ) = remoteRepository.authenticateUser(username, subDomain, password)


    suspend fun saveToken(token:String) = localRepository.saveUserToken(token)
}