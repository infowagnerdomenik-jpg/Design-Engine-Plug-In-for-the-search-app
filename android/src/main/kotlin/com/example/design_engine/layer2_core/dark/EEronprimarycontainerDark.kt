package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object EEronprimarycontainerDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd19
            AppTheme.STANDARD -> R.color.cstd19
            AppTheme.BLUE -> R.color.cbd19
            AppTheme.GREEN -> R.color.cgd19
            AppTheme.RED -> R.color.crd19
            AppTheme.NOTHING -> R.color.cnod50
        }
    }
}
