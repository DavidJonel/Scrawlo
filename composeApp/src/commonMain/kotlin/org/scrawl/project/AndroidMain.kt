package org.scrawl.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.Folder
import components.TransparentTextField
import components.WordCounter
import components.generateDummyData
import kotlinx.coroutines.launch

@Composable
fun AndroidMain(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val folder = generateDummyData()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(0.6f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Projects")
                    IconButton(onClick = { /* Handle add folder */ }) {
                        Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add")
                    }
                }
                Folder(folder)
            }
        }
    ){
        Scaffold{
            Box(modifier = Modifier.fillMaxSize()) {
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
}