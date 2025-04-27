package com.smparkworld.feature.ui.search.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smparkworld.common.design.AppTheme
import com.smparkworld.feature.search.R

@Composable
internal fun Toolbar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
            onClick = onBackClicked
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ico_close),
                contentDescription = stringResource(id = R.string.search_content_desc_back)
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(1f),
            text = title,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 14.sp)
        )
        Spacer(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
    }
}

@Composable
@Preview
private fun ToolbarPreview() {
    AppTheme {
        Toolbar(
            title = "Compose 검색 화면",
            onBackClicked = {}
        )
    }
}