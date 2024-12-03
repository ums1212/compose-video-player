package org.comon.composevideoplayer.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.comon.composevideoplayer.R
import org.comon.composevideoplayer.common.VPPreferences

class SettingScreenParameterProvider: PreviewParameterProvider<MutableState<Boolean>> {
    override val values = sequenceOf(mutableStateOf(true), mutableStateOf(false))
}

@Preview(showBackground = true)
@Composable
fun SettingScreenPreview(
    @PreviewParameter(SettingScreenParameterProvider::class) darkThemeState: MutableState<Boolean>
){
    SettingScreen(darkThemeState)
}

@Composable
fun SettingScreen(
    darkThemeState: MutableState<Boolean>,
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 12.dp)
    ) {
        Text(
            text = stringResource(R.string.setting_screen_name),
            fontSize = 24.sp,
        )
        Spacer(Modifier.padding(vertical = 12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.dark_mode_switch_name),
                fontSize = 20.sp,
            )
            Switch(
                checked = darkThemeState.value,
                onCheckedChange = {
                    darkThemeState.value = it
                    VPPreferences.setDarkTheme(it)
                }
            )
        }
    }
}