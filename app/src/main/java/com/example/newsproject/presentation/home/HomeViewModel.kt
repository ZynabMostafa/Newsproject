package com.example.newsproject.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.data.Repo
import com.example.newsproject.data.remot.model.newsmodel.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val Repo = Repo()
    private val _status = MutableStateFlow(HomeModel())
    val status = _status.asStateFlow()

    init {
        get()
    }

    fun get() {
        _status.update { it.copy(isLoading = true) }

            viewModelScope.launch {
              kotlin.runCatching {
                Repo.getNews("bitcoin")
                _status.update {
                    it.copy(
                        isLoading = false,
                        list = Repo.getNews("bitcoin")
                    )
                }
        }.getOrElse { error ->
            _status.update {
                it.copy(
                    isLoading = false,
                    dialogModel = HomeModel.DialogModel(error.message.toString(), true)
                )
            }
        }
            }

    }

    val disableButton =
        _status.update {
            it.copy(buttonEnabled = false)

        }


    fun insertArticle(article: Article) {
        viewModelScope.launch {
           Repo.insertArticle(article)
        }

    }

    fun dismissDialog() {
        _status.update {
            it.copy(dialogModel = null)
        }

}}

 data class HomeModel (
     val list: List<Article> = emptyList(),
     val isLoading : Boolean = false,
     val dialogModel : DialogModel? = null,
    val buttonEnabled : Boolean = false
 ) {

     data class DialogModel (
         val massage:String,
         val showDialog : Boolean = false
     )


 }
