package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EErrorDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd41
            AppTheme.STANDARD -> R.color.cstd41
            AppTheme.BLUE -> R.color.cbd41
            AppTheme.GREEN -> R.color.cgd41
            AppTheme.RED -> R.color.crd41
            AppTheme.NOTHING -> R.color.cnod41
        }
    }
}
