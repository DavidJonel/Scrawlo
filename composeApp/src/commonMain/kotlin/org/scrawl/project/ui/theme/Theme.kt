package org.scrawl.project.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightColorScheme = lightColorScheme(
    primary = leather,
    onPrimary = paleGold,
    surface = cream,
    onSurface = ink
)

@Composable
fun ScrawlTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = lightColorScheme,
        content = content
    )
}