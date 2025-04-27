package com.smparkworld.feature.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smparkworld.common.base.framework.ActionHandler
import com.smparkworld.feature.ui.search.base.SearchViewType.Companion.findComposableBy
import com.smparkworld.feature.ui.search.component.Toolbar
import com.smparkworld.feature.ui.search.model.SearchAction
import com.smparkworld.feature.ui.search.model.SearchUiState

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    state: SearchUiState,
    actionHandler: ActionHandler<SearchAction>
) {
    when (state) {
        is SearchUiState.Loading -> {
            // Not yet implemented
        }
        is SearchUiState.Error -> {
            // Not yet implemented
        }
        is SearchUiState.Success -> {
            SuccessState(
                modifier = modifier,
                state = state,
                actionHandler = actionHandler
            )
        }
    }
}

@Composable
fun SuccessState(
    modifier: Modifier = Modifier,
    state: SearchUiState.Success,
    actionHandler: ActionHandler<SearchAction>
) {
    Column(modifier = modifier) {
        Toolbar(
            modifier = Modifier
                .fillMaxWidth(),
            title = state.title,
            onBackClicked = { actionHandler.handle(SearchAction.OnClickClose) }
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize()
                .weight(1f),
            columns = GridCells.Fixed(1),
        ) {
            items(
                items = state.items,
                key = { it },
                contentType = { it.viewType }
            ) { model ->
                with(findComposableBy(model.viewType)) {
                    Section(
                        modifier = Modifier,
                        model = model,
                        actionHandler = actionHandler
                    )
                }
            }
        }
    }
}