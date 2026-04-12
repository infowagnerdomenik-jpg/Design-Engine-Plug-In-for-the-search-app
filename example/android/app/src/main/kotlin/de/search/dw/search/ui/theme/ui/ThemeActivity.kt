package de.search.dw.search.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.design_engine.layer4_ui.DesignEngineUI
import de.search.dw.search.ui.theme.ui.screen.ThemeControlScreen

class ThemeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = DesignEngineUI.ebackground
            ) {
                ThemeControlScreen()
            }
        }
    }
}
