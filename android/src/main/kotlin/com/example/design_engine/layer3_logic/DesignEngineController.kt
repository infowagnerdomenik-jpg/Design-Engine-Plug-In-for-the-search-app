package com.example.design_engine.layer3_logic

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import com.example.design_engine.layer2_core.light.EBackgroundLight
import com.example.design_engine.layer2_core.dark.EBackgroundDark
import com.example.design_engine.layer2_core.light.EOnBackgroundLight
import com.example.design_engine.layer2_core.dark.EOnBackgroundDark
import com.example.design_engine.layer2_core.light.ESurfaceLight
import com.example.design_engine.layer2_core.dark.ESurfaceDark
import com.example.design_engine.layer2_core.light.EOnSurfaceLight
import com.example.design_engine.layer2_core.dark.EOnSurfaceDark
import com.example.design_engine.layer2_core.light.ESurfaceVariantLight
import com.example.design_engine.layer2_core.dark.ESurfaceVariantDark
import com.example.design_engine.layer2_core.light.EOnSurfaceVariantLight
import com.example.design_engine.layer2_core.dark.EOnSurfaceVariantDark
import com.example.design_engine.layer2_core.light.EInverseSurfaceLight
import com.example.design_engine.layer2_core.dark.EInverseSurfaceDark
import com.example.design_engine.layer2_core.light.EInverseOnSurfaceLight
import com.example.design_engine.layer2_core.dark.EInverseOnSurfaceDark
import com.example.design_engine.layer2_core.light.ESurfaceBrightLight
import com.example.design_engine.layer2_core.dark.ESurfaceBrightDark
import com.example.design_engine.layer2_core.light.ESurfaceDimLight
import com.example.design_engine.layer2_core.dark.ESurfaceDimDark
import com.example.design_engine.layer2_core.light.ESurfaceContainerLowLight
import com.example.design_engine.layer2_core.dark.ESurfaceContainerLowDark
import com.example.design_engine.layer2_core.light.ESurfaceContainerHighLight
import com.example.design_engine.layer2_core.dark.ESurfaceContainerHighDark
import com.example.design_engine.layer2_core.light.ESurfaceContainerLowestLight
import com.example.design_engine.layer2_core.dark.ESurfaceContainerLowestDark
import com.example.design_engine.layer2_core.light.ESurfaceContainerHighestLight
import com.example.design_engine.layer2_core.dark.ESurfaceContainerHighestDark
import com.example.design_engine.layer2_core.light.ESurfaceContainerLight
import com.example.design_engine.layer2_core.dark.ESurfaceContainerDark
import com.example.design_engine.layer2_core.light.EPrimaryLight
import com.example.design_engine.layer2_core.dark.EPrimaryDark
import com.example.design_engine.layer2_core.light.EOnPrimaryLight
import com.example.design_engine.layer2_core.dark.EOnPrimaryDark
import com.example.design_engine.layer2_core.light.EPrimaryContainerLight
import com.example.design_engine.layer2_core.dark.EPrimaryContainerDark
import com.example.design_engine.layer2_core.light.EOnPrimaryContainerLight
import com.example.design_engine.layer2_core.dark.EOnPrimaryContainerDark
import com.example.design_engine.layer2_core.light.EPrimaryFixedLight
import com.example.design_engine.layer2_core.dark.EPrimaryFixedDark
import com.example.design_engine.layer2_core.light.EPrimaryFixedDimLight
import com.example.design_engine.layer2_core.dark.EPrimaryFixedDimDark
import com.example.design_engine.layer2_core.light.EOnPrimaryFixedLight
import com.example.design_engine.layer2_core.dark.EOnPrimaryFixedDark
import com.example.design_engine.layer2_core.light.EOnPrimaryFixedVariantLight
import com.example.design_engine.layer2_core.dark.EOnPrimaryFixedVariantDark
import com.example.design_engine.layer2_core.light.EInversePrimaryLight
import com.example.design_engine.layer2_core.dark.EInversePrimaryDark
import com.example.design_engine.layer2_core.light.ESecondaryLight
import com.example.design_engine.layer2_core.dark.ESecondaryDark
import com.example.design_engine.layer2_core.light.EOnSecondaryLight
import com.example.design_engine.layer2_core.dark.EOnSecondaryDark
import com.example.design_engine.layer2_core.light.ESecondaryContainerLight
import com.example.design_engine.layer2_core.dark.ESecondaryContainerDark
import com.example.design_engine.layer2_core.light.EOnSecondaryContainerLight
import com.example.design_engine.layer2_core.dark.EOnSecondaryContainerDark
import com.example.design_engine.layer2_core.light.ESecondaryFixedLight
import com.example.design_engine.layer2_core.dark.ESecondaryFixedDark
import com.example.design_engine.layer2_core.light.ESecondaryFixedDimLight
import com.example.design_engine.layer2_core.dark.ESecondaryFixedDimDark
import com.example.design_engine.layer2_core.light.EOnSecondaryFixedLight
import com.example.design_engine.layer2_core.dark.EOnSecondaryFixedDark
import com.example.design_engine.layer2_core.light.EOnSecondaryFixedVariantLight
import com.example.design_engine.layer2_core.dark.EOnSecondaryFixedVariantDark
import com.example.design_engine.layer2_core.light.ETertiaryLight
import com.example.design_engine.layer2_core.dark.ETertiaryDark
import com.example.design_engine.layer2_core.light.EOnTertiaryLight
import com.example.design_engine.layer2_core.dark.EOnTertiaryDark
import com.example.design_engine.layer2_core.light.ETertiaryContainerLight
import com.example.design_engine.layer2_core.dark.ETertiaryContainerDark
import com.example.design_engine.layer2_core.light.EOnTertiaryContainerLight
import com.example.design_engine.layer2_core.dark.EOnTertiaryContainerDark
import com.example.design_engine.layer2_core.light.ETertiaryFixedLight
import com.example.design_engine.layer2_core.dark.ETertiaryFixedDark
import com.example.design_engine.layer2_core.light.ETertiaryFixedDimLight
import com.example.design_engine.layer2_core.dark.ETertiaryFixedDimDark
import com.example.design_engine.layer2_core.light.EOnTertiaryFixedLight
import com.example.design_engine.layer2_core.dark.EOnTertiaryFixedDark
import com.example.design_engine.layer2_core.light.EOnTertiaryFixedVariantLight
import com.example.design_engine.layer2_core.dark.EOnTertiaryFixedVariantDark
import com.example.design_engine.layer2_core.light.EErrorLight
import com.example.design_engine.layer2_core.dark.EErrorDark
import com.example.design_engine.layer2_core.light.EOnErrorLight
import com.example.design_engine.layer2_core.dark.EOnErrorDark
import com.example.design_engine.layer2_core.light.EErrorContainerLight
import com.example.design_engine.layer2_core.dark.EErrorContainerDark
import com.example.design_engine.layer2_core.light.EOnErrorContainerLight
import com.example.design_engine.layer2_core.dark.EOnErrorContainerDark
import com.example.design_engine.layer2_core.light.EOutlineLight
import com.example.design_engine.layer2_core.dark.EOutlineDark
import com.example.design_engine.layer2_core.light.EOutlineVariantLight
import com.example.design_engine.layer2_core.dark.EOutlineVariantDark
import com.example.design_engine.layer2_core.light.EErprimaryLight
import com.example.design_engine.layer2_core.dark.EErprimaryDark
import com.example.design_engine.layer2_core.light.EEronprimaryLight
import com.example.design_engine.layer2_core.dark.EEronprimaryDark
import com.example.design_engine.layer2_core.light.EErprimarycontainerLight
import com.example.design_engine.layer2_core.dark.EErprimarycontainerDark
import com.example.design_engine.layer2_core.light.EEronprimarycontainerLight
import com.example.design_engine.layer2_core.dark.EEronprimarycontainerDark

