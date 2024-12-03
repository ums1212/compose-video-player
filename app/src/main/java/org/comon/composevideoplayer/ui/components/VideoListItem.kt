package org.comon.composevideoplayer.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import org.comon.composevideoplayer.R
import org.comon.composevideoplayer.model.SeriesInfo

@Composable
fun VideoListItem(series: SeriesInfo){
    Column(
        Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .clickable {  }
    ) {
        Row(
            Modifier.padding(12.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(128.dp).padding(end = 16.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(series.photoUrl)
                    .error(R.drawable.logo)
                    .crossfade(true)
                    .build(),
                contentDescription = "작품 이미지",
                contentScale = ContentScale.FillBounds
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = series.title, style = TextStyle(fontSize = 24.sp))
                Text(text = series.genres.joinToString(","), style = TextStyle(fontSize = 16.sp))
            }

        }
        HorizontalDivider()
    }
}