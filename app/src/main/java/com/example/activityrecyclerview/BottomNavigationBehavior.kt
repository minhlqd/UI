package com.example.activityrecyclerview

import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationBehavior : CoordinatorLayout.Behavior<BottomNavigationView>() {
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: BottomNavigationView,
        dependency: View
    ): Boolean {
        return dependency !is FrameLayout
    }
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomNavigationView,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        if (dy<0) {
            showBottomNavigationView(child)
        } else if (dy > 0){
            hideBottomNavigationView(child)
        }
    }

    private fun hideBottomNavigationView(child: BottomNavigationView) {
        child.animate().translationY(child.height.toFloat())
    }

    private fun showBottomNavigationView(child: BottomNavigationView) {
        child.animate().translationY(0f)
    }
}

