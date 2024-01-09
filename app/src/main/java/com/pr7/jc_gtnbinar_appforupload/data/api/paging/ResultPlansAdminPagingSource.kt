package com.pr7.jc_gtnbinar_appforupload.data.api.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pr7.jc_gtnbinar_appforupload.data.api.Api
import com.pr7.jc_gtnbinar_appforupload.data.model.remote.plan.DataX
import com.pr7.jc_gtnbinar_appforupload.presentation.uiutils.showlogd

class ResultPlansAdminPagingSource constructor(
    val api: Api,
    val token:String
): PagingSource<Int, DataX>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataX> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllPlansforAdmin(token = token,page = page)
            showlogd(response.data.data.toString())

            LoadResult.Page(
                data = response.data.data,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.data.pagination.has_more) page.plus(1) else null,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataX>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        //return state.anchorPosition
    }


}