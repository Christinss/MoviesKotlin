package com.example.movies.request

import com.example.movies.utils.Credentials
import com.example.movies.utils.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    //Singleton for Retrofit2 API call
    public class Service {

        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        //Singleton pattern
        private val retrofit = retrofitBuilder.build()

        //Retrofit API
        private val movieApi = retrofit.create(MovieApi::class.java)

        //constructor of RetroServiceInterface
        fun getMovieApi(): MovieApi? {
            return movieApi
        }
    }
