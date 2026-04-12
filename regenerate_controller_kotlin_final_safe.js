const fs = require('fs');

const tokens = [
    "Background", "On Background", "Surface", "On Surface", "Surface Variant",
    "On Surface Variant", "Inverse Surface", "Inverse On Surface", "Surface Bright",
    "Surface Dim", "Surface Container Low", "Surface Container High",
    "Surface Container Lowest", "Surface Container Highest", "Surface Container",
    "Primary", "On Primary", "Primary Container", "On Primary Container",
    "Primary Fixed", "Primary Fixed Dim", "On Primary Fixed", "On Primary Fixed Variant",
    "Inverse Primary", "Secondary", "On Secondary", "Secondary Container",
    "On Secondary Container", "Secondary Fixed", "Secondary Fixed Dim",
    "On Secondary Fixed", "On Secondary Fixed Variant", "Tertiary", "On Tertiary",
    "Tertiary Container", "On Tertiary Container", "Tertiary Fixed", "Tertiary Fixed Dim",
    "On Tertiary Fixed", "On Tertiary Fixed Variant", "Error", "On Error",
    "Error Container", "On Error Container", "Outline", "Outline Variant",
    "erPrimary", "erOnPrimary", "erPrimaryContainer", "erOnPrimaryContainer"
];

function getFullClassName(token, suffix) {
    let base = "";
    if (token.startsWith("er")) {
        base = "EEr" + token.slice(2).toLowerCase();
    } else {
        base = "E" + token.split(" ").map(word => word.charAt(0).toUpperCase() + word.slice(1)).join("");
    }
    return base + (suffix.charAt(0).toUpperCase() + suffix.slice(1));
}

function formatGetterName(token) {
    return "e" + token.toLowerCase().replace(/ /g, "");
}

const controllerPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer3_logic/DesignEngineController.kt";

let content = `package com.example.design_engine.layer3_logic

import android.os.Build
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

`;

tokens.forEach(token => {
    content += `import com.example.design_engine.layer2_core.light.${getFullClassName(token, 'light')}\n`;
    content += `import com.example.design_engine.layer2_core.dark.${getFullClassName(token, 'dark')}\n`;
});

