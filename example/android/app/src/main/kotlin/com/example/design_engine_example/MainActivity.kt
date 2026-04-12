package com.example.design_engine_example

import android.os.Bundle // <--- WICHTIG!
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import de.search.dw.search.ui.theme.ui.ThemeActivity
import de.search.dw.search.ui.theme.ui.FlutterDebugActivity
import com.example.design_engine.layer3_logic.DesignEngineController // <--- WICHTIG!

class MainActivity: FlutterActivity() {
    private val CHANNEL = "design_engine_showcase"

    // --- DIESER BLOCK FEHLTE BEREITS: Er weckt das Gedächtnis auf! ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DesignEngineController.init(this.applicationContext)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "openAndroidEngine" -> {
                    val intent = Intent(this, ThemeActivity::class.java)
                    startActivity(intent)
                    result.success(null)
                }
                "openFlutterDebug" -> {
                    val intent = Intent(this, FlutterDebugActivity::class.java)
                    startActivity(intent)
                    result.success(null)
                }
                else -> {
                    result.notImplemented()
                }
            }
        }
    }
}
