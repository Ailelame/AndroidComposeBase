package com.stormbirdmedia.androidcomposebase.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stormbirdmedia.androidcomposebase.ui.theme.AndroidComposeBaseTheme

@Composable
fun TitleComposable(text: String) {
    Text(
        text = text,
        fontSize = 30.sp,
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun TaskDescription(description: String) {
    Text(text = description, fontSize = 16.sp, modifier = Modifier.padding(8.dp))

}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TaskTextField(
    state: EditableUserInputState = rememberEditableUserInputState(""),
    onValidateClicked: (input: String) -> Unit
) {

    OutlinedTextField(
        value = state.text,
        onValueChange = { state.text = it },
        singleLine = true,
        placeholder = { Text(text = "Ajouter une Task") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                val input = state.text
                if (input.isNotBlank()) {
                    onValidateClicked(input)
                    state.text = ""
                }
            }
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun TitleComposablePreview(text: String = "Default") {
    AndroidComposeBaseTheme {
        TitleComposable(text = "Title")
    }
}

@Preview
@Composable
fun TaskDescriptionPreview(text: String = "Default") {
    AndroidComposeBaseTheme {
        TaskDescription(description = "Description")
    }
}


@Composable
fun rememberEditableUserInputState(hint: String): EditableUserInputState =
    rememberSaveable(hint, saver = EditableUserInputState.Saver) {
        EditableUserInputState(hint, hint)
    }

class EditableUserInputState(private val hint: String, initialText: String) {

    var text by mutableStateOf(initialText)

    val isHint: Boolean
        get() = text == hint

    companion object {
        val Saver: Saver<EditableUserInputState, *> = listSaver(
            save = { listOf(it.hint, it.text) },
            restore = {
                EditableUserInputState(
                    hint = it[0],
                    initialText = it[1],
                )
            }
        )
    }
}