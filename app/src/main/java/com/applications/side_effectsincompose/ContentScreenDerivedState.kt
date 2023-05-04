package com.applications.side_effectsincompose

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ContentScreenDerivedState(
    modifier: Modifier = Modifier, value: Int
) {
    var newValue by remember {
        mutableStateOf(value)
    }

    //best practice
    val text by remember {
        derivedStateOf {
            "The value is $newValue"
        }
    }
    //bad practice
    val newText = "The value is $newValue"

    Text(text = text, fontSize = 24.sp, modifier = modifier.clickable {
        newValue++
    })
}