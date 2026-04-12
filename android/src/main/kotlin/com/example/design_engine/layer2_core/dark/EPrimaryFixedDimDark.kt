package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryFixedDimDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd21
            AppTheme.STANDARD -> R.color.cstd21
            AppTheme.BLUE -> R.color.cbd21
            AppTheme.GREEN -> R.color.cgd21
            AppTheme.RED -> R.color.crd21
            AppTheme.NOTHING -> R.color.cnod21
        }
    }
}