content += `
enum class AppTheme { SYSTEM, STANDARD, BLUE, GREEN, RED, NOTHING }
enum class ThemeMode { SYSTEM, LIGHT, DARK }

object DesignEngineController {
    private var _currentTheme by mutableStateOf(AppTheme.BLUE)
    val currentTheme: AppTheme get() = _currentTheme

    private var _themeMode by mutableStateOf(ThemeMode.SYSTEM)
    val themeMode: ThemeMode get() = _themeMode

    private var _isAmoled by mutableStateOf(false)
    val isAmoled: Boolean get() = _isAmoled

    var flutterTheme by mutableStateOf(AppTheme.STANDARD)
    var flutterThemeMode by mutableStateOf(ThemeMode.SYSTEM)
    var flutterIsAmoled by mutableStateOf(false)

    var widgetTheme by mutableStateOf(AppTheme.BLUE)
    var widgetThemeMode by mutableStateOf(ThemeMode.SYSTEM)
    var widgetIsAmoled by mutableStateOf(false)

    private var syncChannel: MethodChannel? = null

    fun setupSyncChannel(messenger: BinaryMessenger) {
        syncChannel = MethodChannel(messenger, "design_engine_sync")
        syncChannel?.setMethodCallHandler { call, result ->
            if (call.method == "syncFlutterToAndroid") {
                val themeStr = call.argument<String>("theme")
                val modeStr = call.argument<String>("mode")
                val amoled = call.argument<Boolean>("amoled")

                if (themeStr != null) {
                    try { flutterTheme = AppTheme.valueOf(themeStr.uppercase()) } catch(e: Exception) {}
                }
                if (modeStr != null) {
                    try { flutterThemeMode = ThemeMode.valueOf(modeStr.uppercase()) } catch(e: Exception) {}
                }
                if (amoled != null) flutterIsAmoled = amoled

                result.success(null)
            } else {
                result.notImplemented()
            }
        }
    }

    private fun syncAndroidToFlutter() {
        val args = mapOf(
            "theme" to _currentTheme.name,
            "mode" to _themeMode.name,
            "amoled" to _isAmoled
        )
        syncChannel?.invokeMethod("syncAndroidToFlutter", args)
    }

    fun setTheme(theme: AppTheme) {
        _currentTheme = theme
        syncAndroidToFlutter()
    }

    fun setThemeMode(mode: ThemeMode) {
        _themeMode = mode
        syncAndroidToFlutter()
    }

    fun setAmoled(amoled: Boolean) {
        _isAmoled = amoled
        syncAndroidToFlutter()
    }

    fun setAndroidTheme(theme: AppTheme) = setTheme(theme)
    fun setAndroidThemeMode(mode: ThemeMode) = setThemeMode(mode)
    fun setAndroidIsAmoled(amoled: Boolean) = setAmoled(amoled)

    fun isEffectiveDark(systemInDarkTheme: Boolean): Boolean {
        return when (_themeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> systemInDarkTheme
        }
    }

    private val amoledOverrides = mapOf(
        "ebackground" to Color(0xFF000000),
        "esurface" to Color(0xFF000000)
    )

    @Composable
    private fun resolveToken(
        name: String,
        lightRes: (AppTheme) -> Int,
        darkRes: (AppTheme) -> Int,
        systemInDarkTheme: Boolean
    ): Color {
        val isFlutterOrder = name.startsWith("ef")
        val isWidgetOrder = name.startsWith("ew")

        val activeTheme = if (isFlutterOrder) flutterTheme else if (isWidgetOrder) widgetTheme else _currentTheme
        val activeThemeMode = if (isFlutterOrder) flutterThemeMode else if (isWidgetOrder) widgetThemeMode else _themeMode
        val activeAmoled = if (isFlutterOrder) flutterIsAmoled else if (isWidgetOrder) widgetIsAmoled else _isAmoled

        val dark = when (activeThemeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> systemInDarkTheme
        }

        val baseName = if (isFlutterOrder || isWidgetOrder) "e" + name.drop(2) else name
        if (dark && activeAmoled && amoledOverrides.containsKey(baseName)) {
            return amoledOverrides[baseName]!!
        }

        val resId = if (!dark) lightRes(activeTheme) else darkRes(activeTheme)
        val context = LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
        
        if (resType == "string") {
            val command = stringResource(id = resId)
            return resolveMaterialCommand(command, dark) 
        }
        
        return colorResource(id = resId)
    }

    @Composable
    private fun resolveMaterialCommand(command: String, isDark: Boolean): Color {
        val context = LocalContext.current
        
        // SAFE SCHEME ACCESS: Never use MaterialTheme.colorScheme directly here to avoid crashes outside UI tree.
        val s = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (isDark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        } else {
            if (isDark) darkColorScheme() else lightColorScheme()
        }

        return when (command) {
            "MaterialTheme.colorScheme.background" -> s.background
            "MaterialTheme.colorScheme.onBackground" -> s.onBackground
            "MaterialTheme.colorScheme.surface" -> s.surface
            "MaterialTheme.colorScheme.onSurface" -> s.onSurface
            "MaterialTheme.colorScheme.surfaceVariant" -> s.surfaceVariant
            "MaterialTheme.colorScheme.onSurfaceVariant" -> s.onSurfaceVariant
            "MaterialTheme.colorScheme.inverseSurface" -> s.inverseSurface
            "MaterialTheme.colorScheme.onInverseSurface" -> s.inverseOnSurface
            "MaterialTheme.colorScheme.surfaceBright" -> s.surfaceBright
            "MaterialTheme.colorScheme.surfaceDim" -> s.surfaceDim
            "MaterialTheme.colorScheme.surfaceContainerLow" -> s.surfaceContainerLow
            "MaterialTheme.colorScheme.surfaceContainerHigh" -> s.surfaceContainerHigh
            "MaterialTheme.colorScheme.surfaceContainerLowest" -> s.surfaceContainerLowest
            "MaterialTheme.colorScheme.surfaceContainerHighest" -> s.surfaceContainerHighest
            "MaterialTheme.colorScheme.surfaceContainer" -> s.surfaceContainer
            "MaterialTheme.colorScheme.primary" -> s.primary
            "MaterialTheme.colorScheme.onPrimary" -> s.onPrimary
            "MaterialTheme.colorScheme.primaryContainer" -> s.primaryContainer
            "MaterialTheme.colorScheme.onPrimaryContainer" -> s.onPrimaryContainer
            "MaterialTheme.colorScheme.primaryFixed" -> s.primaryFixed
            "MaterialTheme.colorScheme.primaryFixedDim" -> s.primaryFixedDim
            "MaterialTheme.colorScheme.onPrimaryFixed" -> s.onPrimaryFixed
            "MaterialTheme.colorScheme.onPrimaryFixedVariant" -> s.onPrimaryFixedVariant
            "MaterialTheme.colorScheme.inversePrimary" -> s.inversePrimary
            "MaterialTheme.colorScheme.secondary" -> s.secondary
            "MaterialTheme.colorScheme.onSecondary" -> s.onSecondary
            "MaterialTheme.colorScheme.secondaryContainer" -> s.secondaryContainer
            "MaterialTheme.colorScheme.onSecondaryContainer" -> s.onSecondaryContainer
            "MaterialTheme.colorScheme.secondaryFixed" -> s.secondaryFixed
            "MaterialTheme.colorScheme.secondaryFixedDim" -> s.secondaryFixedDim
            "MaterialTheme.colorScheme.onSecondaryFixed" -> s.onSecondaryFixed
            "MaterialTheme.colorScheme.onSecondaryFixedVariant" -> s.onSecondaryFixedVariant
            "MaterialTheme.colorScheme.tertiary" -> s.tertiary
            "MaterialTheme.colorScheme.onTertiary" -> s.onTertiary
            "MaterialTheme.colorScheme.tertiaryContainer" -> s.tertiaryContainer
            "MaterialTheme.colorScheme.onTertiaryContainer" -> s.onTertiaryContainer
            "MaterialTheme.colorScheme.tertiaryFixed" -> s.tertiaryFixed
            "MaterialTheme.colorScheme.tertiaryFixedDim" -> s.tertiaryFixedDim
            "MaterialTheme.colorScheme.onTertiaryFixed" -> s.onTertiaryFixed
            "MaterialTheme.colorScheme.onTertiaryFixedVariant" -> s.onTertiaryFixedVariant
            "MaterialTheme.colorScheme.error" -> s.error
            "MaterialTheme.colorScheme.onError" -> s.onError
            "MaterialTheme.colorScheme.errorContainer" -> s.errorContainer
            "MaterialTheme.colorScheme.onErrorContainer" -> s.onErrorContainer
            "MaterialTheme.colorScheme.outline" -> s.outline
            "MaterialTheme.colorScheme.outlineVariant" -> s.outlineVariant
            else -> s.primary
        }
    }

    @Composable
    fun eprimaryForTheme(theme: AppTheme, systemInDarkTheme: Boolean): Color {
        val dark = isEffectiveDark(systemInDarkTheme)
        val resId = if (!dark) EPrimaryLight.getResId(theme) else EPrimaryDark.getResId(theme)
        val context = LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
        if (resType == "string") {
            return resolveMaterialCommand(stringResource(id = resId), dark)
        }
        return colorResource(id = resId)
    }

    @Composable
    fun efprimaryForTheme(theme: AppTheme, systemInDarkTheme: Boolean): Color {
        val dark = when (flutterThemeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> systemInDarkTheme
        }
        val resId = if (!dark) EPrimaryLight.getResId(theme) else EPrimaryDark.getResId(theme)
        val context = LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
        if (resType == "string") {
            return resolveMaterialCommand(stringResource(id = resId), dark)
        }
        return colorResource(id = resId)
    }

    @Composable
    fun ewprimaryForTheme(theme: AppTheme, systemInDarkTheme: Boolean): Color {
        val dark = when (widgetThemeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> systemInDarkTheme
        }
        val resId = if (!dark) EPrimaryLight.getResId(theme) else EPrimaryDark.getResId(theme)
        val context = LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
        if (resType == "string") {
            return resolveMaterialCommand(stringResource(id = resId), dark)
        }
        return colorResource(id = resId)
    }
`;

