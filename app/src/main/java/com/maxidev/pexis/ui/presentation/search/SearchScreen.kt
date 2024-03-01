package com.maxidev.pexis.ui.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.maxidev.pexis.R
import com.maxidev.pexis.ui.presentation.components.ListContent
import com.maxidev.pexis.ui.theme.poppinsFamily
import com.maxidev.pexis.utils.FakeHistorySearch.fakeHistorySearch
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: PhotosSearchedViewModel = hiltViewModel()
) {
    var query = viewModel.search.value
    val pagingSearch = viewModel.searchedImage.collectAsLazyPagingItems()
    var active by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                DockedSearchBar(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(4.dp),
                    query = query,
                    onQueryChange = viewModel::onSearchChange,
                    onSearch = {
                        scope.launch {
                            if (query.isEmpty()) {
                                active = false
                            } else {
                                active = false
                                viewModel.flowSearch(it)
                            }
                        }
                    },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = {
                        Text(
                            text = "Search photos",
                            fontFamily = poppinsFamily
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    },
                    colors = SearchBarDefaults.colors(
                        containerColor = Color.Transparent
                    )
                ) {
                    fakeHistorySearch.forEach { item ->
                        ListItem(
                            modifier = Modifier
                                .clickable {
                                    query = item
                                    viewModel.flowSearch(item)
                                    active = false
                                },
                            headlineContent = {
                                Text(
                                    text = item,
                                    fontFamily = poppinsFamily
                                )
                            },
                            colors = ListItemDefaults.colors(Color.Transparent)
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        ListContent(
            photos = pagingSearch,
            modifier = Modifier.padding(paddingValues)
        )
    }
}