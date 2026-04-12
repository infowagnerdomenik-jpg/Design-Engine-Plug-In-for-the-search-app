package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOutlineVariantDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd46
            AppTheme.STANDARD -> R.color.cstd46
            AppTheme.BLUE -> R.color.cbd46
            AppTheme.GREEN -> R.color.cgd46
            AppTheme.RED -> R.color.crd46
            AppTheme.NOTHING -> R.color.cnod46
        }
    }
}
