package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnErrorContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl44
            AppTheme.STANDARD -> R.color.cstl44
            AppTheme.BLUE -> R.color.cbl44
            AppTheme.GREEN -> R.color.cgl44
            AppTheme.RED -> R.color.crl44
            AppTheme.NOTHING -> R.color.cnol44
        }
    }
}
