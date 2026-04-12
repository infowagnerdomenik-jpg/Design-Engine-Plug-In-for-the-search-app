package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd34
            AppTheme.STANDARD -> R.color.cstd34
            AppTheme.BLUE -> R.color.cbd34
            AppTheme.GREEN -> R.color.cgd34
            AppTheme.RED -> R.color.crd34
            AppTheme.NOTHING -> R.color.cnod34
        }
    }
}
