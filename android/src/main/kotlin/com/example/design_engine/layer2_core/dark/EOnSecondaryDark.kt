package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSecondaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd26
            AppTheme.STANDARD -> R.color.cstd26
            AppTheme.BLUE -> R.color.cbd26
            AppTheme.GREEN -> R.color.cgd26
            AppTheme.RED -> R.color.crd26
            AppTheme.NOTHING -> R.color.cnod26
        }
    }
}
