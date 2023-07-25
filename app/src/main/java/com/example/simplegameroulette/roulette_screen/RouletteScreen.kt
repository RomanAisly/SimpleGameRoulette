package com.example.simplegameroulette.roulette_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplegameroulette.R
import com.example.simplegameroulette.ui.theme.red
import com.example.simplegameroulette.ui.theme.white
import com.example.simplegameroulette.utils.NumberUtil
import kotlin.math.roundToInt

@Composable
fun RouletteScreen() {

    var rotationValue by remember {
        mutableStateOf(0f)
    }

    var nums by remember {
        mutableStateOf(0)
    }

    val roundAnim: Float by animateFloatAsState(
        targetValue = rotationValue,
        animationSpec = tween(durationMillis = 2500),
        finishedListener = {
            val index = (360f - (it % 360)) / (360f / NumberUtil.numsOfRoulette.size)
            nums = NumberUtil.numsOfRoulette[index.roundToInt()]
        }
    )


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .wrapContentWidth()
                .wrapContentHeight(),
            text = nums.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = red
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.roulette),
                contentDescription = stringResource(R.string.cont_desc_roulette),
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(roundAnim)
            )
            Image(
                painter = painterResource(id = R.drawable.pointer),
                contentDescription = stringResource(R.string.cont_desc_pointer),
                modifier = Modifier.fillMaxSize()
            )
        }
        Button(
            onClick = { rotationValue = (720..1080).random().toFloat() + roundAnim },
            colors = ButtonDefaults.buttonColors(red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Start",
                color = white
            )
        }
    }
}