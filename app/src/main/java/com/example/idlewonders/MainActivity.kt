package com.example.idlewonders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.idlewonders.ui.theme.IdleWondersTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IdleWondersTheme {
                IdleWondersApp()
            }
        }
    }
}