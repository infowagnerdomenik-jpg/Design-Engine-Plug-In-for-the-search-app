package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EInverseSurfaceDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd7
            AppTheme.STANDARD -> R.color.cstd7
            AppTheme.BLUE -> R.color.cbd7
            AppTheme.GREEN -> R.color.cgd7
            AppTheme.RED -> R.color.crd7
            AppTheme.NOTHING -> R.color.cnod7
        }
    }
}
