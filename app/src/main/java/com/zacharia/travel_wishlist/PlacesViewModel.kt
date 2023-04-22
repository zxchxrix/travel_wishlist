package com.zacharia.travel_wishlist

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*

const val TAG = "PLACES_VIEW_MODEL"
class PlacesViewModel: ViewModel() {

    private val placeNames = mutableListOf<Place>(Place("Auckland, NZ"), Place("Chicago, IL"))

    fun getPlaces(): List<Place> {
        return placeNames
    }

    fun addNewPlace(place: Place, position: Int? = null): Int {
        // check for duplicates
//        for (placeName in placeNames) {
//            if (placeName.uppercase() == placeName.uppercase()) {
//                return -1
//            }
//        }

        if (placeNames.any { placeName -> placeName.name.uppercase() == place.name.uppercase() }) {
            return -1
        }

        return if (position == null) {
            placeNames.add(place)
            placeNames.lastIndex
        } else {
            placeNames.add(position, place)
            position
        }
    }

    fun movePlace(from: Int, to: Int) {
        val place = placeNames.removeAt(from)
        placeNames.add(to, place)
        Log.d(TAG, placeNames.toString())
    }

    fun deletePlace(position: Int): Place {
        return placeNames.removeAt(position)
    }
}