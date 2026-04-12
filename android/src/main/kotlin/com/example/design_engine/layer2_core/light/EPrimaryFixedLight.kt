package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl20
            AppTheme.STANDARD -> R.color.cstl20
            AppTheme.BLUE -> R.color.cbl20
            AppTheme.GREEN -> R.color.cgl20
            AppTheme.RED -> R.color.crl20
            AppTheme.NOTHING -> R.color.cnol20
        }
    }
}
