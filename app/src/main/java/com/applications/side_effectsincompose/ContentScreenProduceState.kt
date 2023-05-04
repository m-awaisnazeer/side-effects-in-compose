package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ContentScreenProduceState(
    modifier: Modifier = Modifier, value: Int
) {
    Log.d(TAG, "ProduceState -> count upTo: $value")

    val nextValue = if (value > 0) {
        produceStateDemo(value)
    } else {
        produceStateDemo(value * -1)
    }

    Text(text = "${nextValue.value}",fontSize = 24.sp, modifier = modifier)
}

@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (value < countUpTo) {
            delay(300L)
            value++
        }
    }
}