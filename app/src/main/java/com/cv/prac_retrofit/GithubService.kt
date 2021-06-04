package com.cv.prac_retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.github.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()              //Creates a Retrofit object.
    .addConverterFactory(MoshiConverterFactory.create(moshi))  //pass the converter
    .baseUrl(BASE_URL)                            //give the base URL
    .build()

interface service{                        //created the service interface like DAO which tells what to do and how
                                             // to do.

    @GET("users/Rishabhsingh715")
    suspend fun getUser() : User

    @GET("users")
    suspend fun getAllUsers() : List<User>

}

object obj {                              //we want a singleton of this, that is why we have used this approach
    val retro_obj : service by lazy{
        retrofit.create(service::class.java)
    }
}

