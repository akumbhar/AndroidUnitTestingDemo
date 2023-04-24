package com.example.myunittestapplication.login

import app.cash.turbine.test
import com.example.myunittestapplication.retrofit.ServerResponse
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    lateinit var viewModel: LoginViewModel

    @MockK
    lateinit var repository: LoginRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = LoginViewModel(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }


    @Test
    fun `loginUser method should emit error states when invalid fields`() = runTest{

        val userName = null
        val subDomain = null
        val password = null
        val hasInternetConnection = false

        val returnedFlow = viewModel.loginUser(userName, subDomain, password, hasInternetConnection)
        val returnedList = returnedFlow.toList()

        val expectedList = listOf(LoginViewModel.LoginState.UserNameError,
        LoginViewModel.LoginState.SubdomainError,
        LoginViewModel.LoginState.PasswordError)

        assertEquals(expectedList, returnedList)

    }




    @Test
    fun `loginUser should emit internet failure state when internet connection is not available`() =
        runTest {

            val userName = "Test"
            val subDomain = "Test"
            val password = "Test"
            val hasInternetConnection = false

            val returnedFlow = viewModel.loginUser(userName, subDomain, password, hasInternetConnection)
            val returnedList = returnedFlow.toList()

            val expectedList = listOf(LoginViewModel.LoginState.InternetConnectionFailure)

            assertEquals(expectedList, returnedList)

        }


    val successJson = "{\n" +
            "  \"response\": {\n" +
            "    \"requestId\": \"1234\",\n" +
            "    \"code\": 200,\n" +
            "    \"result\": {\n" +
            "      \"accessToken\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlbSIsImlkZW50aWZpZXIiOiIyMDE0NDB8NDU4MXwxMjM0NSIsImlhdCI6MTY4MjE0NzA0OCwiZXhwIjoxNjgzNDQzMDQ4LCJuYmYiOjE2ODIxNDcwNDh9.zeRchW-OBw7qV3VpZaKG469JXEdmnUw_qpij4gqiyS4\",\n" +
            "      \"refreshToken\": \"6fc46d5385179f9830c427105a5fa39a0f5b2bdc\"\n" +
            "    }\n" +
            "  }\n" +
            "}"


    @Test
    fun `loginUser should emit correct states when inputs are valid and internet connection is available`() =  runTest {


        val userName = "Test"
        val subDomain = "Test"
        val password = "Test"
        val hasInternetConnection = true

        val serverResponse = Gson().fromJson(successJson, ServerResponse::class.java)
        coEvery { repository.loginUser(any(), any(), any()) } returns serverResponse
        coEvery { repository.saveToken(any()) } returns Unit

        val returnedFlow = viewModel.loginUser(userName, subDomain, password, hasInternetConnection)
        val returnedList = returnedFlow.toList()

        val expectedList = listOf(LoginViewModel.LoginState.ShowLoading,
        LoginViewModel.LoginState.HideLoading,
        LoginViewModel.LoginState.LoginSuccess)

        assertEquals(expectedList, returnedList)

    }



    val errorJson = "{\"response\":{\"requestId\":\"1469225572\",\"error\":{\"code\":309,\"message\":\"Invalid UserName or Password\"}}}"

    @Test
    fun `loginUser should emit correct state when unknown error occurs`() = runTest {
        val userName = "test"
        val password = "test"
        val subdomain = "test"
        val hasInternetConnection = true

        coEvery { repository.loginUser(any(), any(), any()) } throws Exception("Unknown error occurred.")

        val returnedFlow = viewModel.loginUser(userName, subdomain, password, hasInternetConnection)
        val retunedList = returnedFlow.toList()

        val expectedList = listOf (LoginViewModel.LoginState.ShowLoading,
            LoginViewModel.LoginState.HideLoading,
            LoginViewModel.LoginState.UnknownErrorOccurred)

        assertEquals(expectedList, retunedList)
    }



    @Test
    fun `loginUser should emit correct state when API returns error`() = runTest {

        val userName = "Test"
        val subDomain = "Test"
        val password = "Test"
        val hasInternetConnection = true

        val errorResponse = Gson().fromJson(errorJson, ServerResponse::class.java)
        coEvery { repository.loginUser(any(), any(), any()) } returns errorResponse

        val returnedFlow = viewModel.loginUser(userName, subDomain, password, hasInternetConnection)

        returnedFlow.test {
            assertTrue(awaitItem() is LoginViewModel.LoginState.ShowLoading)
            assertTrue(awaitItem() is LoginViewModel.LoginState.HideLoading)
            assertTrue(awaitItem() is LoginViewModel.LoginState.ApiError)
            awaitComplete()
        }
    }
}