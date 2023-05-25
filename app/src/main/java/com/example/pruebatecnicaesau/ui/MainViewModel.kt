package com.example.pruebatecnicaesau.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaesau.domain.model.RandomUser
import com.example.pruebatecnicaesau.domain.repository.RandomUserRepository
import com.example.pruebatecnicaesau.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val repository: RandomUserRepository
): ViewModel() {

    private val _randomUserState = MutableLiveData<Resource<RandomUser>>()
    val randomUserState: LiveData<Resource<RandomUser>>
        get() = _randomUserState

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init{
        getRandomUser()
    }

    fun getRandomUser(){
        viewModelScope.launch {
            _isLoading.value = true
            _randomUserState.value = repository.fetchRandomUser()
            _isLoading.value = false
        }
    }
}