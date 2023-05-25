package com.example.pruebatecnicaesau.domain.repository

import com.example.pruebatecnicaesau.domain.model.RandomUser
import com.example.pruebatecnicaesau.domain.util.Resource

interface RandomUserRepository {

    suspend fun getRandomUser() : Resource<RandomUser>
}