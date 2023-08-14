package com.example.newsproject.data.remot

import com.example.newsproject.data.remot.api.ApiNews
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient
{

    companion object{
        private val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        private val client = Builder()
            .addInterceptor(logging).build()
        private val retrofitClient by lazy {
            Retrofit
                .Builder()
                .client(client)
                .baseUrl(ApiNews.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiNews : ApiNews by lazy {
            retrofitClient.create(ApiNews::class.java)
        }
    }


}