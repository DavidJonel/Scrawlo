package org.scrawl.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.TransparentTextField
import components.WordCounter
import components.generateDummyData

@Composable
actual fun MainUI(){
    val folder = generateDummyData() //dum dum
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(8.dp)
                .fillMaxHeight()
                .weight(0.25f)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Projects")
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add")
                    }
                }
                FolderUI(folder)
            }
        }


        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                TransparentTextField(
                    "",
                    textValue = text.text,
                    onValueChange = { NewBody -> text = NewBody },
                    labelSize = 14.sp,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
                Text(
                    text = "${WordCounter(text.text)}",
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(start = 8.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}