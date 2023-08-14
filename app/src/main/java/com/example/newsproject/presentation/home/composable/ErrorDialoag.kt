package com.example.newsproject.presentation.home.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorDialog(showDialog : Boolean= false, massage: String, onConfirmClic:()->Unit, onDismiss :()->Unit){
       if (!showDialog) return
           AlertDialog(
               title = {
                       Row {
                           Icon(imageVector = Icons.Filled.Warning, contentDescription = "warning")
                           Spacer(modifier = Modifier.width(15.dp))
                           Text(text = "Error Loading")
                       }

               },
               text = {
                      Text(text = massage)
               },
               onDismissRequest = { onDismiss::invoke },
               confirmButton = { onConfirmClic::invoke })
       }
