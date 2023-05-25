package com.example.pruebatecnicaesau.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.pruebatecnicaesau.R
import com.example.pruebatecnicaesau.databinding.ActivityMainBinding
import com.example.pruebatecnicaesau.domain.extension.load
import com.example.pruebatecnicaesau.domain.model.RandomUser
import com.example.pruebatecnicaesau.domain.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initListeners()
        initObserver()
        //initData()

    }

    private fun initListeners(){
        with(binding){
            buttonUpdate.setOnClickListener{
                viewModel.getRandomUser()
            }
        }
    }
    private fun initData() {
        viewModel.getRandomUser()
    }

    private fun initObserver() {
        viewModel.randomUserState.observe(this){ result ->
            when(result){
                is Resource.Success -> result.data?.let { bindUserData(it) }
                is Resource.Error -> handleError()
            }

        }

        viewModel.isLoading.observe(this){
            handleLoadingState(it)
        }


    }

    private fun bindUserData(randomUser: RandomUser){
        with(binding){
            userName.text = randomUser.name
            userImage.load(randomUser.image)
            userEmail.text = randomUser.email
            userBirthday.text = randomUser.birthday
            userAddress.text = randomUser.address
        }
    }
    private fun handleError(){
        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show()

    }
    private fun handleLoadingState(isLoading: Boolean){
        with(binding){
            if (isLoading){
                userData.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }else{
                userData.visibility = View.VISIBLE
                progressBar.visibility= View.GONE
            }
        }
    }
}