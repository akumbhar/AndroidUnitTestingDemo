package com.example.myunittestapplication.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    sealed class LoginState {
        object ShowLoading : LoginState()
        object HideLoading : LoginState()
        object UnknownErrorOccurred : LoginState()
        object UserNameError : LoginState()
        object PasswordError : LoginState()
        object SubdomainError : LoginState()
        object LoginSuccess : LoginState()
        object InternetConnectionFailure : LoginState()
        class ApiError(val message: String) : LoginState()

    }


    fun loginUser(
        username: String?,
        subDomain: String?,
        password: String?,
        hasInternetConnection:Boolean
    ) = flow {

        val returnedFlow = validateFields(username, subDomain, password)
        if(returnedFlow.count() > 0){
            returnedFlow.collect {
                emit(it)
            }
        }else if (hasInternetConnection.not()){
            emit(LoginState.InternetConnectionFailure)
        }
        else {

            emit(LoginState.ShowLoading)
            try {
                val apiResponse = repository.loginUser(username, subDomain, password)
                apiResponse.response.error?.let { error ->
                    emit(LoginState.HideLoading)
                    emit(LoginState.ApiError(error.message))
                }
                apiResponse.response.result?.let { apiResult ->
                    repository.saveToken(apiResult.accessToken)
                    emit(LoginState.HideLoading)
                    emit(LoginState.LoginSuccess)

                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(LoginState.HideLoading)
                emit(LoginState.UnknownErrorOccurred)
            }
        }
    }

    private fun validateFields(username: String?,
                               subDomain: String?,
                               password: String?,) = flow {
        if (username.isNullOrEmpty()) {
            emit(LoginState.UserNameError)
        }
        if (subDomain.isNullOrEmpty()) {
            emit(LoginState.SubdomainError)
        }
        if (password.isNullOrEmpty()) {
            emit(LoginState.PasswordError)
        }
    }

}