package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EErprimarycontainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd18
            AppTheme.STANDARD -> R.color.cstd18
            AppTheme.BLUE -> R.color.cbd18
            AppTheme.GREEN -> R.color.cgd18
            AppTheme.RED -> R.color.crd18
            AppTheme.NOTHING -> R.color.cnod49
        }
    }
}
