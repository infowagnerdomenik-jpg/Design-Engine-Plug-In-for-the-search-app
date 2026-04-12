package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EBackgroundLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl1
            AppTheme.STANDARD -> R.color.cstl1
            AppTheme.BLUE -> R.color.cbl1
            AppTheme.GREEN -> R.color.cgl1
            AppTheme.RED -> R.color.crl1
            AppTheme.NOTHING -> R.color.cnol1
        }
    }
}
