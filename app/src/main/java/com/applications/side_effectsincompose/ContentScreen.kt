package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier, value: Int
) {
    Log.d(TAG, "ContentScreen Recomposed: $value")
    Text(
        text = "$value", modifier = modifier,
        fontSize = 24.sp
    )
}