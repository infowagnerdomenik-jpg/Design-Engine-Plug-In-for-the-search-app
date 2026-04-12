package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryFixedLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl37
            AppTheme.STANDARD -> R.color.cstl37
            AppTheme.BLUE -> R.color.cbl37
            AppTheme.GREEN -> R.color.cgl37
            AppTheme.RED -> R.color.crl37
            AppTheme.NOTHING -> R.color.cnol37
        }
    }
}
