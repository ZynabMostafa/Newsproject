package com.example.newsproject.data.remot.api

import com.example.newsproject.data.remot.model.newsmodel.NewsArtical
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNews  {

    companion object{
        const val BASE_URL = " https://newsapi.org/v2/"
        const val API_KEY = "86ce30105ef2495883155e8940a2f311"
    }

    @GET("everything")
  suspend fun getNews(
      @Query("q")
      query: String,
      @Query("api_key")
      apiKey: String = API_KEY
  ) :Response<NewsArtical>


}