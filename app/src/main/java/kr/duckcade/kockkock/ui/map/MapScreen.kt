package kr.duckcade.kockkock.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import kotlinx.coroutines.launch
import kr.duckcade.kockkock.R
import kr.duckcade.kockkock.app.domain.model.BottomNavItem
import kr.duckcade.kockkock.ui.components.StandardBottomNavItem
import kr.duckcade.kockkock.ui.drawer.DrawerBody
import kr.duckcade.kockkock.ui.drawer.DrawerHeader
import kr.duckcade.kockkock.ui.drawer.MenuItem
import kr.duckcade.kockkock.ui.theme.LightGray
import kr.duckcade.kockkock.ui.theme.SpaceLarge
import kr.duckcade.kockkock.ui.theme.SpaceSmall
import kr.duckcade.kockkock.ui.theme.Yellow
import kr.duckcade.kockkock.ui.utils.Screen

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(navController: NavHostController) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                backgroundColor = Yellow,
                elevation = 5.dp
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = SpaceSmall,
                            end = SpaceSmall,
                            top = SpaceLarge,
                        )
                        .height(45.dp),
                    backgroundColor = Color.White,
                    elevation = 5.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.drawer_icon),
                                contentDescription = "Toggle drawer",
                                tint = Color.Unspecified,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(Screen.SearchScreen.route)
                                },
                        ) {
                            Text(
                                text = "체육관",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = LightGray
                            )

                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.search),
                            tint = Yellow,
                            contentDescription = "Search",
                        )
                    }

                }
            }

        },

        bottomBar = {
            BottomBar(navController)
        },


        scaffoldState = scaffoldState,
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            Column(modifier = Modifier.background(Color.White)) {
                DrawerHeader()
                DrawerBody(items = listOf(
                    MenuItem(
                        id = "test1",
                        title = "장소 찾기",
                        contentDescription = "Go th home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "test1",
                        title = "스토어",
                        contentDescription = "Go th home screen",
                        icon = Icons.Default.Add
                    )

                ), onItemClick = {
                    println("click on ${it.title}")
                })
            }
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Color.White,
                onClick = { /*TODO*/ },
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp)
                        .clip(CircleShape)
                        .background(Yellow)
                )
            }
        },
    ) {
        NaverMap(
            modifier = Modifier
                .fillMaxSize()
                .clickable { },
        ) {
            Marker(
                state = MarkerState(position = LatLng(37.532600, 127.024612)),
                captionText = "Marker in Seoul"
            )
            Marker(
                state = MarkerState(position = LatLng(37.390791, 127.096306)),
                captionText = "Marker in Pangyo"
            )
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            title = "즐겨찾기",
            icon = Icons.Outlined.Email,
            contentDescription = "Image",
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            title = "사진첩",
            icon = Icons.Outlined.Email,
            contentDescription = "Image",
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            title = "내글읽기",
            icon = Icons.Outlined.Email,
            contentDescription = "Image",
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            title = "내정보",
            icon = Icons.Outlined.Person,
            contentDescription = "Profile",
        ),
    ),
) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
            .height(90.dp),
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        BottomNavigation {
            bottomNavItems.forEach { bottomNavItem ->
                StandardBottomNavItem(
                    title = bottomNavItem.title,
                    icon = bottomNavItem.icon,
                    contentDescription = bottomNavItem.contentDescription,
                    selected = bottomNavItem.route == navController.currentDestination?.route,
                    enabled = bottomNavItem.icon != null
                ) {
                   if (navController.currentDestination?.route != bottomNavItem.route) {
                        navController.navigate(bottomNavItem.route)
                    }
                }
            }
        }
    }

}