enum class AppTheme { SYSTEM, STANDARD, BLUE, GREEN, RED, NOTHING }
enum class ThemeMode { SYSTEM, LIGHT, DARK }

object DesignEngineController {

    // --- SCHUBLADE 1: NATIVE APP ---
    private var _currentTheme by mutableStateOf(AppTheme.BLUE)
    val currentTheme: AppTheme get() = _currentTheme

    private var _themeMode by mutableStateOf(ThemeMode.SYSTEM)
    val themeMode: ThemeMode get() = _themeMode

    private var _isAmoled by mutableStateOf(false)
    val isAmoled: Boolean get() = _isAmoled

    // --- SCHUBLADE 2: FLUTTER ---
    var flutterTheme by mutableStateOf(AppTheme.STANDARD)
    var flutterThemeMode by mutableStateOf(ThemeMode.SYSTEM)
    var flutterIsAmoled by mutableStateOf(false)

    // --- SCHUBLADE 3: WIDGET (Mit automatischer Speicherung) ---
    private var _widgetTheme by mutableStateOf(AppTheme.STANDARD)
    var widgetTheme: AppTheme
        get() = _widgetTheme
        set(value) {
            _widgetTheme = value
            persistWidgetState()
        }

    private var _widgetThemeMode by mutableStateOf(ThemeMode.SYSTEM)
    var widgetThemeMode: ThemeMode
        get() = _widgetThemeMode
        set(value) {
            _widgetThemeMode = value
            persistWidgetState()
        }

    private var _widgetIsAmoled by mutableStateOf(false)
    var widgetIsAmoled: Boolean
        get() = _widgetIsAmoled
        set(value) {
            _widgetIsAmoled = value
            persistWidgetState()
        }

    // --- CACHE & BACKGROUND SYNC ---
    private var syncChannel: MethodChannel? = null
    private var appContext: Context? = null
    private var isInitializing = false
    private val scope = CoroutineScope(Dispatchers.IO)

    // ==========================================
    // INITIALISIERUNG & AUTOMATISCHES LADEN
    // ==========================================
    fun init(context: Context) {
        if (appContext == null && !isInitializing) {
            isInitializing = true
            appContext = context.applicationContext
            scope.launch {
                DesignEnginePrefs.loadNativeAppStateToController(appContext!!)
                DesignEnginePrefs.loadWidgetStateToController(appContext!!)
            }
        }
    }

    // ==========================================
    // SPEICHER-LOGIK (NATIV & WIDGET)
    // ==========================================
    private fun persistNativeAppState() {
        appContext?.let { ctx ->
            scope.launch { DesignEnginePrefs.saveNativeAppState(ctx, _currentTheme, _themeMode, _isAmoled) }
        }
    }

    private fun persistWidgetState() {
        appContext?.let { ctx ->
            scope.launch {
                DesignEnginePrefs.saveWidgetState(ctx, _widgetTheme, _widgetThemeMode, _widgetIsAmoled)
            }
        }
    }

    // --- HILFSFUNKTIONEN FÜR DIE APP ---
    fun internalSetAppTheme(theme: AppTheme, mode: ThemeMode, amoled: Boolean) {
        _currentTheme = theme
        _themeMode = mode
        _isAmoled = amoled
        syncAndroidToFlutter()
    }

    fun internalSetFlutterTheme(theme: AppTheme, mode: ThemeMode, amoled: Boolean) {
        flutterTheme = theme
        flutterThemeMode = mode
        flutterIsAmoled = amoled
    }

    // ==========================================
    // FLUTTER SYNC & SETTER
    // ==========================================
    fun setupSyncChannel(messenger: BinaryMessenger) {
        syncChannel = MethodChannel(messenger, "design_engine_sync")
        syncChannel?.setMethodCallHandler { call, result ->
            if (call.method == "syncFlutterToAndroid") {
                call.argument<String>("theme")?.let { try { flutterTheme = AppTheme.valueOf(it.uppercase()) } catch(e: Exception) {} }
                call.argument<String>("mode")?.let { try { flutterThemeMode = ThemeMode.valueOf(it.uppercase()) } catch(e: Exception) {} }
                call.argument<Boolean>("amoled")?.let { flutterIsAmoled = it }
                result.success(null)
            } else { result.notImplemented() }
        }
    }

    private fun syncAndroidToFlutter() {
        val args = mapOf("theme" to _currentTheme.name, "mode" to _themeMode.name, "amoled" to _isAmoled)
        Handler(Looper.getMainLooper()).post { syncChannel?.invokeMethod("syncAndroidToFlutter", args) }
    }

    fun setTheme(theme: AppTheme) { _currentTheme = theme; persistNativeAppState(); syncAndroidToFlutter() }
    fun setThemeMode(mode: ThemeMode) { _themeMode = mode; persistNativeAppState(); syncAndroidToFlutter() }
    fun setAmoled(amoled: Boolean) { _isAmoled = amoled; persistNativeAppState(); syncAndroidToFlutter() }

    fun setAndroidTheme(theme: AppTheme) = setTheme(theme)
    fun setAndroidThemeMode(mode: ThemeMode) = setThemeMode(mode)
    fun setAndroidIsAmoled(amoled: Boolean) = setAmoled(amoled)

    fun isEffectiveDark(systemInDarkTheme: Boolean): Boolean = when (_themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> systemInDarkTheme
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
        systemInDarkTheme: Boolean,
        explicitContext: Context? = null
    ): Color {
        val fallbackContext = explicitContext ?: LocalContext.current
        if (appContext == null) {
            init(fallbackContext)
        }
        
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
        
        if (explicitContext != null) {
            val resType = try { explicitContext.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
            if (resType == "string") {
                val command = explicitContext.getString(resId)
                return resolveMaterialCommand(command, dark, explicitContext)
            }
            return Color(androidx.core.content.ContextCompat.getColor(explicitContext, resId))
            
        } else {
            val context = LocalContext.current
            val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }
            
            if (resType == "string") {
                val command = stringResource(id = resId)
                return resolveMaterialCommand(command, dark, null) 
            }
            return colorResource(id = resId)
        }
    }

