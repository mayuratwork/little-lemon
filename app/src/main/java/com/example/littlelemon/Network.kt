package com.example.littlelemon

import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val category: String,
    val price: String) {

    fun toMenuItemRoom() = MenuItemRoom(id, title, description, image, category, price.toDouble())
}
