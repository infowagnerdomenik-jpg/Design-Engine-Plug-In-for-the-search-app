package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryFixedDimDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd38
            AppTheme.STANDARD -> R.color.cstd38
            AppTheme.BLUE -> R.color.cbd38
            AppTheme.GREEN -> R.color.cgd38
            AppTheme.RED -> R.color.crd38
            AppTheme.NOTHING -> R.color.cnod38
        }
    }
}
