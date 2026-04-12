package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceDimDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd10
            AppTheme.STANDARD -> R.color.cstd10
            AppTheme.BLUE -> R.color.cbd10
            AppTheme.GREEN -> R.color.cgd10
            AppTheme.RED -> R.color.crd10
            AppTheme.NOTHING -> R.color.cnod10
        }
    }
}
