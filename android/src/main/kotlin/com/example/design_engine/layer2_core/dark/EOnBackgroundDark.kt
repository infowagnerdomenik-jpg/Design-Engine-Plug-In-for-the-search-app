package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnBackgroundDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd2
            AppTheme.STANDARD -> R.color.cstd2
            AppTheme.BLUE -> R.color.cbd2
            AppTheme.GREEN -> R.color.cgd2
            AppTheme.RED -> R.color.crd2
            AppTheme.NOTHING -> R.color.cnod2
        }
    }
}
