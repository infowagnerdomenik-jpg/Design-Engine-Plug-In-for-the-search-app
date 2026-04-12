package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EBackgroundDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd1
            AppTheme.STANDARD -> R.color.cstd1
            AppTheme.BLUE -> R.color.cbd1
            AppTheme.GREEN -> R.color.cgd1
            AppTheme.RED -> R.color.crd1
            AppTheme.NOTHING -> R.color.cnod1
        }
    }
}
