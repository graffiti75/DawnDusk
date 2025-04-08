package com.cericatto.dawndusk.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cericatto.dawndusk.R
import com.cericatto.dawndusk.ui.theme.backgroundDarkFirst
import com.cericatto.dawndusk.ui.theme.backgroundDarkLast
import com.cericatto.dawndusk.ui.theme.backgroundLightFirst
import com.cericatto.dawndusk.ui.theme.backgroundLightLast
import com.cericatto.dawndusk.ui.theme.starActive
import com.cericatto.dawndusk.ui.theme.starInactive
import com.cericatto.dawndusk.ui.theme.starInactiveLight
import com.cericatto.dawndusk.ui.theme.starRowDark
import com.cericatto.dawndusk.ui.theme.textDark
import com.cericatto.dawndusk.ui.theme.textLight

@Composable
fun DawnDusk(
	isDarkTheme: Boolean = isSystemInDarkTheme()
) {
	val backgroundColorFirst = if (isDarkTheme) backgroundDarkFirst else backgroundLightFirst
	val backgroundColorLast = if (isDarkTheme) backgroundDarkLast else backgroundLightLast
	val textColor = if (isDarkTheme) textDark else textLight
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Top,
		modifier = Modifier.fillMaxSize()
			.background(
				brush = Brush.verticalGradient(
					colors = listOf(
						backgroundColorFirst,
						backgroundColorLast
					)
				)
			)
	) {
		MoonSunRow(isDarkTheme)
		Text(
			text = "How was your day?",
			style = TextStyle(
				color = textColor,
				fontSize = 32.sp
			),
			modifier = Modifier.padding(top = 100.dp)
		)
		StarRow(isDarkTheme)
	}
}

@Composable
fun MoonSunRow(
	isDarkTheme: Boolean = true
) {
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 40.dp)
			.padding(top = 100.dp)
	) {
		Image(
			painter = painterResource(id = R.drawable.sun),
			contentDescription = "Sun",
			modifier = if (isDarkTheme) Modifier.alpha(0f) else Modifier.alpha(1f)
		)
		Image(
			painter = painterResource(id = R.drawable.moon),
			contentDescription = "Moon",
			modifier = if (isDarkTheme) Modifier.alpha(1f) else Modifier.alpha(0f)
		)
	}
}

@Composable
fun StarRow(
	isDarkTheme: Boolean = true
) {
	Row(
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.padding(top = 20.dp)
			.padding(horizontal = 20.dp)
			.fillMaxWidth()
			.background(
				color = if (isDarkTheme) starRowDark else Color.White,
				shape = RoundedCornerShape(40.dp)
			)
			.padding(vertical = 15.dp)
			.padding(horizontal = 40.dp)

	) {
		StarIcon(isDarkTheme = isDarkTheme)
		StarIcon(isDarkTheme = isDarkTheme)
		StarIcon(isDarkTheme = isDarkTheme)
		StarIcon(isDarkTheme = isDarkTheme)
		StarIcon(
			isDarkTheme = isDarkTheme,
			isActive = false
		)
	}
}

@Composable
fun RowScope.StarIcon(
	isDarkTheme: Boolean = true,
	isActive: Boolean = true
) {
	val tintColor = if (isActive) {
		starActive
	} else {
		if (isDarkTheme) {
			starInactive
		} else {
			starInactiveLight
		}
	}
	Icon(
		imageVector = Icons.Filled.Star,
		contentDescription = "Star icon",
		tint = tintColor,
		modifier = Modifier.weight(1f)
			.size(50.dp)
	)
}

@Preview(
	name = "Light Theme Preview",
	uiMode = Configuration.UI_MODE_NIGHT_NO,
	showBackground = true
)
@Composable
fun DawnDuskPreviewLight() {
	DawnDusk(isDarkTheme = false)
}

@Preview(
	name = "Dark Theme Preview",
	uiMode = Configuration.UI_MODE_NIGHT_YES,
	showBackground = true
)
@Composable
fun DawnDuskPreviewDark() {
	DawnDusk()
}