package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnSurfaceDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd4
            AppTheme.STANDARD -> R.color.cstd4
            AppTheme.BLUE -> R.color.cbd4
            AppTheme.GREEN -> R.color.cgd4
            AppTheme.RED -> R.color.crd4
            AppTheme.NOTHING -> R.color.cnod4
        }
    }
}
