import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    placeholder: String?,
    value: String,
    isPassword: Boolean = false,
    handleValue: (String) -> Unit,
    maxLines: Int = 1

) {

    TextField(
        value = value,
        onValueChange = { handleValue(it) },
        textStyle = TextStyle(
            color = Color.Black
        ) ,
        placeholder = {
            Text(
                text = placeholder ?: "",
                color = Color.Gray
            )
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        minLines = maxLines,
        maxLines = maxLines,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}