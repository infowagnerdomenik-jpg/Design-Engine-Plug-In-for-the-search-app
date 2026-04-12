package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl33
            AppTheme.STANDARD -> R.color.cstl33
            AppTheme.BLUE -> R.color.cbl33
            AppTheme.GREEN -> R.color.cgl33
            AppTheme.RED -> R.color.crl33
            AppTheme.NOTHING -> R.color.cnol33
        }
    }
}
