package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInverseOnSurfaceDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd8
            AppTheme.STANDARD -> R.color.cstd8
            AppTheme.BLUE -> R.color.cbd8
            AppTheme.GREEN -> R.color.cgd8
            AppTheme.RED -> R.color.crd8
            AppTheme.NOTHING -> R.color.cnod8
        }
    }
}
