package com.cericatto.dawndusk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cericatto.dawndusk.ui.DawnDusk
import com.cericatto.dawndusk.ui.theme.DawnDuskTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			DawnDuskTheme {
				DawnDusk()
			}
		}
	}
}