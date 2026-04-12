package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInverseOnSurfaceLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl8
            AppTheme.STANDARD -> R.color.cstl8
            AppTheme.BLUE -> R.color.cbl8
            AppTheme.GREEN -> R.color.cgl8
            AppTheme.RED -> R.color.crl8
            AppTheme.NOTHING -> R.color.cnol8
        }
    }
}
