package com.applications.side_effectsincompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.applications.side_effectsincompose.ui.theme.SideeffectsInComposeTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private val valueStateFlow = MutableStateFlow(0)

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SideeffectsInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    CenterAlignedTopAppBar(title = {
                        Text(text = stringResource(id = R.string.app_name))
                    })
                }) {
                    var value by remember {
                        mutableStateOf(0)
                    }

                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ContentScreen(modifier = Modifier.weight(0.5F), value = value)
                        Button(onClick = {
                            valueStateFlow.update {
                                Random.nextInt()
                            }
                            value = Random.nextInt(0, 200)
                        }) {
                            Text(text = "Update Data and Recompose Composables")
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun ContentScreenLaunchedEffect(
        modifier: Modifier = Modifier, value: Int
    ) {

        val isEvenNumber = value % 2 == 0
        LaunchedEffect(key1 = isEvenNumber) {
            Log.d(TAG, "LaunchedEffect -> invoke when LaunchedEffect key changes: $value")
        }

        LaunchedEffect(key1 = true) {
            Log.d(
                TAG, "LaunchedEffect -> invoke only on first composition when key is true: $value"
            )
            valueStateFlow.collect {
                Log.d(
                    TAG, "LaunchedEffect -> listen to continuous changes : $it"
                )
            }
        }
        Text(text = "$value", modifier = modifier)
    }
}