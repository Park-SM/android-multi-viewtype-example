package com.smparkworld.feature.ui.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.smparkworld.common.base.extensions.collectAt
import com.smparkworld.common.design.setContentWithTheme
import com.smparkworld.feature.ui.search.model.SearchEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val vm: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEvents()

        setContentWithTheme {
            val state by vm.state.collectAsStateWithLifecycle()

            SearchScreen(
                modifier = Modifier.fillMaxSize(),
                state = state,
                actionHandler = vm.actionHandler
            )
        }
    }

    private fun observeEvents() {
        vm.event.collectAt(this) { event ->
            when (event) {
                is SearchEvent.Close -> {
                    finish()
                }
            }
        }
    }
}