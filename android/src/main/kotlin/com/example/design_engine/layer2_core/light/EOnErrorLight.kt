package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnErrorLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl42
            AppTheme.STANDARD -> R.color.cstl42
            AppTheme.BLUE -> R.color.cbl42
            AppTheme.GREEN -> R.color.cgl42
            AppTheme.RED -> R.color.crl42
            AppTheme.NOTHING -> R.color.cnol42
        }
    }
}
