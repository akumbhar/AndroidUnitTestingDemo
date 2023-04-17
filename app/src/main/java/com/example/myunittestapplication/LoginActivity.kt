package com.example.myunittestapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myunittestapplication.databinding.ActivityMainBinding
import com.example.myunittestapplication.util.checkInternetConnection
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            hide()
        }

        initViews()

    }

    private fun initViews() {

        binding.btnLogin.setOnClickListener {

            resetErrors()
            loginUser()

        }
    }

    private fun resetErrors() {
        binding.etUserName.error = null
        binding.etPassword.error = null
        binding.etSubDomain.error = null

    }

    private fun loginUser() {

        val userName = binding.etUserName.editText?.text.toString().trim()
        val subdomain = binding.etSubDomain.editText?.text.toString().trim()
        val password = binding.etPassword.editText?.text.toString().trim()
        observeFlows(loginViewModel.loginUser(userName, subdomain, password, hasInternetConnection = checkInternetConnection()))

    }

    private fun observeFlows(loginUserFlow: Flow<LoginViewModel.LoginState>) {
        lifecycleScope.launch {
            loginUserFlow.collect { viewState ->
                doLog("$viewState")
                when (viewState) {

                    LoginViewModel.LoginState.ShowLoading -> {

                    }

                    LoginViewModel.LoginState.HideLoading -> {

                    }

                    LoginViewModel.LoginState.UnknownErrorOccurred -> {
                        showErrorBanner(getString(R.string.unknown_error_occurred))
                    }

                    LoginViewModel.LoginState.UserNameError -> {
                        binding.etUserName.error = getString(R.string.required_field)
                    }

                    LoginViewModel.LoginState.PasswordError -> {
                        binding.etPassword.error = getString(R.string.required_field)
                    }

                    LoginViewModel.LoginState.SubdomainError -> {
                        binding.etSubDomain.error = getString(R.string.required_field)
                    }

                    LoginViewModel.LoginState.LoginSuccess -> {
                        navigateToDashboard()
                    }

                    is LoginViewModel.LoginState.ApiError -> {
                        showErrorBanner(viewState.message)
                    }
                    is LoginViewModel.LoginState.InternetConnectionFailure -> {
                        showErrorBanner(getString(R.string.internet_unavailable))
                    }
                }
            }
        }
    }

    private fun showErrorBanner(errorMessage: String) {
        binding.loginErrorBanner.visibility = View.VISIBLE
        binding.bannerErrorText.text = errorMessage
    }

    private fun navigateToDashboard(){
//        Intent(this, )
    }
}

fun Any.doLog(message: String) = Log.e("LoginApplication", message)