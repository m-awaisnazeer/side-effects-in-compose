package com.applications.side_effectsincompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun ContentScreenDisposableEffect(
    modifier: Modifier = Modifier, value: Int
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> Log.d(TAG, "DisposableEffect -> ON_CREATE: $value")
                Lifecycle.Event.ON_START -> Log.d(TAG, "DisposableEffect -> ON_CREATE: $value")
                Lifecycle.Event.ON_RESUME -> Log.d(TAG, "DisposableEffect -> ON_RESUME: $value")
                Lifecycle.Event.ON_PAUSE -> Log.d(TAG, "DisposableEffect -> ON_PAUSE: $value")
                Lifecycle.Event.ON_STOP -> Log.d(TAG, "DisposableEffect -> ON_STOP: $value")
                Lifecycle.Event.ON_DESTROY -> Log.d(
                    TAG,
                    "DisposableEffect -> ON_DESTROY: $value"
                )

                Lifecycle.Event.ON_ANY -> Log.d(TAG, "DisposableEffect -> ON_ANY: $value")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    Text(text = "$value",fontSize = 24.sp, modifier = modifier)
}