package com.maxidev.pexis.data.repository.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.maxidev.pexis.data.remote.model.photo_search.Photo
import com.maxidev.pexis.data.repository.impl.PhotosRepositoryImpl
import retrofit2.HttpException
import java.io.IOException

class PhotoPagingSource(
    private val backend: PhotosRepositoryImpl
): PagingSource<Int, Photo>() {

    companion object {
        const val PAGE_NUMBER = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: PAGE_NUMBER
            val response = backend.getCuratedPhotos(perPage = params.loadSize, page = nextPage)

            LoadResult.Page(
                data = response.photos,
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = if (response.photos.isEmpty()) null else nextPage.plus(1)
            )
        } catch (ioException: IOException) {
            LoadResult.Error(ioException)
        } catch (httpException: HttpException) {
            LoadResult.Error(httpException)
        }
    }
}