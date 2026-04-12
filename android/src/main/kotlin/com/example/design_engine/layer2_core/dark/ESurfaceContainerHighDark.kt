package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESurfaceContainerHighDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd12
            AppTheme.STANDARD -> R.color.cstd12
            AppTheme.BLUE -> R.color.cbd12
            AppTheme.GREEN -> R.color.cgd12
            AppTheme.RED -> R.color.crd12
            AppTheme.NOTHING -> R.color.cnod12
        }
    }
}
