package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EErrorLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl41
            AppTheme.STANDARD -> R.color.cstl41
            AppTheme.BLUE -> R.color.cbl41
            AppTheme.GREEN -> R.color.cgl41
            AppTheme.RED -> R.color.crl41
            AppTheme.NOTHING -> R.color.cnol41
        }
    }
}
