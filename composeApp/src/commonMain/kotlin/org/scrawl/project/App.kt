package org.scrawl.project

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.scrawl.project.ui.theme.ScrawlTheme

@Composable
@Preview
fun App() {
    ScrawlTheme {
        Surface {
            MainScreen()
        }

    }
}