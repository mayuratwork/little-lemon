package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val menuItemUrl =
        "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
    lateinit var mContext: Context
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContent {
            LittleLemonTheme {
                // add databaseMenuItems code here
                val databaseMenuItems = database.menuItemDao().getAll().observeAsState()

                // add orderMenuItems variable here
                val orderMenuItems = remember { mutableStateOf(false) }

                // add menuItems variable here
                var menuItems = if (orderMenuItems.value)
                    databaseMenuItems.value?.sortedBy { it.title } else databaseMenuItems.value

                Column {
//                    Image(
//                        painter = painterResource(id = R.drawable.logo),
//                        contentDescription = "logo",
//                        modifier = Modifier.padding(50.dp)
//                    )
//
//                    // add Button code here
//                    Button(
//                        modifier = Modifier.padding(18.dp),
//                        colors = ButtonDefaults.buttonColors(backgroundColor = Yellow,
//                            contentColor = Gray),
//
//                        onClick = {
//                            lifecycleScope.launch {
//                                orderMenuItems.value = true
//                            }
//                        }
//                    ) {
//                        Text(text = "Tap to order by name")
//                    }
//
//                    // add searchPhrase variable here
//                    val searchPhrase = remember { mutableStateOf("") }
//
//                    // Add OutlinedTextField
//                    OutlinedTextField(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(start = 50.dp, end = 50.dp),
//                        value = searchPhrase.value,
//                        label = { Text(text = "Search", color = Yellow) },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            focusedBorderColor = Yellow,
//                            textColor = Gray,
//                            unfocusedBorderColor = Gray),
//
//                        onValueChange = {
//                            searchPhrase.value = it
//                        })
//
//                    // add is not empty check here
//                    if (searchPhrase.value.isNotEmpty())
//                        menuItems =
//                            menuItems?.filter { it.title.contains(searchPhrase.value, true) }
//
//                    MenuItemsList(items = menuItems ?: emptyList())

                    MyNavigation(menuItems)
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                val menuItemsList = fetchMenu()
                saveMenuToDatabase(menuItemsList)
            }
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val response: MenuNetwork = httpClient.get(menuItemUrl).body()
        return response.menu
    }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
    }
}

@Composable
fun MyNavigation(menuItems: List<MenuItemRoom>?) {
    val navController = rememberNavController()
    val sharedPref = LocalContext.current.getSharedPreferences(
        stringResource(R.string.little_lemon_sp), Context.MODE_PRIVATE)
    val firstName = sharedPref.getString("firstName", null)
    val startDestination = if (firstName == null) OnBoarding.route else Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(OnBoarding.route) {
            OnBoarding(navController = navController)
        }

        composable(Home.route) {
            Home(navController = navController, menuItems)
        }

        composable(Profile.route) {
            Profile(navController = navController)
        }
    }
}
