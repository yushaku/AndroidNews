package com.androiddevs.mvvmnewsapp.API

import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    //suspend function là một function có khả năng được started, pause và resume
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "us",
        @Query("page")    pageNumber: Int = 1,
        @Query("apiKey")  apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
    @Query("q")       searchQuery: String,
    @Query("page")    pageNumber: Int = 1,
    @Query("apiKey")  apiKey: String = API_KEY
    ): Response<NewsResponse>
}