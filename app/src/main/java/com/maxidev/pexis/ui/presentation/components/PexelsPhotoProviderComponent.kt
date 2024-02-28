package com.maxidev.pexis.ui.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.maxidev.pexis.R
import com.maxidev.pexis.ui.theme.poppinsFamily
import com.maxidev.pexis.utils.Constants.PROVIDER_URL

@Composable
fun PexelsPhotoProviderComponent(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(PROVIDER_URL)
    )
    val buildString = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline
            )
        ) { append("Photos provided by Pexels") }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                startActivity(
                    context,
                    browserIntent,
                    null
                )
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.pexels_icon),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = buildString,
            fontFamily = poppinsFamily
        )
    }
}