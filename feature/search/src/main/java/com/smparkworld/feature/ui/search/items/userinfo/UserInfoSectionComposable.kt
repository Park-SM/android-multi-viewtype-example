package com.smparkworld.feature.ui.search.items.userinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smparkworld.common.base.compose.SectionComposable
import com.smparkworld.common.base.framework.ActionHandler
import com.smparkworld.feature.search.R
import com.smparkworld.feature.ui.search.model.SearchAction

class UserInfoSectionComposable
    : SectionComposable<UserInfoUiModel, SearchAction> {

    @Composable
    override fun Section(
        modifier: Modifier,
        model: UserInfoUiModel,
        actionHandler: ActionHandler<SearchAction>
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.blue_100))
                .padding(horizontal = 10.dp, vertical = 12.dp),
            text = model.toString(),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 13.sp)
        )
    }

    @Composable
    @Preview
    fun SectionPreview() {
        Surface {
            Section(
                modifier = Modifier.fillMaxWidth(),
                model = UserInfoUiModel(
                    name = "John Doe",
                    description = "A software engineer with 5 years of experience.",
                    point = "123,000원",
                    coupon = "5개",
                    follower = "32,500명"
                ),
                actionHandler = {}
            )
        }
    }
}