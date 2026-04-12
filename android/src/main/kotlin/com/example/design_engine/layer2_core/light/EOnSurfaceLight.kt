package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSurfaceLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl4
            AppTheme.STANDARD -> R.color.cstl4
            AppTheme.BLUE -> R.color.cbl4
            AppTheme.GREEN -> R.color.cgl4
            AppTheme.RED -> R.color.crl4
            AppTheme.NOTHING -> R.color.cnol4
        }
    }
}
