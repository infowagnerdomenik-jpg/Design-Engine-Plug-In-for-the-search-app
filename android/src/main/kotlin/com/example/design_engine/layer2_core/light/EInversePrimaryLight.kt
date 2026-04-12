package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInversePrimaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl24
            AppTheme.STANDARD -> R.color.cstl24
            AppTheme.BLUE -> R.color.cbl24
            AppTheme.GREEN -> R.color.cgl24
            AppTheme.RED -> R.color.crl24
            AppTheme.NOTHING -> R.color.cnol24
        }
    }
}
