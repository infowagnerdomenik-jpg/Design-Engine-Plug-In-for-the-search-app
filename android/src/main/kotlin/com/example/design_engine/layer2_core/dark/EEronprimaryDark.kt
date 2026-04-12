package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EEronprimaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd17
            AppTheme.STANDARD -> R.color.cstd17
            AppTheme.BLUE -> R.color.cbd17
            AppTheme.GREEN -> R.color.cgd17
            AppTheme.RED -> R.color.crd17
            AppTheme.NOTHING -> R.color.cnod48
        }
    }
}
