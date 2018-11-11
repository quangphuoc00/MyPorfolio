package com.peterdang.myprofile.core.blueprints

import com.peterdang.myprofile.core.exception.Failure
import com.peterdang.myprofile.core.utils.Either
import retrofit2.Call

interface BaseRepository {
    fun <T> request(call: Call<T>?, default: T): Either<Failure, T> {
        return try {
            val response = call!!.execute()
            if (response.isSuccessful) {
                Either.SuccessResult(response.body() ?: default)
            } else {
                Either.FailResult(Failure.ServerError())
            }
        } catch (exception: Throwable) {
            Either.FailResult(Failure.ServerError())
        }
    }
}