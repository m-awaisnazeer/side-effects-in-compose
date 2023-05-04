package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun RememberUpdateState(
    modifier: Modifier = Modifier, value: Int
) {
    val updatedValue by rememberUpdatedState(newValue = value)

    LaunchedEffect(key1 = true) {
        delay(5.seconds)
        Log.d(TAG, "RememberUpdateState:updatedValue-> $updatedValue")
    }

    Text(text = updatedValue.toString(), fontSize = 24.sp, modifier = modifier)
}