package com.example.design_engine.layer2_core.light
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnPrimaryContainerLight {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyl19
            AppTheme.STANDARD -> R.color.cstl19
            AppTheme.BLUE -> R.color.cbl19
            AppTheme.GREEN -> R.color.cgl19
            AppTheme.RED -> R.color.crl19
            AppTheme.NOTHING -> R.color.cnol19
        }
    }
}
