package com.worekwojciech.nimdokai.itemtouchhelper

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SwipeCallback : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {


    override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder) =
        false

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        active: Boolean
    ) {

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

            // SWIPE LEFT
            if (dX < 0) {

                // When transitionX is multiply by ~0.4f or lower value, view is displayed properly.
                // Otherwise when user will "tap" the background will be shown.
                // On the other hand if we do "proper" swipe to escape view will be displayed properly.
                val transitionX = 0.7f * dX
                super.onChildDraw(
                    canvas,
                    recyclerView,
                    viewHolder,
                    transitionX,
                    dY,
                    actionState,
                    active
                )
            }
        }
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
    }
}