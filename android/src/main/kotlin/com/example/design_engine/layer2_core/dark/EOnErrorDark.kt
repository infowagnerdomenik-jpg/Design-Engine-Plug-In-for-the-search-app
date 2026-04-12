package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnErrorDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd42
            AppTheme.STANDARD -> R.color.cstd42
            AppTheme.BLUE -> R.color.cbd42
            AppTheme.GREEN -> R.color.cgd42
            AppTheme.RED -> R.color.crd42
            AppTheme.NOTHING -> R.color.cnod42
        }
    }
}
