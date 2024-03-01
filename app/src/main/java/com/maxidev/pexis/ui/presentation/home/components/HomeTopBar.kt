package com.maxidev.pexis.ui.presentation.home.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxidev.pexis.R
import com.maxidev.pexis.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    onAction: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    TopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.pexels_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
        },
        title = {
            Text(
                text = stringResource(id = title),
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp
            )
        },
        actions = {
            IconButton(onClick = onAction) {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.White),
        scrollBehavior = scrollBehavior
    )
}