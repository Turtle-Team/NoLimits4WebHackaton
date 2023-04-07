package com.lyadsky.nolimits4webapp.android.features.mainNavigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.lyadsky.nolimits4webapp.android.R
import com.lyadsky.nolimits4webapp.common.navigation.ScreenRoute

data class BottomNavigationItem(
    val route: ScreenRoute,
    val iconId: Int,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        ScreenRoute.Main,
        R.drawable.ic_home,
        "",
    ),
    BottomNavigationItem(
        ScreenRoute.Catalog,
        R.drawable.ic_catalog,
        ""
    ),
    BottomNavigationItem(
        ScreenRoute.Profile,
        R.drawable.ic_profile,
        ""
    ),
)

@Composable
fun BottomBar(
    currentRoute: ScreenRoute,
    onButtonClick: (ScreenRoute) -> Unit
) {
    BottomNavigation(
        modifier = Modifier
            .navigationBarsPadding(),
        backgroundColor = Color.White
    ) {
        Row {
            bottomNavigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = item.iconContentDescription,
                            tint = if (currentRoute == item.route) Color(0xFFFB7FA4) else Color(0xFF474992)
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        onButtonClick(item.route)
                    },
                    selectedContentColor = Color(0xFFFB7FA4),
                    unselectedContentColor = Color(0xFF474992)
                )
            }
        }
    }
}
