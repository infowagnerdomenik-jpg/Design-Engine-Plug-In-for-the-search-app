package com.example.design_engine.layer2_core.dark
import com.example.design_engine.R
import com.example.design_engine.layer3_logic.AppTheme
object ETertiaryDark {
    fun getResId(activeTheme: AppTheme): Int {
        return when (activeTheme) {
            AppTheme.SYSTEM -> R.string.csyd33
            AppTheme.STANDARD -> R.color.cstd33
            AppTheme.BLUE -> R.color.cbd33
            AppTheme.GREEN -> R.color.cgd33
            AppTheme.RED -> R.color.crd33
            AppTheme.NOTHING -> R.color.cnod33
        }
    }
}
