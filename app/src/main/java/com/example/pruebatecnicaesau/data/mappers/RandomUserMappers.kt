package com.example.pruebatecnicaesau.data.mappers

import com.example.pruebatecnicaesau.data.remote.response.Result
import com.example.pruebatecnicaesau.domain.model.RandomUser

fun Result.toDomain(): RandomUser {
    return RandomUser(
        name = "${this.name.first} ${this.name.last}",
        email = this.email,
        birthday = this.dob.date,
        age = this.dob.age,
        address = "${this.location.city} ${this.location.state}",
        phone = this.phone,
        image = this.picture.large,
        password = this.login.password
    )
}


