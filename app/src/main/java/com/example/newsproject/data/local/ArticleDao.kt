package com.example.newsproject.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsproject.data.remot.model.newsmodel.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {


    @Query("DELETE  FROM article_table  ")
    fun deleteAll ()

    @Delete
    fun deleteCustom(article: Article)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun inset(article: Article)

    @Query("SELECT * FROM article_table")
    fun getAllArticle (): Flow<List<Article>>


}