package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Folder(folderItem: Item.FolderItem) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(4.dp)) {
        TextButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.FolderOpen else Icons.Filled.Folder,
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(folderItem.name)
        }
        if(expanded){
            TextButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text("Add Script")
            }
        }
    }

    AnimatedVisibility(expanded){
        Column(modifier = Modifier.padding(8.dp)) {
            folderItem.children.forEach { child ->
               when(child){
                   is Item.FolderItem -> {
                       Folder(child)
                   }
                   is Item.File -> {
                       TextButton(onClick = { }) {
                           Icon(
                               modifier = Modifier.size(16.dp),
                               imageVector = Icons.Default.Description,
                               contentDescription = null
                           )
                           Spacer(modifier = Modifier.padding(4.dp))
                           Text(child.name)
                       }
                   }
               }
            }
        }
    }
}