tokens.forEach(token => {
    const g = formatGetterName(token);
    const ef = "ef" + g.substring(1);
    const ew = "ew" + g.substring(1);
    const cl = getFullClassName(token, 'light');
    const cd = getFullClassName(token, 'dark');
    
    content += `
    @Composable
    fun ${g}(systemInDarkTheme: Boolean): Color {
        return resolveToken("${g}", ${cl}::getResId, ${cd}::getResId, systemInDarkTheme)
    }

    @Composable
    fun ${g}Light(): Color {
        return resolveToken("${g}", ${cl}::getResId, ${cd}::getResId, false)
    }

    @Composable
    fun ${g}Dark(): Color {
        return resolveToken("${g}", ${cl}::getResId, ${cd}::getResId, true)
    }

    @Composable
    fun ${ef}(systemInDarkTheme: Boolean): Color {
        return resolveToken("${ef}", ${cl}::getResId, ${cd}::getResId, systemInDarkTheme)
    }

    @Composable
    fun ${ef}Light(): Color {
        return resolveToken("${ef}", ${cl}::getResId, ${cd}::getResId, false)
    }

    @Composable
    fun ${ef}Dark(): Color {
        return resolveToken("${ef}", ${cl}::getResId, ${cd}::getResId, true)
    }

    @Composable
    fun ${ew}(systemInDarkTheme: Boolean): Color {
        return resolveToken("${ew}", ${cl}::getResId, ${cd}::getResId, systemInDarkTheme)
    }

    @Composable
    fun ${ew}Light(): Color {
        return resolveToken("${ew}", ${cl}::getResId, ${cd}::getResId, false)
    }

    @Composable
    fun ${ew}Dark(): Color {
        return resolveToken("${ew}", ${cl}::getResId, ${cd}::getResId, true)
    }
`;
});

content += "}\n";
fs.writeFileSync(controllerPath, content);
console.log("Safe Controller fully regenerated.");
