package com.example.pruebatecnicaesau.data.remote

import com.example.pruebatecnicaesau.data.remote.response.ResponseDTO
import retrofit2.http.GET

interface RandomUserApi {

    @GET("/api/")
    suspend fun getRandomUser(): ResponseDTO
}