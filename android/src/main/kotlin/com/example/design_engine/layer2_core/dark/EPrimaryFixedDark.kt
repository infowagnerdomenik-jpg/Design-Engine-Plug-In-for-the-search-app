package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd20
            AppTheme.STANDARD -> R.color.cstd20
            AppTheme.BLUE -> R.color.cbd20
            AppTheme.GREEN -> R.color.cgd20
            AppTheme.RED -> R.color.crd20
            AppTheme.NOTHING -> R.color.cnod20
        }
    }
}
