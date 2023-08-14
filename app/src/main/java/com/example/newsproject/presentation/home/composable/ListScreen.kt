package com.example.newsproject.presentation.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsproject.data.remot.model.newsmodel.Article

@Composable
fun ListScreen(list: List<Article>, onclick: (Article) -> Unit ) {
    if (list.isNullOrEmpty()) return
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(list) {
            ElevatedCard(
                Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(10.dp),

                ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {


                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "title : ", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                        Text(text = it?.title ?: "", fontSize = 17.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Author : ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = it?.author ?: "", fontSize = 17.sp)
                    }
                    Text(
                        text = "Description : ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = it?.description ?: "",
                        fontSize = 17.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,

                        )
                    Button(onClick = { onclick(it)
                                     },
                        Modifier.align(Alignment.CenterHorizontally),
                      ) {
                        Text(text = "Insert")
                    }

                }


            }
        }
    }

}

