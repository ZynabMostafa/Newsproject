package com.example.newsproject.data.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsproject.data.remot.model.newsmodel.Article

@Database([Article::class], version = 1)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    companion object {

        private lateinit var instanceArticleDatabase: ArticleDataBase
        private val Lock = Any()
        fun Application.initiateArticleDataaBase(): ArticleDataBase {
            return runCatching { instanceArticleDatabase }.getOrElse {
                synchronized(Lock) {
                    createDataBase(this).also { instanceArticleDatabase= it }
                }
            }
        }

        fun getDatabase() = instanceArticleDatabase

        private fun createDataBase(context: Context) = Room
            .databaseBuilder(context.applicationContext, ArticleDataBase::class.java, "dp")
            .build()


    }
}
