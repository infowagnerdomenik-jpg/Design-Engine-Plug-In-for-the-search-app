package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ESecondaryFixedDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd29
            AppTheme.STANDARD -> R.color.cstd29
            AppTheme.BLUE -> R.color.cbd29
            AppTheme.GREEN -> R.color.cgd29
            AppTheme.RED -> R.color.crd29
            AppTheme.NOTHING -> R.color.cnod29
        }
    }
}
