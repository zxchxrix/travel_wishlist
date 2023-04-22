package com.zacharia.travel_wishlist

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface OnDataChangedListener {
    fun onListItemMoved(from: Int, to: Int) // move up and down in list
    fun onListItemDeleted(position: Int)
}

class OnListItemSwipeListener(val onDataChangedListener: OnDataChangedListener):
    ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN, // to reorder
    ItemTouchHelper.RIGHT // to delete
) {
    override fun onMove(  // moving up and down
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        onDataChangedListener.onListItemMoved(fromPosition, toPosition)
        return true
    }

    // swipe left and right
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT) {
            onDataChangedListener.onListItemDeleted(viewHolder.adapterPosition)
        }
    }

}