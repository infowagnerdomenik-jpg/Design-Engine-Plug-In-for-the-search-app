package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOnTertiaryContainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd36
            AppTheme.STANDARD -> R.color.cstd36
            AppTheme.BLUE -> R.color.cbd36
            AppTheme.GREEN -> R.color.cgd36
            AppTheme.RED -> R.color.crd36
            AppTheme.NOTHING -> R.color.cnod36
        }
    }
}
