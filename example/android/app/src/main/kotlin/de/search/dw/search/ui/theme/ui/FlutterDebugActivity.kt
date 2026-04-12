package de.search.dw.search.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.design_engine.layer4_ui.DesignEngineUI
import de.search.dw.search.ui.theme.ui.screen.debug.FlutterDebugScreen

class FlutterDebugActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = DesignEngineUI.efbackground
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    FlutterDebugScreen()
                    
                    IconButton(
                        onClick = { finish() },
                        modifier = Modifier.statusBarsPadding().padding(start = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, 
                            contentDescription = "Back", 
                            tint = DesignEngineUI.efonbackground
                        )
                    }
                }
            }
        }
    }
}
