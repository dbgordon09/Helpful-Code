package com.avochoc.liquimoly.utilities

import android.graphics.Color
import android.support.constraint.solver.widgets.WidgetContainer
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.facebook.shimmer.ShimmerFrameLayout

object ShimmerViewHelper {
    fun startShimmer(shimmerLayout: ShimmerFrameLayout) {
        shimmerLayout.apply {
            alpha = 0.2f
            greyBackground(this, true)
            startShimmer()
        }
    }

    fun stopShimmer(shimmerLayout: ShimmerFrameLayout) {
        shimmerLayout.apply {
            alpha = 1f
            greyBackground(this, false)
            stopShimmer()
        }
    }

    private fun greyBackground(v: View, forward: Boolean) {
        if (v !is ViewGroup) {
            if (forward){
                if(v !is Button && v.tag != 1)
                    v.setBackgroundColor(Color.LTGRAY)
            }
            else{
                if(v !is Button && v.tag != 1) {
                    v.setBackgroundColor(Color.TRANSPARENT)
                    v.setBackgroundResource(0)
                }
            }
            if (v is TextView)
                if(v !is Button) {
                    v.text = ""
                }
            return
        }

        for (i in 0 until v.childCount) {
            val child = v.getChildAt(i)
            //Do not add any parents, just add child elements
            greyBackground(child, forward)
        }
        return
    }
}