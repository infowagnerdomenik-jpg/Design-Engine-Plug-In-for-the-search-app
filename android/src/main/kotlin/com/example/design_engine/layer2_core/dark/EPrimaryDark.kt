package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EPrimaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd16
            AppTheme.STANDARD -> R.color.cstd16
            AppTheme.BLUE -> R.color.cbd16
            AppTheme.GREEN -> R.color.cgd16
            AppTheme.RED -> R.color.crd16
            AppTheme.NOTHING -> R.color.cnod16
        }
    }
}
