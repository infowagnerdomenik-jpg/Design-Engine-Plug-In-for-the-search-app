package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnPrimaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl17
            AppTheme.STANDARD -> R.color.cstl17
            AppTheme.BLUE -> R.color.cbl17
            AppTheme.GREEN -> R.color.cgl17
            AppTheme.RED -> R.color.crl17
            AppTheme.NOTHING -> R.color.cnol17
        }
    }
}
