package com.maxidev.pexis.ui.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.maxidev.pexis.ui.presentation.components.CoilImage
import com.maxidev.pexis.ui.theme.poppinsFamily

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    image: String,
    photographer: String,
    url: String
) {
    val context = LocalContext.current
    val roundedCorner = RoundedCornerShape(6)
    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(url)
    )

    ElevatedCard(
        modifier = modifier
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                shape = roundedCorner
            ),
        shape = roundedCorner,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CoilImage(
                modifier = Modifier
                    .clip(roundedCorner)
                    .clickable {
                        ContextCompat.startActivity(
                            context,
                            browserIntent,
                            null
                        )
                    },
                image = image
            )
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Photo taken by $photographer",
                textAlign = TextAlign.Center,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Light,
                fontSize = 13.sp
            )
        }
    }
}