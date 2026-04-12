package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EOutlineDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd45
            AppTheme.STANDARD -> R.color.cstd45
            AppTheme.BLUE -> R.color.cbd45
            AppTheme.GREEN -> R.color.cgd45
            AppTheme.RED -> R.color.crd45
            AppTheme.NOTHING -> R.color.cnod45
        }
    }
}
