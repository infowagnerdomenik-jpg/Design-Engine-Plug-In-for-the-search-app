package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnPrimaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd22
            AppTheme.STANDARD -> R.color.cstd22
            AppTheme.BLUE -> R.color.cbd22
            AppTheme.GREEN -> R.color.cgd22
            AppTheme.RED -> R.color.crd22
            AppTheme.NOTHING -> R.color.cnod22
        }
    }
}
