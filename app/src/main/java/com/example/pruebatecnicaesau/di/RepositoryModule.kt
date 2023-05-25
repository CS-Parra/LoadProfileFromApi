package com.example.pruebatecnicaesau.di

import com.example.pruebatecnicaesau.data.remote.RandomUserRepositoryImplementation
import com.example.pruebatecnicaesau.domain.repository.RandomUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRandomUserRepository(
        randomUserRepositoryImplementation: RandomUserRepositoryImplementation
    ): RandomUserRepository
}