package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.*
import com.example.cryptoapp.data.remote.dto.auth.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST(ApiRoutes.REGISTER)
    suspend fun register(@Body registerInfo: RegisterDto): Response<UserDto>?

    @Headers("Content-Type: application/json")
    @POST(ApiRoutes.LOGIN)
    suspend fun login(@Body loginInfo: LoginDto): Response<SessionDto>?

    @Headers("Content-Type: application/merge-patch+json")
    @PATCH(ApiRoutes.UPDATE)
    suspend fun updateUser(@Path("userId") userId: Int, @Body updateInfo: UpdateDto): Response<UserDto>?
}