    @Composable
    private fun resolveMaterialCommand(command: String, isDark: Boolean, explicitContext: Context? = null): Color {
        val context = explicitContext ?: LocalContext.current
        
        val s = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (isDark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        } else {
            if (isDark) androidx.compose.material3.darkColorScheme() else androidx.compose.material3.lightColorScheme()
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

    // ==========================================
    // DIE 50 FARB-TOKENS
    // ==========================================

    @Composable fun ebackground(systemInDarkTheme: Boolean): Color = resolveToken("ebackground", EBackgroundLight::getResId, EBackgroundDark::getResId, systemInDarkTheme)
    @Composable fun ebackgroundLight(): Color = resolveToken("ebackground", EBackgroundLight::getResId, EBackgroundDark::getResId, false)
    @Composable fun ebackgroundDark(): Color = resolveToken("ebackground", EBackgroundLight::getResId, EBackgroundDark::getResId, true)
    @Composable fun efbackground(systemInDarkTheme: Boolean): Color = resolveToken("efbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, systemInDarkTheme)
    @Composable fun efbackgroundLight(): Color = resolveToken("efbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, false)
    @Composable fun efbackgroundDark(): Color = resolveToken("efbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, true)
    @Composable fun ewbackground(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, systemInDarkTheme, context)
    @Composable fun ewbackgroundLight(context: Context): Color = resolveToken("ewbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, false, context)
    @Composable fun ewbackgroundDark(context: Context): Color = resolveToken("ewbackground", EBackgroundLight::getResId, EBackgroundDark::getResId, true, context)

    @Composable fun eonbackground(systemInDarkTheme: Boolean): Color = resolveToken("eonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, systemInDarkTheme)
    @Composable fun eonbackgroundLight(): Color = resolveToken("eonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, false)
    @Composable fun eonbackgroundDark(): Color = resolveToken("eonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, true)
    @Composable fun efonbackground(systemInDarkTheme: Boolean): Color = resolveToken("efonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, systemInDarkTheme)
    @Composable fun efonbackgroundLight(): Color = resolveToken("efonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, false)
    @Composable fun efonbackgroundDark(): Color = resolveToken("efonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, true)
    @Composable fun ewonbackground(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonbackgroundLight(context: Context): Color = resolveToken("ewonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, false, context)
    @Composable fun ewonbackgroundDark(context: Context): Color = resolveToken("ewonbackground", EOnBackgroundLight::getResId, EOnBackgroundDark::getResId, true, context)

    @Composable fun esurface(systemInDarkTheme: Boolean): Color = resolveToken("esurface", ESurfaceLight::getResId, ESurfaceDark::getResId, systemInDarkTheme)
    @Composable fun esurfaceLight(): Color = resolveToken("esurface", ESurfaceLight::getResId, ESurfaceDark::getResId, false)
    @Composable fun esurfaceDark(): Color = resolveToken("esurface", ESurfaceLight::getResId, ESurfaceDark::getResId, true)
    @Composable fun efsurface(systemInDarkTheme: Boolean): Color = resolveToken("efsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, systemInDarkTheme)
    @Composable fun efsurfaceLight(): Color = resolveToken("efsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, false)
    @Composable fun efsurfaceDark(): Color = resolveToken("efsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, true)
    @Composable fun ewsurface(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfaceLight(context: Context): Color = resolveToken("ewsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, false, context)
    @Composable fun ewsurfaceDark(context: Context): Color = resolveToken("ewsurface", ESurfaceLight::getResId, ESurfaceDark::getResId, true, context)

    @Composable fun eonsurface(systemInDarkTheme: Boolean): Color = resolveToken("eonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun eonsurfaceLight(): Color = resolveToken("eonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, false)
    @Composable fun eonsurfaceDark(): Color = resolveToken("eonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, true)
    @Composable fun efonsurface(systemInDarkTheme: Boolean): Color = resolveToken("efonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun efonsurfaceLight(): Color = resolveToken("efonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, false)
    @Composable fun efonsurfaceDark(): Color = resolveToken("efonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, true)
    @Composable fun ewonsurface(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsurfaceLight(context: Context): Color = resolveToken("ewonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, false, context)
    @Composable fun ewonsurfaceDark(context: Context): Color = resolveToken("ewonsurface", EOnSurfaceLight::getResId, EOnSurfaceDark::getResId, true, context)

    @Composable fun esurfacevariant(systemInDarkTheme: Boolean): Color = resolveToken("esurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, systemInDarkTheme)
    @Composable fun esurfacevariantLight(): Color = resolveToken("esurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, false)
    @Composable fun esurfacevariantDark(): Color = resolveToken("esurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, true)
    @Composable fun efsurfacevariant(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacevariantLight(): Color = resolveToken("efsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, false)
    @Composable fun efsurfacevariantDark(): Color = resolveToken("efsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, true)
    @Composable fun ewsurfacevariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacevariantLight(context: Context): Color = resolveToken("ewsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, false, context)
    @Composable fun ewsurfacevariantDark(context: Context): Color = resolveToken("ewsurfacevariant", ESurfaceVariantLight::getResId, ESurfaceVariantDark::getResId, true, context)

    @Composable fun eonsurfacevariant(systemInDarkTheme: Boolean): Color = resolveToken("eonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, systemInDarkTheme)
    @Composable fun eonsurfacevariantLight(): Color = resolveToken("eonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, false)
    @Composable fun eonsurfacevariantDark(): Color = resolveToken("eonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, true)
    @Composable fun efonsurfacevariant(systemInDarkTheme: Boolean): Color = resolveToken("efonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, systemInDarkTheme)
    @Composable fun efonsurfacevariantLight(): Color = resolveToken("efonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, false)
    @Composable fun efonsurfacevariantDark(): Color = resolveToken("efonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, true)
    @Composable fun ewonsurfacevariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsurfacevariantLight(context: Context): Color = resolveToken("ewonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, false, context)
    @Composable fun ewonsurfacevariantDark(context: Context): Color = resolveToken("ewonsurfacevariant", EOnSurfaceVariantLight::getResId, EOnSurfaceVariantDark::getResId, true, context)

    @Composable fun einversesurface(systemInDarkTheme: Boolean): Color = resolveToken("einversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun einversesurfaceLight(): Color = resolveToken("einversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, false)
    @Composable fun einversesurfaceDark(): Color = resolveToken("einversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, true)
    @Composable fun efinversesurface(systemInDarkTheme: Boolean): Color = resolveToken("efinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun efinversesurfaceLight(): Color = resolveToken("efinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, false)
    @Composable fun efinversesurfaceDark(): Color = resolveToken("efinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, true)
    @Composable fun ewinversesurface(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, systemInDarkTheme, context)
    @Composable fun ewinversesurfaceLight(context: Context): Color = resolveToken("ewinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, false, context)
    @Composable fun ewinversesurfaceDark(context: Context): Color = resolveToken("ewinversesurface", EInverseSurfaceLight::getResId, EInverseSurfaceDark::getResId, true, context)

    @Composable fun einverseonsurface(systemInDarkTheme: Boolean): Color = resolveToken("einverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun einverseonsurfaceLight(): Color = resolveToken("einverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, false)
    @Composable fun einverseonsurfaceDark(): Color = resolveToken("einverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, true)
    @Composable fun efinverseonsurface(systemInDarkTheme: Boolean): Color = resolveToken("efinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, systemInDarkTheme)
    @Composable fun efinverseonsurfaceLight(): Color = resolveToken("efinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, false)
    @Composable fun efinverseonsurfaceDark(): Color = resolveToken("efinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, true)
    @Composable fun ewinverseonsurface(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, systemInDarkTheme, context)
    @Composable fun ewinverseonsurfaceLight(context: Context): Color = resolveToken("ewinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, false, context)
    @Composable fun ewinverseonsurfaceDark(context: Context): Color = resolveToken("ewinverseonsurface", EInverseOnSurfaceLight::getResId, EInverseOnSurfaceDark::getResId, true, context)

    @Composable fun esurfacebright(systemInDarkTheme: Boolean): Color = resolveToken("esurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, systemInDarkTheme)
    @Composable fun esurfacebrightLight(): Color = resolveToken("esurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, false)
    @Composable fun esurfacebrightDark(): Color = resolveToken("esurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, true)
    @Composable fun efsurfacebright(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacebrightLight(): Color = resolveToken("efsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, false)
    @Composable fun efsurfacebrightDark(): Color = resolveToken("efsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, true)
    @Composable fun ewsurfacebright(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacebrightLight(context: Context): Color = resolveToken("ewsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, false, context)
    @Composable fun ewsurfacebrightDark(context: Context): Color = resolveToken("ewsurfacebright", ESurfaceBrightLight::getResId, ESurfaceBrightDark::getResId, true, context)

    @Composable fun esurfacedim(systemInDarkTheme: Boolean): Color = resolveToken("esurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, systemInDarkTheme)
    @Composable fun esurfacedimLight(): Color = resolveToken("esurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, false)
    @Composable fun esurfacedimDark(): Color = resolveToken("esurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, true)
    @Composable fun efsurfacedim(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacedimLight(): Color = resolveToken("efsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, false)
    @Composable fun efsurfacedimDark(): Color = resolveToken("efsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, true)
    @Composable fun ewsurfacedim(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacedimLight(context: Context): Color = resolveToken("ewsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, false, context)
    @Composable fun ewsurfacedimDark(context: Context): Color = resolveToken("ewsurfacedim", ESurfaceDimLight::getResId, ESurfaceDimDark::getResId, true, context)

    @Composable fun esurfacecontainerlow(systemInDarkTheme: Boolean): Color = resolveToken("esurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, systemInDarkTheme)
    @Composable fun esurfacecontainerlowLight(): Color = resolveToken("esurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, false)
    @Composable fun esurfacecontainerlowDark(): Color = resolveToken("esurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, true)
    @Composable fun efsurfacecontainerlow(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacecontainerlowLight(): Color = resolveToken("efsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, false)
    @Composable fun efsurfacecontainerlowDark(): Color = resolveToken("efsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, true)
    @Composable fun ewsurfacecontainerlow(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacecontainerlowLight(context: Context): Color = resolveToken("ewsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, false, context)
    @Composable fun ewsurfacecontainerlowDark(context: Context): Color = resolveToken("ewsurfacecontainerlow", ESurfaceContainerLowLight::getResId, ESurfaceContainerLowDark::getResId, true, context)

    @Composable fun esurfacecontainerhigh(systemInDarkTheme: Boolean): Color = resolveToken("esurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, systemInDarkTheme)
    @Composable fun esurfacecontainerhighLight(): Color = resolveToken("esurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, false)
    @Composable fun esurfacecontainerhighDark(): Color = resolveToken("esurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, true)
    @Composable fun efsurfacecontainerhigh(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacecontainerhighLight(): Color = resolveToken("efsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, false)
    @Composable fun efsurfacecontainerhighDark(): Color = resolveToken("efsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, true)
    @Composable fun ewsurfacecontainerhigh(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacecontainerhighLight(context: Context): Color = resolveToken("ewsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, false, context)
    @Composable fun ewsurfacecontainerhighDark(context: Context): Color = resolveToken("ewsurfacecontainerhigh", ESurfaceContainerHighLight::getResId, ESurfaceContainerHighDark::getResId, true, context)

    @Composable fun esurfacecontainerlowest(systemInDarkTheme: Boolean): Color = resolveToken("esurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, systemInDarkTheme)
    @Composable fun esurfacecontainerlowestLight(): Color = resolveToken("esurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, false)
    @Composable fun esurfacecontainerlowestDark(): Color = resolveToken("esurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, true)
    @Composable fun efsurfacecontainerlowest(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacecontainerlowestLight(): Color = resolveToken("efsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, false)
    @Composable fun efsurfacecontainerlowestDark(): Color = resolveToken("efsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, true)
    @Composable fun ewsurfacecontainerlowest(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacecontainerlowestLight(context: Context): Color = resolveToken("ewsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, false, context)
    @Composable fun ewsurfacecontainerlowestDark(context: Context): Color = resolveToken("ewsurfacecontainerlowest", ESurfaceContainerLowestLight::getResId, ESurfaceContainerLowestDark::getResId, true, context)

    @Composable fun esurfacecontainerhighest(systemInDarkTheme: Boolean): Color = resolveToken("esurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, systemInDarkTheme)
    @Composable fun esurfacecontainerhighestLight(): Color = resolveToken("esurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, false)
    @Composable fun esurfacecontainerhighestDark(): Color = resolveToken("esurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, true)
    @Composable fun efsurfacecontainerhighest(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacecontainerhighestLight(): Color = resolveToken("efsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, false)
    @Composable fun efsurfacecontainerhighestDark(): Color = resolveToken("efsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, true)
    @Composable fun ewsurfacecontainerhighest(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacecontainerhighestLight(context: Context): Color = resolveToken("ewsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, false, context)
    @Composable fun ewsurfacecontainerhighestDark(context: Context): Color = resolveToken("ewsurfacecontainerhighest", ESurfaceContainerHighestLight::getResId, ESurfaceContainerHighestDark::getResId, true, context)

    @Composable fun esurfacecontainer(systemInDarkTheme: Boolean): Color = resolveToken("esurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, systemInDarkTheme)
    @Composable fun esurfacecontainerLight(): Color = resolveToken("esurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, false)
    @Composable fun esurfacecontainerDark(): Color = resolveToken("esurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, true)
    @Composable fun efsurfacecontainer(systemInDarkTheme: Boolean): Color = resolveToken("efsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, systemInDarkTheme)
    @Composable fun efsurfacecontainerLight(): Color = resolveToken("efsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, false)
    @Composable fun efsurfacecontainerDark(): Color = resolveToken("efsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, true)
    @Composable fun ewsurfacecontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsurfacecontainerLight(context: Context): Color = resolveToken("ewsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, false, context)
    @Composable fun ewsurfacecontainerDark(context: Context): Color = resolveToken("ewsurfacecontainer", ESurfaceContainerLight::getResId, ESurfaceContainerDark::getResId, true, context)

    @Composable fun eprimary(systemInDarkTheme: Boolean): Color = resolveToken("eprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, systemInDarkTheme)
    @Composable fun eprimaryLight(): Color = resolveToken("eprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, false)
    @Composable fun eprimaryDark(): Color = resolveToken("eprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, true)
    @Composable fun efprimary(systemInDarkTheme: Boolean): Color = resolveToken("efprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, systemInDarkTheme)
    @Composable fun efprimaryLight(): Color = resolveToken("efprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, false)
    @Composable fun efprimaryDark(): Color = resolveToken("efprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, true)
    @Composable fun ewprimary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewprimaryLight(context: Context): Color = resolveToken("ewprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, false, context)
    @Composable fun ewprimaryDark(context: Context): Color = resolveToken("ewprimary", EPrimaryLight::getResId, EPrimaryDark::getResId, true, context)

    @Composable fun eonprimary(systemInDarkTheme: Boolean): Color = resolveToken("eonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, systemInDarkTheme)
    @Composable fun eonprimaryLight(): Color = resolveToken("eonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, false)
    @Composable fun eonprimaryDark(): Color = resolveToken("eonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, true)
    @Composable fun efonprimary(systemInDarkTheme: Boolean): Color = resolveToken("efonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, systemInDarkTheme)
    @Composable fun efonprimaryLight(): Color = resolveToken("efonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, false)
    @Composable fun efonprimaryDark(): Color = resolveToken("efonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, true)
    @Composable fun ewonprimary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonprimaryLight(context: Context): Color = resolveToken("ewonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, false, context)
    @Composable fun ewonprimaryDark(context: Context): Color = resolveToken("ewonprimary", EOnPrimaryLight::getResId, EOnPrimaryDark::getResId, true, context)

    @Composable fun eprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun eprimarycontainerLight(): Color = resolveToken("eprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, false)
    @Composable fun eprimarycontainerDark(): Color = resolveToken("eprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, true)
    @Composable fun efprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("efprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun efprimarycontainerLight(): Color = resolveToken("efprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, false)
    @Composable fun efprimarycontainerDark(): Color = resolveToken("efprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, true)
    @Composable fun ewprimarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewprimarycontainerLight(context: Context): Color = resolveToken("ewprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, false, context)
    @Composable fun ewprimarycontainerDark(context: Context): Color = resolveToken("ewprimarycontainer", EPrimaryContainerLight::getResId, EPrimaryContainerDark::getResId, true, context)

    @Composable fun eonprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun eonprimarycontainerLight(): Color = resolveToken("eonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, false)
    @Composable fun eonprimarycontainerDark(): Color = resolveToken("eonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, true)
    @Composable fun efonprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("efonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun efonprimarycontainerLight(): Color = resolveToken("efonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, false)
    @Composable fun efonprimarycontainerDark(): Color = resolveToken("efonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, true)
    @Composable fun ewonprimarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonprimarycontainerLight(context: Context): Color = resolveToken("ewonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, false, context)
    @Composable fun ewonprimarycontainerDark(context: Context): Color = resolveToken("ewonprimarycontainer", EOnPrimaryContainerLight::getResId, EOnPrimaryContainerDark::getResId, true, context)

    @Composable fun eprimaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("eprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun eprimaryfixedLight(): Color = resolveToken("eprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, false)
    @Composable fun eprimaryfixedDark(): Color = resolveToken("eprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, true)
    @Composable fun efprimaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("efprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun efprimaryfixedLight(): Color = resolveToken("efprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, false)
    @Composable fun efprimaryfixedDark(): Color = resolveToken("efprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, true)
    @Composable fun ewprimaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewprimaryfixedLight(context: Context): Color = resolveToken("ewprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, false, context)
    @Composable fun ewprimaryfixedDark(context: Context): Color = resolveToken("ewprimaryfixed", EPrimaryFixedLight::getResId, EPrimaryFixedDark::getResId, true, context)

    @Composable fun eprimaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("eprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun eprimaryfixeddimLight(): Color = resolveToken("eprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, false)
    @Composable fun eprimaryfixeddimDark(): Color = resolveToken("eprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, true)
    @Composable fun efprimaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("efprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun efprimaryfixeddimLight(): Color = resolveToken("efprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, false)
    @Composable fun efprimaryfixeddimDark(): Color = resolveToken("efprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, true)
    @Composable fun ewprimaryfixeddim(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, systemInDarkTheme, context)
    @Composable fun ewprimaryfixeddimLight(context: Context): Color = resolveToken("ewprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, false, context)
    @Composable fun ewprimaryfixeddimDark(context: Context): Color = resolveToken("ewprimaryfixeddim", EPrimaryFixedDimLight::getResId, EPrimaryFixedDimDark::getResId, true, context)

    @Composable fun eonprimaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("eonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun eonprimaryfixedLight(): Color = resolveToken("eonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, false)
    @Composable fun eonprimaryfixedDark(): Color = resolveToken("eonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, true)
    @Composable fun efonprimaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("efonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun efonprimaryfixedLight(): Color = resolveToken("efonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, false)
    @Composable fun efonprimaryfixedDark(): Color = resolveToken("efonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, true)
    @Composable fun ewonprimaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonprimaryfixedLight(context: Context): Color = resolveToken("ewonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, false, context)
    @Composable fun ewonprimaryfixedDark(context: Context): Color = resolveToken("ewonprimaryfixed", EOnPrimaryFixedLight::getResId, EOnPrimaryFixedDark::getResId, true, context)

    @Composable fun eonprimaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("eonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun eonprimaryfixedvariantLight(): Color = resolveToken("eonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, false)
    @Composable fun eonprimaryfixedvariantDark(): Color = resolveToken("eonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, true)
    @Composable fun efonprimaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("efonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun efonprimaryfixedvariantLight(): Color = resolveToken("efonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, false)
    @Composable fun efonprimaryfixedvariantDark(): Color = resolveToken("efonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, true)
    @Composable fun ewonprimaryfixedvariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonprimaryfixedvariantLight(context: Context): Color = resolveToken("ewonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, false, context)
    @Composable fun ewonprimaryfixedvariantDark(context: Context): Color = resolveToken("ewonprimaryfixedvariant", EOnPrimaryFixedVariantLight::getResId, EOnPrimaryFixedVariantDark::getResId, true, context)

    @Composable fun einverseprimary(systemInDarkTheme: Boolean): Color = resolveToken("einverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, systemInDarkTheme)
    @Composable fun einverseprimaryLight(): Color = resolveToken("einverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, false)
    @Composable fun einverseprimaryDark(): Color = resolveToken("einverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, true)
    @Composable fun efinverseprimary(systemInDarkTheme: Boolean): Color = resolveToken("efinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, systemInDarkTheme)
    @Composable fun efinverseprimaryLight(): Color = resolveToken("efinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, false)
    @Composable fun efinverseprimaryDark(): Color = resolveToken("efinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, true)
    @Composable fun ewinverseprimary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewinverseprimaryLight(context: Context): Color = resolveToken("ewinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, false, context)
    @Composable fun ewinverseprimaryDark(context: Context): Color = resolveToken("ewinverseprimary", EInversePrimaryLight::getResId, EInversePrimaryDark::getResId, true, context)

    @Composable fun esecondary(systemInDarkTheme: Boolean): Color = resolveToken("esecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, systemInDarkTheme)
    @Composable fun esecondaryLight(): Color = resolveToken("esecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, false)
    @Composable fun esecondaryDark(): Color = resolveToken("esecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, true)
    @Composable fun efsecondary(systemInDarkTheme: Boolean): Color = resolveToken("efsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, systemInDarkTheme)
    @Composable fun efsecondaryLight(): Color = resolveToken("efsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, false)
    @Composable fun efsecondaryDark(): Color = resolveToken("efsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, true)
    @Composable fun ewsecondary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsecondaryLight(context: Context): Color = resolveToken("ewsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, false, context)
    @Composable fun ewsecondaryDark(context: Context): Color = resolveToken("ewsecondary", ESecondaryLight::getResId, ESecondaryDark::getResId, true, context)

    @Composable fun eonsecondary(systemInDarkTheme: Boolean): Color = resolveToken("eonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, systemInDarkTheme)
    @Composable fun eonsecondaryLight(): Color = resolveToken("eonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, false)
    @Composable fun eonsecondaryDark(): Color = resolveToken("eonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, true)
    @Composable fun efonsecondary(systemInDarkTheme: Boolean): Color = resolveToken("efonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, systemInDarkTheme)
    @Composable fun efonsecondaryLight(): Color = resolveToken("efonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, false)
    @Composable fun efonsecondaryDark(): Color = resolveToken("efonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, true)
    @Composable fun ewonsecondary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsecondaryLight(context: Context): Color = resolveToken("ewonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, false, context)
    @Composable fun ewonsecondaryDark(context: Context): Color = resolveToken("ewonsecondary", EOnSecondaryLight::getResId, EOnSecondaryDark::getResId, true, context)

    @Composable fun esecondarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("esecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun esecondarycontainerLight(): Color = resolveToken("esecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, false)
    @Composable fun esecondarycontainerDark(): Color = resolveToken("esecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, true)
    @Composable fun efsecondarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("efsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun efsecondarycontainerLight(): Color = resolveToken("efsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, false)
    @Composable fun efsecondarycontainerDark(): Color = resolveToken("efsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, true)
    @Composable fun ewsecondarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsecondarycontainerLight(context: Context): Color = resolveToken("ewsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, false, context)
    @Composable fun ewsecondarycontainerDark(context: Context): Color = resolveToken("ewsecondarycontainer", ESecondaryContainerLight::getResId, ESecondaryContainerDark::getResId, true, context)

    @Composable fun eonsecondarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun eonsecondarycontainerLight(): Color = resolveToken("eonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, false)
    @Composable fun eonsecondarycontainerDark(): Color = resolveToken("eonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, true)
    @Composable fun efonsecondarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("efonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun efonsecondarycontainerLight(): Color = resolveToken("efonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, false)
    @Composable fun efonsecondarycontainerDark(): Color = resolveToken("efonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, true)
    @Composable fun ewonsecondarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsecondarycontainerLight(context: Context): Color = resolveToken("ewonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, false, context)
    @Composable fun ewonsecondarycontainerDark(context: Context): Color = resolveToken("ewonsecondarycontainer", EOnSecondaryContainerLight::getResId, EOnSecondaryContainerDark::getResId, true, context)

    @Composable fun esecondaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("esecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun esecondaryfixedLight(): Color = resolveToken("esecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, false)
    @Composable fun esecondaryfixedDark(): Color = resolveToken("esecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, true)
    @Composable fun efsecondaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("efsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun efsecondaryfixedLight(): Color = resolveToken("efsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, false)
    @Composable fun efsecondaryfixedDark(): Color = resolveToken("efsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, true)
    @Composable fun ewsecondaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsecondaryfixedLight(context: Context): Color = resolveToken("ewsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, false, context)
    @Composable fun ewsecondaryfixedDark(context: Context): Color = resolveToken("ewsecondaryfixed", ESecondaryFixedLight::getResId, ESecondaryFixedDark::getResId, true, context)

    @Composable fun esecondaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("esecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun esecondaryfixeddimLight(): Color = resolveToken("esecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, false)
    @Composable fun esecondaryfixeddimDark(): Color = resolveToken("esecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, true)
    @Composable fun efsecondaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("efsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun efsecondaryfixeddimLight(): Color = resolveToken("efsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, false)
    @Composable fun efsecondaryfixeddimDark(): Color = resolveToken("efsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, true)
    @Composable fun ewsecondaryfixeddim(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, systemInDarkTheme, context)
    @Composable fun ewsecondaryfixeddimLight(context: Context): Color = resolveToken("ewsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, false, context)
    @Composable fun ewsecondaryfixeddimDark(context: Context): Color = resolveToken("ewsecondaryfixeddim", ESecondaryFixedDimLight::getResId, ESecondaryFixedDimDark::getResId, true, context)

    @Composable fun eonsecondaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("eonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun eonsecondaryfixedLight(): Color = resolveToken("eonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, false)
    @Composable fun eonsecondaryfixedDark(): Color = resolveToken("eonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, true)
    @Composable fun efonsecondaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("efonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun efonsecondaryfixedLight(): Color = resolveToken("efonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, false)
    @Composable fun efonsecondaryfixedDark(): Color = resolveToken("efonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, true)
    @Composable fun ewonsecondaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsecondaryfixedLight(context: Context): Color = resolveToken("ewonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, false, context)
    @Composable fun ewonsecondaryfixedDark(context: Context): Color = resolveToken("ewonsecondaryfixed", EOnSecondaryFixedLight::getResId, EOnSecondaryFixedDark::getResId, true, context)

    @Composable fun eonsecondaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("eonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun eonsecondaryfixedvariantLight(): Color = resolveToken("eonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, false)
    @Composable fun eonsecondaryfixedvariantDark(): Color = resolveToken("eonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, true)
    @Composable fun efonsecondaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("efonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun efonsecondaryfixedvariantLight(): Color = resolveToken("efonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, false)
    @Composable fun efonsecondaryfixedvariantDark(): Color = resolveToken("efonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, true)
    @Composable fun ewonsecondaryfixedvariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonsecondaryfixedvariantLight(context: Context): Color = resolveToken("ewonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, false, context)
    @Composable fun ewonsecondaryfixedvariantDark(context: Context): Color = resolveToken("ewonsecondaryfixedvariant", EOnSecondaryFixedVariantLight::getResId, EOnSecondaryFixedVariantDark::getResId, true, context)

    @Composable fun etertiary(systemInDarkTheme: Boolean): Color = resolveToken("etertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, systemInDarkTheme)
    @Composable fun etertiaryLight(): Color = resolveToken("etertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, false)
    @Composable fun etertiaryDark(): Color = resolveToken("etertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, true)
    @Composable fun eftertiary(systemInDarkTheme: Boolean): Color = resolveToken("eftertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, systemInDarkTheme)
    @Composable fun eftertiaryLight(): Color = resolveToken("eftertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, false)
    @Composable fun eftertiaryDark(): Color = resolveToken("eftertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, true)
    @Composable fun ewtertiary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewtertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewtertiaryLight(context: Context): Color = resolveToken("ewtertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, false, context)
    @Composable fun ewtertiaryDark(context: Context): Color = resolveToken("ewtertiary", ETertiaryLight::getResId, ETertiaryDark::getResId, true, context)

    @Composable fun eontertiary(systemInDarkTheme: Boolean): Color = resolveToken("eontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, systemInDarkTheme)
    @Composable fun eontertiaryLight(): Color = resolveToken("eontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, false)
    @Composable fun eontertiaryDark(): Color = resolveToken("eontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, true)
    @Composable fun efontertiary(systemInDarkTheme: Boolean): Color = resolveToken("efontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, systemInDarkTheme)
    @Composable fun efontertiaryLight(): Color = resolveToken("efontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, false)
    @Composable fun efontertiaryDark(): Color = resolveToken("efontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, true)
    @Composable fun ewontertiary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewontertiaryLight(context: Context): Color = resolveToken("ewontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, false, context)
    @Composable fun ewontertiaryDark(context: Context): Color = resolveToken("ewontertiary", EOnTertiaryLight::getResId, EOnTertiaryDark::getResId, true, context)

    @Composable fun etertiarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("etertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun etertiarycontainerLight(): Color = resolveToken("etertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, false)
    @Composable fun etertiarycontainerDark(): Color = resolveToken("etertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, true)
    @Composable fun eftertiarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eftertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun eftertiarycontainerLight(): Color = resolveToken("eftertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, false)
    @Composable fun eftertiarycontainerDark(): Color = resolveToken("eftertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, true)
    @Composable fun ewtertiarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewtertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewtertiarycontainerLight(context: Context): Color = resolveToken("ewtertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, false, context)
    @Composable fun ewtertiarycontainerDark(context: Context): Color = resolveToken("ewtertiarycontainer", ETertiaryContainerLight::getResId, ETertiaryContainerDark::getResId, true, context)

    @Composable fun eontertiarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun eontertiarycontainerLight(): Color = resolveToken("eontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, false)
    @Composable fun eontertiarycontainerDark(): Color = resolveToken("eontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, true)
    @Composable fun efontertiarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("efontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, systemInDarkTheme)
    @Composable fun efontertiarycontainerLight(): Color = resolveToken("efontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, false)
    @Composable fun efontertiarycontainerDark(): Color = resolveToken("efontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, true)
    @Composable fun ewontertiarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewontertiarycontainerLight(context: Context): Color = resolveToken("ewontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, false, context)
    @Composable fun ewontertiarycontainerDark(context: Context): Color = resolveToken("ewontertiarycontainer", EOnTertiaryContainerLight::getResId, EOnTertiaryContainerDark::getResId, true, context)

    @Composable fun etertiaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("etertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun etertiaryfixedLight(): Color = resolveToken("etertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, false)
    @Composable fun etertiaryfixedDark(): Color = resolveToken("etertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, true)
    @Composable fun eftertiaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("eftertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun eftertiaryfixedLight(): Color = resolveToken("eftertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, false)
    @Composable fun eftertiaryfixedDark(): Color = resolveToken("eftertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, true)
    @Composable fun ewtertiaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewtertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewtertiaryfixedLight(context: Context): Color = resolveToken("ewtertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, false, context)
    @Composable fun ewtertiaryfixedDark(context: Context): Color = resolveToken("ewtertiaryfixed", ETertiaryFixedLight::getResId, ETertiaryFixedDark::getResId, true, context)

    @Composable fun etertiaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("etertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun etertiaryfixeddimLight(): Color = resolveToken("etertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, false)
    @Composable fun etertiaryfixeddimDark(): Color = resolveToken("etertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, true)
    @Composable fun eftertiaryfixeddim(systemInDarkTheme: Boolean): Color = resolveToken("eftertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, systemInDarkTheme)
    @Composable fun eftertiaryfixeddimLight(): Color = resolveToken("eftertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, false)
    @Composable fun eftertiaryfixeddimDark(): Color = resolveToken("eftertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, true)
    @Composable fun ewtertiaryfixeddim(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewtertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, systemInDarkTheme, context)
    @Composable fun ewtertiaryfixeddimLight(context: Context): Color = resolveToken("ewtertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, false, context)
    @Composable fun ewtertiaryfixeddimDark(context: Context): Color = resolveToken("ewtertiaryfixeddim", ETertiaryFixedDimLight::getResId, ETertiaryFixedDimDark::getResId, true, context)

    @Composable fun eontertiaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("eontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun eontertiaryfixedLight(): Color = resolveToken("eontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, false)
    @Composable fun eontertiaryfixedDark(): Color = resolveToken("eontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, true)
    @Composable fun efontertiaryfixed(systemInDarkTheme: Boolean): Color = resolveToken("efontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, systemInDarkTheme)
    @Composable fun efontertiaryfixedLight(): Color = resolveToken("efontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, false)
    @Composable fun efontertiaryfixedDark(): Color = resolveToken("efontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, true)
    @Composable fun ewontertiaryfixed(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, systemInDarkTheme, context)
    @Composable fun ewontertiaryfixedLight(context: Context): Color = resolveToken("ewontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, false, context)
    @Composable fun ewontertiaryfixedDark(context: Context): Color = resolveToken("ewontertiaryfixed", EOnTertiaryFixedLight::getResId, EOnTertiaryFixedDark::getResId, true, context)

    @Composable fun eontertiaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("eontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun eontertiaryfixedvariantLight(): Color = resolveToken("eontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, false)
    @Composable fun eontertiaryfixedvariantDark(): Color = resolveToken("eontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, true)
    @Composable fun efontertiaryfixedvariant(systemInDarkTheme: Boolean): Color = resolveToken("efontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, systemInDarkTheme)
    @Composable fun efontertiaryfixedvariantLight(): Color = resolveToken("efontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, false)
    @Composable fun efontertiaryfixedvariantDark(): Color = resolveToken("efontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, true)
    @Composable fun ewontertiaryfixedvariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewontertiaryfixedvariantLight(context: Context): Color = resolveToken("ewontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, false, context)
    @Composable fun ewontertiaryfixedvariantDark(context: Context): Color = resolveToken("ewontertiaryfixedvariant", EOnTertiaryFixedVariantLight::getResId, EOnTertiaryFixedVariantDark::getResId, true, context)

    @Composable fun eerror(systemInDarkTheme: Boolean): Color = resolveToken("eerror", EErrorLight::getResId, EErrorDark::getResId, systemInDarkTheme)
    @Composable fun eerrorLight(): Color = resolveToken("eerror", EErrorLight::getResId, EErrorDark::getResId, false)
    @Composable fun eerrorDark(): Color = resolveToken("eerror", EErrorLight::getResId, EErrorDark::getResId, true)
    @Composable fun eferror(systemInDarkTheme: Boolean): Color = resolveToken("eferror", EErrorLight::getResId, EErrorDark::getResId, systemInDarkTheme)
    @Composable fun eferrorLight(): Color = resolveToken("eferror", EErrorLight::getResId, EErrorDark::getResId, false)
    @Composable fun eferrorDark(): Color = resolveToken("eferror", EErrorLight::getResId, EErrorDark::getResId, true)
    @Composable fun ewerror(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewerror", EErrorLight::getResId, EErrorDark::getResId, systemInDarkTheme, context)
    @Composable fun ewerrorLight(context: Context): Color = resolveToken("ewerror", EErrorLight::getResId, EErrorDark::getResId, false, context)
    @Composable fun ewerrorDark(context: Context): Color = resolveToken("ewerror", EErrorLight::getResId, EErrorDark::getResId, true, context)

    @Composable fun eonerror(systemInDarkTheme: Boolean): Color = resolveToken("eonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, systemInDarkTheme)
    @Composable fun eonerrorLight(): Color = resolveToken("eonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, false)
    @Composable fun eonerrorDark(): Color = resolveToken("eonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, true)
    @Composable fun efonerror(systemInDarkTheme: Boolean): Color = resolveToken("efonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, systemInDarkTheme)
    @Composable fun efonerrorLight(): Color = resolveToken("efonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, false)
    @Composable fun efonerrorDark(): Color = resolveToken("efonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, true)
    @Composable fun ewonerror(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonerrorLight(context: Context): Color = resolveToken("ewonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, false, context)
    @Composable fun ewonerrorDark(context: Context): Color = resolveToken("ewonerror", EOnErrorLight::getResId, EOnErrorDark::getResId, true, context)

    @Composable fun eerrorcontainer(systemInDarkTheme: Boolean): Color = resolveToken("eerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, systemInDarkTheme)
    @Composable fun eerrorcontainerLight(): Color = resolveToken("eerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, false)
    @Composable fun eerrorcontainerDark(): Color = resolveToken("eerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, true)
    @Composable fun eferrorcontainer(systemInDarkTheme: Boolean): Color = resolveToken("eferrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, systemInDarkTheme)
    @Composable fun eferrorcontainerLight(): Color = resolveToken("eferrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, false)
    @Composable fun eferrorcontainerDark(): Color = resolveToken("eferrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, true)
    @Composable fun ewerrorcontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewerrorcontainerLight(context: Context): Color = resolveToken("ewerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, false, context)
    @Composable fun ewerrorcontainerDark(context: Context): Color = resolveToken("ewerrorcontainer", EErrorContainerLight::getResId, EErrorContainerDark::getResId, true, context)

    @Composable fun eonerrorcontainer(systemInDarkTheme: Boolean): Color = resolveToken("eonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, systemInDarkTheme)
    @Composable fun eonerrorcontainerLight(): Color = resolveToken("eonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, false)
    @Composable fun eonerrorcontainerDark(): Color = resolveToken("eonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, true)
    @Composable fun efonerrorcontainer(systemInDarkTheme: Boolean): Color = resolveToken("efonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, systemInDarkTheme)
    @Composable fun efonerrorcontainerLight(): Color = resolveToken("efonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, false)
    @Composable fun efonerrorcontainerDark(): Color = resolveToken("efonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, true)
    @Composable fun ewonerrorcontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewonerrorcontainerLight(context: Context): Color = resolveToken("ewonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, false, context)
    @Composable fun ewonerrorcontainerDark(context: Context): Color = resolveToken("ewonerrorcontainer", EOnErrorContainerLight::getResId, EOnErrorContainerDark::getResId, true, context)

    @Composable fun eoutline(systemInDarkTheme: Boolean): Color = resolveToken("eoutline", EOutlineLight::getResId, EOutlineDark::getResId, systemInDarkTheme)
    @Composable fun eoutlineLight(): Color = resolveToken("eoutline", EOutlineLight::getResId, EOutlineDark::getResId, false)
    @Composable fun eoutlineDark(): Color = resolveToken("eoutline", EOutlineDark::getResId, EOutlineDark::getResId, true)
    @Composable fun efoutline(systemInDarkTheme: Boolean): Color = resolveToken("efoutline", EOutlineLight::getResId, EOutlineDark::getResId, systemInDarkTheme)
    @Composable fun efoutlineLight(): Color = resolveToken("efoutline", EOutlineLight::getResId, EOutlineDark::getResId, false)
    @Composable fun efoutlineDark(): Color = resolveToken("efoutline", EOutlineLight::getResId, EOutlineDark::getResId, true)
    @Composable fun ewoutline(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewoutline", EOutlineLight::getResId, EOutlineDark::getResId, systemInDarkTheme, context)
    @Composable fun ewoutlineLight(context: Context): Color = resolveToken("ewoutline", EOutlineLight::getResId, EOutlineDark::getResId, false, context)
    @Composable fun ewoutlineDark(context: Context): Color = resolveToken("ewoutline", EOutlineLight::getResId, EOutlineDark::getResId, true, context)

    @Composable fun eoutlinevariant(systemInDarkTheme: Boolean): Color = resolveToken("eoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, systemInDarkTheme)
    @Composable fun eoutlinevariantLight(): Color = resolveToken("eoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, false)
    @Composable fun eoutlinevariantDark(): Color = resolveToken("eoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, true)
    @Composable fun efoutlinevariant(systemInDarkTheme: Boolean): Color = resolveToken("efoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, systemInDarkTheme)
    @Composable fun efoutlinevariantLight(): Color = resolveToken("efoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, false)
    @Composable fun efoutlinevariantDark(): Color = resolveToken("efoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, true)
    @Composable fun ewoutlinevariant(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, systemInDarkTheme, context)
    @Composable fun ewoutlinevariantLight(context: Context): Color = resolveToken("ewoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, false, context)
    @Composable fun ewoutlinevariantDark(context: Context): Color = resolveToken("ewoutlinevariant", EOutlineVariantLight::getResId, EOutlineVariantDark::getResId, true, context)

    @Composable fun eerprimary(systemInDarkTheme: Boolean): Color = resolveToken("eerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, systemInDarkTheme)
    @Composable fun eerprimaryLight(): Color = resolveToken("eerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, false)
    @Composable fun eerprimaryDark(): Color = resolveToken("eerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, true)
    @Composable fun eferprimary(systemInDarkTheme: Boolean): Color = resolveToken("eferprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, systemInDarkTheme)
    @Composable fun eferprimaryLight(): Color = resolveToken("eferprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, false)
    @Composable fun eferprimaryDark(): Color = resolveToken("eferprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, true)
    @Composable fun ewerprimary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, systemInDarkTheme, context)
    @Composable fun ewerprimaryLight(context: Context): Color = resolveToken("ewerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, false, context)
    @Composable fun ewerprimaryDark(context: Context): Color = resolveToken("ewerprimary", EErprimaryLight::getResId, EErprimaryDark::getResId, true, context)

    @Composable fun eeronprimary(systemInDarkTheme: Boolean): Color = resolveToken("eeronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, systemInDarkTheme)
    @Composable fun eeronprimaryLight(): Color = resolveToken("eeronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, false)
    @Composable fun eeronprimaryDark(): Color = resolveToken("eeronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, true)
    @Composable fun eferonprimary(systemInDarkTheme: Boolean): Color = resolveToken("eferonprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, systemInDarkTheme)
    @Composable fun eferonprimaryLight(): Color = resolveToken("eferonprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, false)
    @Composable fun eferonprimaryDark(): Color = resolveToken("eferonprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, true)
    @Composable fun eweronprimary(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("eweronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, systemInDarkTheme, context)
    @Composable fun eweronprimaryLight(context: Context): Color = resolveToken("eweronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, false, context)
    @Composable fun eweronprimaryDark(context: Context): Color = resolveToken("eweronprimary", EEronprimaryLight::getResId, EEronprimaryDark::getResId, true, context)

    @Composable fun eerprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, systemInDarkTheme)
    @Composable fun eerprimarycontainerLight(): Color = resolveToken("eerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, false)
    @Composable fun eerprimarycontainerDark(): Color = resolveToken("eerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, true)
    @Composable fun eferprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eferprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, systemInDarkTheme)
    @Composable fun eferprimarycontainerLight(): Color = resolveToken("eferprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, false)
    @Composable fun eferprimarycontainerDark(): Color = resolveToken("eferprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, true)
    @Composable fun ewerprimarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("ewerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, systemInDarkTheme, context)
    @Composable fun ewerprimarycontainerLight(context: Context): Color = resolveToken("ewerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, false, context)
    @Composable fun ewerprimarycontainerDark(context: Context): Color = resolveToken("ewerprimarycontainer", EErprimarycontainerLight::getResId, EErprimarycontainerDark::getResId, true, context)

    @Composable fun eeronprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eeronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, systemInDarkTheme)
    @Composable fun eeronprimarycontainerLight(): Color = resolveToken("eeronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, false)
    @Composable fun eeronprimarycontainerDark(): Color = resolveToken("eeronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, true)
    @Composable fun eferonprimarycontainer(systemInDarkTheme: Boolean): Color = resolveToken("eferonprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, systemInDarkTheme)
    @Composable fun eferonprimarycontainerLight(): Color = resolveToken("eferonprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, false)
    @Composable fun eferonprimarycontainerDark(): Color = resolveToken("eferonprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, true)
    @Composable fun eweronprimarycontainer(context: Context, systemInDarkTheme: Boolean): Color = resolveToken("eweronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, systemInDarkTheme, context)
    @Composable fun eweronprimarycontainerLight(context: Context): Color = resolveToken("eweronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, false, context)
    @Composable fun eweronprimarycontainerDark(context: Context): Color = resolveToken("eweronprimarycontainer", EEronprimarycontainerLight::getResId, EEronprimarycontainerDark::getResId, true, context)
}
