package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit

@Composable
fun TransparentTextField(
    label: String,
    textValue: String,
    onValueChange: (TextFieldValue) ->Unit,
    labelSize: TextUnit,

    modifier: Modifier = Modifier,
){
    TextField(
        value = textValue,
        onValueChange = { newText ->
            onValueChange(TextFieldValue(text = newText))
        },
        textStyle = TextStyle(
            fontSize = labelSize,
        ),
        modifier = modifier
            .fillMaxWidth(),
        placeholder = { Text(
            text = label,
            fontSize = labelSize,
        )},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )

    )
}