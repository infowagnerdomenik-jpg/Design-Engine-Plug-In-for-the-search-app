package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd3
            AppTheme.STANDARD -> R.color.cstd3
            AppTheme.BLUE -> R.color.cbd3
            AppTheme.GREEN -> R.color.cgd3
            AppTheme.RED -> R.color.crd3
            AppTheme.NOTHING -> R.color.cnod3
        }
    }
}
