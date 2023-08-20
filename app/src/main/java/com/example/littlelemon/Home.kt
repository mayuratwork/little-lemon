package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.AlmostBlack
import com.example.littlelemon.ui.theme.Gray
import com.example.littlelemon.ui.theme.Yellow

@Composable
@Preview
fun Home(navController: NavController? = null, menuItems: List<MenuItemRoom>? = null) {
    Column(modifier = Modifier.background(color = Color.White)) {

        Box {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.padding(start = 100.dp,
                    end = 100.dp, top = 18.dp, bottom = 18.dp)
            )

            Icon(
                Icons.Rounded.Face,
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
                    .clickable {
                        navController?.navigate(Profile.route)
                    },
                tint = Gray
            )
        }

        HeroSection(menuItems)
    }
}

@Composable
fun CategorySection(category: MutableState<String>) {
    Column(modifier = Modifier.padding(start = 18.dp, top = 18.dp, end = 18.dp)) {
        Text(
            textAlign = TextAlign.Right,
            text = "ORDER FOR DELIVERY!",
            color = AlmostBlack,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Row(modifier = Modifier.padding(top = 8.dp, bottom = 18.dp)) {
            Card(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = getCategoryBackgroundColor(category, "starters"),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                        .clickable(enabled = true) {
                            setCategoryValue(category, "starters")
                        },
                    text = "Starters",
                    textAlign = TextAlign.Right,
                    color = getCategoryTextColor(category, "starters"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }

            Card(
                modifier = Modifier.padding(start = 12.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = getCategoryBackgroundColor(category, "mains"),
            ) {
                Text(modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                    .clickable(enabled = true) {
                        setCategoryValue(category, "mains")
                    },
                    textAlign = TextAlign.Right,
                    text = "Mains",
                    color = getCategoryTextColor(category, "mains"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Card(
                modifier = Modifier.padding(start = 12.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = getCategoryBackgroundColor(category, "desserts"),
            ) {
                Text(modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                    .clickable(enabled = true) {
                        setCategoryValue(category, "desserts")
                    },
                    textAlign = TextAlign.Right,
                    text = "Desserts",
                    color = getCategoryTextColor(category, "desserts"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Card(
                modifier = Modifier.padding(start = 12.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = getCategoryBackgroundColor(category, "drinks"),
            ) {
                Text(modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                    .clickable(enabled = true) {
                        setCategoryValue(category, "drinks")
                    },
                    textAlign = TextAlign.Right,
                    text = "Drinks",
                    color = getCategoryTextColor(category, "drinks"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Divider(
            color = Gray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }
}

private fun getCategoryTextColor(category: MutableState<String>,
                                 categoryName: String): Color {
    return if (category.value.equals(categoryName, true))
        Color.LightGray else Gray
}

private fun getCategoryBackgroundColor(category: MutableState<String>,
                                       categoryName: String): Color {
    return if (category.value.equals(categoryName, true))
        Gray else Color.LightGray
}

private fun setCategoryValue(category: MutableState<String>, categoryName: String) {
    category.value = if (category.value.equals(categoryName, true)) "" else categoryName
}

@Composable
fun HeroSection(menuItems: List<MenuItemRoom>?) {
    val searchPhrase = remember { mutableStateOf("") }
    val category = remember { mutableStateOf("") }

    var displayMenuItems = if (searchPhrase.value.isNotEmpty())
        menuItems?.filter { it.title.contains(searchPhrase.value, true) } ?: emptyList()
    else menuItems ?: emptyList()

    if (category.value.isNotEmpty())
        displayMenuItems = displayMenuItems.filter { it.category.equals(category.value, true) }

    Column(modifier = Modifier
        .fillMaxWidth()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray)) {

            Column {
                Text(
                    modifier = Modifier.padding(start = 18.dp, top = 18.dp),
                    textAlign = TextAlign.Right,
                    text = "Little Lemon",
                    color = Yellow,
                    fontSize = 24.sp
                )


                Row {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(
                            modifier = Modifier.padding(start = 18.dp, top = 2.dp),
                            textAlign = TextAlign.Right,
                            text = "Chicago",
                            color = Color.White,
                            fontSize = 20.sp
                        )

                        Text(modifier = Modifier.padding(start = 18.dp, top = 18.dp),
                            textAlign = TextAlign.Start,
                            text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Image(
                        painterResource(id = R.drawable.hero_image),
                        contentScale = ContentScale.Crop,
                        contentDescription = "logo",
                        modifier = Modifier
                            .height(130.dp)
                            .weight(2f)
                            .padding(start = 8.dp, top = 18.dp, end = 18.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }

                // Add OutlinedTextField
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    value = searchPhrase.value,
                    placeholder = { Text(text = "Enter search phrase", color = Gray) },
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = 16.sp),
                    leadingIcon = {
                        Icon(Icons.Default.Search,
                            contentDescription = "Search",
                            tint = AlmostBlack)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = AlmostBlack,
                        backgroundColor = Color.White),

                    onValueChange = {
                        searchPhrase.value = it
                    })
            }
        }

        CategorySection(category)
        MenuItemsList(items = displayMenuItems)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItemsList(items: List<MenuItemRoom>) {
    if (items.isEmpty())
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            textAlign = TextAlign.Center,
            text = "No menu items found!",
            fontSize = 18.sp,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            color = AlmostBlack
        )

    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Column(modifier = Modifier
                        .padding(18.dp)
                        .weight(3f)) {
                        Text(
                            textAlign = TextAlign.Start,
                            text = menuItem.title,
                            fontSize = 18.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold,
                            color = AlmostBlack
                        )

                        Text(
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(top = 4.dp),
                            text = menuItem.description,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = Gray
                        )

                        Text(
                            modifier = Modifier.padding(top = 4.dp),
                            textAlign = TextAlign.Start,
                            text = "$%.2f".format(menuItem.price),
                            maxLines = 1,
                            fontSize = 18.sp,
                            color = Gray
                        )
                    }

                    GlideImage(
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "logo",
                        model = menuItem.image,
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 18.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                }

                Divider(color = Color.LightGray,
                    modifier = Modifier
                        .padding(start = 18.dp, end = 18.dp))
            }
        )
    }
}
