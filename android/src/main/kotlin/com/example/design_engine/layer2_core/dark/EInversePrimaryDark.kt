package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInversePrimaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd24
            AppTheme.STANDARD -> R.color.cstd24
            AppTheme.BLUE -> R.color.cbd24
            AppTheme.GREEN -> R.color.cgd24
            AppTheme.RED -> R.color.crd24
            AppTheme.NOTHING -> R.color.cnod24
        }
    }
}
