package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl36
            AppTheme.STANDARD -> R.color.cstl36
            AppTheme.BLUE -> R.color.cbl36
            AppTheme.GREEN -> R.color.cgl36
            AppTheme.RED -> R.color.crl36
            AppTheme.NOTHING -> R.color.cnol36
        }
    }
}
