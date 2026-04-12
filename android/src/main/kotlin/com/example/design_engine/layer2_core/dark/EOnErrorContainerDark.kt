package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnErrorContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd44
            AppTheme.STANDARD -> R.color.cstd44
            AppTheme.BLUE -> R.color.cbd44
            AppTheme.GREEN -> R.color.cgd44
            AppTheme.RED -> R.color.crd44
            AppTheme.NOTHING -> R.color.cnod44
        }
    }
}
