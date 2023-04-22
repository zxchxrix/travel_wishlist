package com.zacharia.travel_wishlist

import java.text.SimpleDateFormat
import java.util.*

class Place(val name: String, val dataAdded: Date = Date()) {
    fun formattedDate(): String {
        return SimpleDateFormat("EEE, d MMMM yyyy", Locale.getDefault()).format((dataAdded))
    }
}