package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EErrorContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl43
            AppTheme.STANDARD -> R.color.cstl43
            AppTheme.BLUE -> R.color.cbl43
            AppTheme.GREEN -> R.color.cgl43
            AppTheme.RED -> R.color.crl43
            AppTheme.NOTHING -> R.color.cnol43
        }
    }
}
