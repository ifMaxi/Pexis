package com.maxidev.pexis.ui.presentation.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.maxidev.pexis.ui.presentation.components.ListContent
import com.maxidev.pexis.ui.presentation.components.PexelsPhotoProviderComponent
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                DockedSearchBar(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(4.dp),
                    query = query,
                    onQueryChange = viewModel::onSearchChange,
                    onSearch = {
                        scope.launch {
                            if (query.isEmpty()) {
                                active = false
                            } else {
                                active = false
                                viewModel.getSearchedImages(it)
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
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = null
                        )
                    }
                ) {
                    fakeHistorySearch.forEach { item ->
                        ListItem(
                            modifier = Modifier
                                .clickable {
                                    query = item
                                    viewModel.getSearchedImages(item)
                                    active = false
                                },
                            headlineContent = {
                                Text(
                                    text = item,
                                    fontFamily = poppinsFamily
                                )
                            }
                        )
                        HorizontalDivider()
                    }
                }

                PexelsPhotoProviderComponent()
            }
        }
    ) { paddingValues ->
        ListContent(
            photos = pagingSearch,
            modifier = Modifier.padding(paddingValues)
        )
    }
}