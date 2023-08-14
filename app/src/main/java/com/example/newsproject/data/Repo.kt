package com.example.newsproject.data

import com.example.newsproject.data.local.ArticleDataBase
import com.example.newsproject.data.remot.RetrofitClient
import com.example.newsproject.data.remot.api.ApiNews
import com.example.newsproject.data.remot.model.newsmodel.Article
import kotlinx.coroutines.flow.Flow

class Repo(
   private val apiNews: ApiNews = RetrofitClient.apiNews,
  private  val db: ArticleDataBase = ArticleDataBase.getDatabase()
) {
   suspend fun getNews(q:String) : List<Article>{
       val result = apiNews.getNews(q)
       return result.body()?.articles.orEmpty()
   }
    suspend fun insertArticle(article: Article){
         db.articleDao().inset(article)
     }

    fun getAllArticle(): Flow<List<Article>> {
        return db.articleDao().getAllArticle()
    }

    fun deleteCustom(article: Article) = db.articleDao().deleteCustom(article)
    fun delete() = db.articleDao().deleteAll()
}