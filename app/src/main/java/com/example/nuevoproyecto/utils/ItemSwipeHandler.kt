package com.example.nuevoproyecto.overview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.nuevoproyecto.utils.ListAdapterEmptyItemSwipeable

class ItemSwipeHandler<T>(
    private val adapter: ListAdapterEmptyItemSwipeable<T, *>,
    private val onItemRemoved: ((item: T) -> Unit)? = null
): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun getSwipeDirs(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return if (!adapter.isItemSwipeable(viewHolder)) 0
        else super.getSwipeDirs(recyclerView, viewHolder)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        val item = adapter.removeItem(position) ?: return
        onItemRemoved?.invoke(item)
    }
}

