package com.lyadsky.nolimits4webapp.android.features.views.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.android.features.catalog.layouts.ChapterItem
import com.lyadsky.nolimits4webapp.android.font

@Composable
fun CommonTopBar(title: String, onBackClick: () -> Unit) {
    Row(modifier = Modifier.padding(start = 25.dp, top = 50.dp, bottom = 10.dp)) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .width(26.dp)
                .height(22.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), contentDescription = "",
                tint = Color(0xFF474992),
            )
        }
        Text(
            text = title,
            modifier = Modifier.padding(start = 20.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = font,
                fontWeight = FontWeight(700),
                color = Color(0xFF474992)
            )
        )
    }
}
