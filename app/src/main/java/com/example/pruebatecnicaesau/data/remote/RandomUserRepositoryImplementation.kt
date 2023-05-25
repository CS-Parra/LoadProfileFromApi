package com.example.pruebatecnicaesau.data.remote

import com.example.pruebatecnicaesau.data.mappers.toDomain
import com.example.pruebatecnicaesau.domain.model.RandomUser
import com.example.pruebatecnicaesau.domain.repository.RandomUserRepository
import com.example.pruebatecnicaesau.domain.util.Resource
import javax.inject.Inject

class RandomUserRepositoryImplementation @Inject constructor(
    private val randomUserApi: RandomUserApi
): RandomUserRepository {


    override suspend fun fetchRandomUser(): Resource<RandomUser> {
        return try{
            Resource.Success(
                data = randomUserApi.getRandomUser().results.first().toDomain()
            )
        } catch (e: Exception){
            Resource.Error(
                message = "Unknown Error"
            )
        }
    }


}