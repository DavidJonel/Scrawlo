@file:OptIn(ExperimentalFoundationApi::class)

package org.scrawl.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.Item

@Composable
actual fun FolderUI(folderItem: Item.FolderItem) {
    var expanded by remember { mutableStateOf(false) }
    var showContextMenu by remember { mutableStateOf<Item.File?>(null) }

    Column(modifier = Modifier.padding(4.dp)) {
        TextButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.FolderOpen else Icons.Filled.Folder,
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = folderItem.name,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

    AnimatedVisibility(expanded){
        Column(modifier = Modifier.padding(8.dp)) {
            folderItem.children.forEach { child ->
                when(child){
                    is Item.FolderItem -> {
                        FolderUI(child)
                    }
                    is Item.File -> {
                        Box(
                            modifier = Modifier
                                .combinedClickable(
                                    onClick = {},
                                    onLongClick = {
                                        showContextMenu = child
                                    }
                                )
                                .padding(16.dp)

                        ) {
                            Row{
                                Icon(
                                    modifier = Modifier.size(16.dp),
                                    imageVector = Icons.Default.Description,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(
                                    text = child.name,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                DropdownMenu(
                                    expanded = (showContextMenu == child),
                                    onDismissRequest = {showContextMenu = null}
                                ) {
                                    DropdownMenuItem(
                                        text = { Text("Delete") },
                                        onClick = {
                                            /*Handle Delete*/
//                                            showContextMenu = null
                                        })
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}