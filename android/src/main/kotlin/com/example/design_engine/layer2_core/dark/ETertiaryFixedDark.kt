package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd37
            AppTheme.STANDARD -> R.color.cstd37
            AppTheme.BLUE -> R.color.cbd37
            AppTheme.GREEN -> R.color.cgd37
            AppTheme.RED -> R.color.crd37
            AppTheme.NOTHING -> R.color.cnod37
        }
    }
}
