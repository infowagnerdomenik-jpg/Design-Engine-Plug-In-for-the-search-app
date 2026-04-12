package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnBackgroundLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl2
            AppTheme.STANDARD -> R.color.cstl2
            AppTheme.BLUE -> R.color.cbl2
            AppTheme.GREEN -> R.color.cgl2
            AppTheme.RED -> R.color.crl2
            AppTheme.NOTHING -> R.color.cnol2
        }
    }
}
