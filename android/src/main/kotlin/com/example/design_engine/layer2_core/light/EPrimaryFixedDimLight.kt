package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryFixedDimLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl21
            AppTheme.STANDARD -> R.color.cstl21
            AppTheme.BLUE -> R.color.cbl21
            AppTheme.GREEN -> R.color.cgl21
            AppTheme.RED -> R.color.crl21
            AppTheme.NOTHING -> R.color.cnol21
        }
    }
}
