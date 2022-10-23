package kr.duckcade.kockkock.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kr.duckcade.kockkock.R
import kr.duckcade.kockkock.ui.components.StandardTextField
import kr.duckcade.kockkock.ui.theme.SpaceLarge

@Composable
fun SearchScreen(navController: NavController) {

    val recentSearch = listOf(
        "세명대",
        "의림지"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .clickable {

            }
    ) {
        Column(modifier = Modifier
            .fillMaxSize().background(Color.White)
            .padding(SpaceLarge)
        ) {
            StandardTextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    ""
                },
                hint = stringResource(id = R.string.search_hint)
            )
        }
        Spacer(modifier = Modifier.height(SpaceLarge))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(recentSearch) {
                Text(text = it)
            }
        }
        Column() {
            Text(text = "히스토리 삭제")
        }
    }
}