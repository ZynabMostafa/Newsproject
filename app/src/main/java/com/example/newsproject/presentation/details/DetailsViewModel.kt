package com.example.newsproject.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.data.Repo
import com.example.newsproject.data.remot.model.newsmodel.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

        private val Repo = Repo()
        private val _state = MutableStateFlow(DetailModel())
        val state = _state.asStateFlow()

        init {
            getList()
        }

        fun getList() {
            viewModelScope.launch {
               Repo.getAllArticle().collectLatest {list->
                    _state.update {
                        it.copy(list = list)
                    }
                }

            }
        }

        fun deleteAll() {
            viewModelScope.launch {
                Repo.getAllArticle()
            }
        }
            fun deleteArticle(article: Article) {
                viewModelScope.launch {
                    Repo.deleteCustom(article)
                }
            }
        }







    data class DetailModel(
        val list: List<Article> = emptyList()
    )
