package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl35
            AppTheme.STANDARD -> R.color.cstl35
            AppTheme.BLUE -> R.color.cbl35
            AppTheme.GREEN -> R.color.cgl35
            AppTheme.RED -> R.color.crl35
            AppTheme.NOTHING -> R.color.cnol35
        }
    }
}
