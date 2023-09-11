package com.moataz.jetanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moataz.jetanimation.ui.theme.JetAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetAnimationTheme {
                GoatFootballAnimation()
            }
        }
    }
}
