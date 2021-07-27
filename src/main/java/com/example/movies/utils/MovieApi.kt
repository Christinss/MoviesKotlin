package com.example.movies.utils

import com.example.movies.data.Movie
import com.example.movies.data.MovieSearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


    //client class that is receiving data objects from a service objects class
    interface MovieApi {
        //Search for movies
        @GET("3/movie/{movie_id}?")
        fun getMovie(
            @Path("movie_id") movie_id: Int,
            @Query("api_key") api_key: String?
        ): Call<Movie?>?

        //GET popular movies
        //https://api.themoviedb.org/3/movie/popular
        //?api_key=fe3b8cf16d78a0e23f0c509d8c37caad
        @GET("/3/movie/popular")
        fun getPopular(
            @Query("api_key") key: String?,
            @Query("query") query: String?,
            @Query("page") page: Int
        ): Call<MovieSearchResponse?>?

        //GET top rated movies
        //https://api.themoviedb.org/3/movie/top_rated
        //?api_key=fe3b8cf16d78a0e23f0c509d8c37caad
        @GET("/3/movie/top_rated")
        fun getTopRated(
            @Query("api_key") key: String?,
            @Query("query") query: String?,
            @Query("page") page: Int
        ): Call<MovieSearchResponse?>?


        companion object {
            internal val MOVIE_DB_URL = "http://api.themoviedb.org/3/"
            val api_key = "fe3b8cf16d78a0e23f0c509d8c37caad"
            fun create(): MovieApi {
                val retrofit = Retrofit.Builder()
                    .baseUrl(MOVIE_DB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(MovieApi::class.java)
            }
        }
    }
