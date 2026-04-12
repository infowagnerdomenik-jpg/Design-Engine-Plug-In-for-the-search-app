package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceBrightDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd9
            AppTheme.STANDARD -> R.color.cstd9
            AppTheme.BLUE -> R.color.cbd9
            AppTheme.GREEN -> R.color.cgd9
            AppTheme.RED -> R.color.crd9
            AppTheme.NOTHING -> R.color.cnod9
        }
    }
}
