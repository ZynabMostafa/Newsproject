package com.example.newsproject

import android.app.Application
import com.example.newsproject.data.local.ArticleDataBase.Companion.initiateArticleDataaBase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initiateArticleDataaBase()
    }
}