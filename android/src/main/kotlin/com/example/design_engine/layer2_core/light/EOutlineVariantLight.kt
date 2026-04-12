package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOutlineVariantLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl46
            AppTheme.STANDARD -> R.color.cstl46
            AppTheme.BLUE -> R.color.cbl46
            AppTheme.GREEN -> R.color.cgl46
            AppTheme.RED -> R.color.crl46
            AppTheme.NOTHING -> R.color.cnol46
        }
    }
}
