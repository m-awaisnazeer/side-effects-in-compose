package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ContentScreenCoroutineScope(
    modifier: Modifier = Modifier, value: Int
) {
    val scope = rememberCoroutineScope()
//    scope.launch {
//        Log.d(TAG, "CoroutineScope-> relaunch on every successful Recomposition $value")
//    }

    Text(text = "$value", fontSize = 24.sp, modifier = modifier.clickable {
        scope.launch {
            Log.d(TAG, "CoroutineScope-> relaunch on every successful Recomposition $value")
        }
    })
}
