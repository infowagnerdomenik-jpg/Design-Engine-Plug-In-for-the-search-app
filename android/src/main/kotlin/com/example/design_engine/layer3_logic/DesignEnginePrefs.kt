package com.example.design_engine.layer3_logic

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.engineWidgetDataStore by preferencesDataStore(name = "design_engine_widget_prefs")

object DesignEnginePrefs {
    // --- WIDGET KEYS ---
    private val WIDGET_THEME = stringPreferencesKey("widget_theme")
    private val WIDGET_THEME_MODE = stringPreferencesKey("widget_theme_mode")
    private val WIDGET_IS_AMOLED = booleanPreferencesKey("widget_is_amoled")

    // --- APP (NATIVE) KEYS ---
    private val APP_THEME = stringPreferencesKey("app_theme")
    private val APP_THEME_MODE = stringPreferencesKey("app_theme_mode")
    private val APP_IS_AMOLED = booleanPreferencesKey("app_is_amoled")

    // ==========================================
    // WIDGET SPEICHERN & LADEN
    // ==========================================
    suspend fun saveWidgetState(context: Context, theme: AppTheme, mode: ThemeMode, isAmoled: Boolean) {
        context.engineWidgetDataStore.edit { prefs ->
            prefs[WIDGET_THEME] = theme.name
            prefs[WIDGET_THEME_MODE] = mode.name
            prefs[WIDGET_IS_AMOLED] = isAmoled
        }
    }

    suspend fun loadWidgetStateToController(context: Context) {
        val prefs = context.engineWidgetDataStore.data.first()
        val themeStr = prefs[WIDGET_THEME] ?: AppTheme.BLUE.name
        val modeStr = prefs[WIDGET_THEME_MODE] ?: ThemeMode.SYSTEM.name
        val isAmoled = prefs[WIDGET_IS_AMOLED] ?: false

        DesignEngineController.widgetTheme = try { AppTheme.valueOf(themeStr) } catch (e: Exception) { AppTheme.STANDARD }
        DesignEngineController.widgetThemeMode = try { ThemeMode.valueOf(modeStr) } catch (e: Exception) { ThemeMode.SYSTEM }
        DesignEngineController.widgetIsAmoled = isAmoled
    }

    // ==========================================
    // NATIVE APP SPEICHERN & LADEN
    // ==========================================
    suspend fun saveNativeAppState(context: Context, theme: AppTheme, mode: ThemeMode, isAmoled: Boolean) {
        context.engineWidgetDataStore.edit { prefs ->
            prefs[APP_THEME] = theme.name
            prefs[APP_THEME_MODE] = mode.name
            prefs[APP_IS_AMOLED] = isAmoled
        }
    }

    suspend fun loadNativeAppStateToController(context: Context) {
        val prefs = context.engineWidgetDataStore.data.first()
        val appThemeStr = prefs[APP_THEME] ?: AppTheme.BLUE.name
        val appModeStr = prefs[APP_THEME_MODE] ?: ThemeMode.SYSTEM.name
        val appAmoled = prefs[APP_IS_AMOLED] ?: false
        
        DesignEngineController.internalSetAppTheme(
            try { AppTheme.valueOf(appThemeStr) } catch (e: Exception) { AppTheme.STANDARD },
            try { ThemeMode.valueOf(appModeStr) } catch (e: Exception) { ThemeMode.SYSTEM },
            appAmoled
        )
    }
}
