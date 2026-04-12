package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceDimLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl10
            AppTheme.STANDARD -> R.color.cstl10
            AppTheme.BLUE -> R.color.cbl10
            AppTheme.GREEN -> R.color.cgl10
            AppTheme.RED -> R.color.crl10
            AppTheme.NOTHING -> R.color.cnol10
        }
    }
}
