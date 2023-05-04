package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ContentScreenSideEffect(
    modifier: Modifier = Modifier, value: Int
) {
    SideEffect {
        Log.d(TAG, "SideEffect -> invoke on every successful Recomposition : $value")
    }
    Text(text = "$value",fontSize = 24.sp, modifier = modifier)
}