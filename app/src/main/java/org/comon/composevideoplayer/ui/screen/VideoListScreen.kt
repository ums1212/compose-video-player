package org.comon.composevideoplayer.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.comon.composevideoplayer.model.SeriesInfo
import org.comon.composevideoplayer.ui.components.VideoListItem

val videoList = listOf(
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
    SeriesInfo(),
)

@Preview
@Composable
fun VideoListScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "목록", style = TextStyle(fontSize = 24.sp), modifier = Modifier.padding(12.dp))
        HorizontalDivider(Modifier.fillMaxWidth())
        LazyColumn {
            items(videoList){ series ->
                VideoListItem(series)
            }
        }
    }
}