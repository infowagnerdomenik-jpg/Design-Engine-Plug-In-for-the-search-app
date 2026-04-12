package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl16
            AppTheme.STANDARD -> R.color.cstl16
            AppTheme.BLUE -> R.color.cbl16
            AppTheme.GREEN -> R.color.cgl16
            AppTheme.RED -> R.color.crl16
            AppTheme.NOTHING -> R.color.cnol16
        }
    }
}
