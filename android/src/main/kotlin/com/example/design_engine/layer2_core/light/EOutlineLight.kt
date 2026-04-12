package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOutlineLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl45
            AppTheme.STANDARD -> R.color.cstl45
            AppTheme.BLUE -> R.color.cbl45
            AppTheme.GREEN -> R.color.cgl45
            AppTheme.RED -> R.color.crl45
            AppTheme.NOTHING -> R.color.cnol45
        }
    }
}
