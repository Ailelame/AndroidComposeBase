package com.stormbirdmedia.androidcomposebase.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stormbirdmedia.androidcomposebase.ui.theme.AndroidComposeBaseTheme
import com.stormbirdmedia.domain.model.Task

@Composable
fun TaskItemLayout(
    task: Task,
    onClickAction: () -> Unit,
    onTaskChecked: (checked: Boolean) -> Unit,
    onDeleteClicked: (task: Task) -> Unit
) {
    Card(
        Modifier
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
            .defaultMinSize(48.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(0.8f)
                ) {
                Checkbox(checked = task.isComplete, onCheckedChange = { onTaskChecked(task.isComplete) })
                Text(text = task.text, Modifier.padding(16.dp))

            }
            IconButton(onClick = { onDeleteClicked(task) }, Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp).weight(0.2f)) {
                Icon(Icons.Outlined.Delete, "Delete icon")
            }
        }
    }

}

@Preview
@Composable
fun TaskItemLayoutPreview() {
    AndroidComposeBaseTheme() {
        TaskItemLayout(task = Task(1, "Task", false), onClickAction = { }, onTaskChecked = {}, {})
    }
}


