package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryFixedDimLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl38
            AppTheme.STANDARD -> R.color.cstl38
            AppTheme.BLUE -> R.color.cbl38
            AppTheme.GREEN -> R.color.cgl38
            AppTheme.RED -> R.color.crl38
            AppTheme.NOTHING -> R.color.cnol38
        }
    }
}
