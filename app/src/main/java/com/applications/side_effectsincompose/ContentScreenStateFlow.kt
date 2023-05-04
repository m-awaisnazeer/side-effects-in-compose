package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.filter

@Composable
fun ContentScreenStateFlow(
    modifier: Modifier = Modifier, value: Int
) {
    var newValue by remember {
        mutableStateOf(value)
    }

    val nextValue = if (value > 0) {
        produceStateDemo(value)
    } else {
        produceStateDemo(value * -1)
    }

    LaunchedEffect(key1 = nextValue) {
        snapshotFlow {
            nextValue.value
        }.filter {
            it % 2 == 0
        }.collect {
            newValue = it
            Log.d(TAG, "ContentScreenStateFlow:snapshotFlow-> $it")
        }
    }


    Text(text = newValue.toString(),fontSize = 24.sp, modifier = modifier)
}