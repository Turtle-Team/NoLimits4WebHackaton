package com.lyadsky.nolimits4webapp.android.features.views.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyadsky.nolimits4webapp.android.font

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Int? = 330,
    height: Int? = 50,
    color: Color? = Color(0xFF9094FB),
    onClick: () -> Unit?,
) {
    Button(
        modifier = Modifier
            .width(width!!.dp)
            .clip(RoundedCornerShape(15.dp))
            .height(height!!.dp).then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color!!
        )
    ) {
        Text(
            text = text, style = TextStyle(
                fontFamily = font,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            ), textAlign = TextAlign.Center
        )
    }
}
