package de.search.dw.search.ui.theme.ui.screen.debug

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.design_engine.layer3_logic.DesignEngineController
import com.example.design_engine.layer3_logic.AppTheme
import com.example.design_engine.layer3_logic.ThemeMode
import com.example.design_engine.layer4_ui.DesignEngineUI
import de.search.dw.search.ui.theme.ui.screen.ThemePreviewCard
import de.search.dw.search.ui.theme.ui.screen.findActivity

@Composable
fun FlutterDebugScreen() {
    // === DESIGN ENGINE (EF - Flutter Werte) ===
    val ebg = DesignEngineUI.efbackground
    val esv = DesignEngineUI.efsurfacevariant
    val ep = DesignEngineUI.efprimary
    val eonbg = DesignEngineUI.efonbackground
    val eonsv = DesignEngineUI.efonsurfacevariant
    
    val dayAccentColor = DesignEngineUI.efprimaryLight
    val nightAccentColor = DesignEngineUI.efprimaryDark

    val currentTheme = DesignEngineController.flutterTheme
    val currentMode = DesignEngineController.flutterThemeMode
    val isAmoled = DesignEngineController.flutterIsAmoled
    val isSystemDark = isSystemInDarkTheme()
    val isEffectiveDark = DesignEngineController.isEffectiveDark(isSystemDark) // Logic remains global

    // --- STATUSLEISTE KONTROLLE ---
    val context = LocalContext.current
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            context.findActivity()?.let { activity ->
                val window = activity.window
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isEffectiveDark
            }
        }
    }

    val sortedThemes = listOf(
        AppTheme.SYSTEM,
        AppTheme.STANDARD,
        AppTheme.BLUE,
        AppTheme.GREEN,
        AppTheme.RED,
        AppTheme.NOTHING
    )

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Back handled in ThemeActivity */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = eonbg
                    )
                }
                Text(
                    text = "Flutter Debug View (Read-Only)",
                    color = eonbg,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        },
        containerColor = ebg
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val isLandscape = maxWidth > 600.dp && maxHeight < maxWidth

            if (isLandscape) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier.weight(4f).fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        ThemePreviewCard(ep, ebg, esv, eonbg, eonbg)
                    }
                    Box(modifier = Modifier.weight(6f).fillMaxHeight()) {
                        DebugSettingsPanel(true, esv, ep, eonbg, eonsv, sortedThemes, currentTheme, currentMode, isAmoled, isEffectiveDark, dayAccentColor, nightAccentColor, isSystemDark)
                    }
                }
            } else {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier.weight(4f).fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        ThemePreviewCard(ep, ebg, esv, eonbg, eonbg)
                    }
                    Box(modifier = Modifier.weight(6f).fillMaxWidth()) {
                        DebugSettingsPanel(false, esv, ep, eonbg, eonsv, sortedThemes, currentTheme, currentMode, isAmoled, isEffectiveDark, dayAccentColor, nightAccentColor, isSystemDark)
                    }
                }
            }
        }
    }
}

@Composable
fun DebugSettingsPanel(
    isLandscape: Boolean,
    esv: Color,
    ep: Color,
    eonbg: Color,
    eonsv: Color,
    sortedThemes: List<AppTheme>,
    currentTheme: AppTheme,
    currentMode: ThemeMode,
    isAmoled: Boolean,
    isEffectiveDark: Boolean,
    dayAccentColor: Color,
    nightAccentColor: Color,
    isSystemDark: Boolean
) {
    val panelShape = if (isLandscape) RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp) else RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    val verticalPadding = if (isLandscape) 12.dp else 24.dp
    val sectionSpacer = if (isLandscape) 14.dp else 32.dp

    Surface(
        modifier = Modifier.fillMaxSize().shadow(10.dp, panelShape, clip = false),
        color = esv,
        shape = panelShape
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(vertical = verticalPadding)
        ) {
            Text(text = "Farbauswahl (Flutter)", color = eonbg, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 24.dp))
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()).padding(horizontal = 12.dp)) {
                sortedThemes.forEach { theme ->
                    val themeBubbleColor = DesignEngineController.efprimaryForTheme(theme, isSystemDark)
                    DebugColorCircle(theme.name, themeBubbleColor, eonsv, ep, currentTheme == theme)
                }
            }

            Spacer(modifier = Modifier.height(sectionSpacer))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 24.dp), thickness = 1.dp, color = eonbg.copy(alpha = 0.1f))
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            Text(text = "Lichtsteuerung (Flutter)", color = eonbg, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 24.dp))
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
                DebugLightCircle("Auto", currentMode == ThemeMode.SYSTEM, true, nightAccentColor, dayAccentColor, eonsv, ep)
                DebugLightCircle("Day", currentMode == ThemeMode.LIGHT, false, nightAccentColor, nightAccentColor, eonsv, ep)
                DebugLightCircle("Night", currentMode == ThemeMode.DARK, false, dayAccentColor, dayAccentColor, eonsv, ep)
            }

            if (isEffectiveDark) {
                Spacer(modifier = Modifier.height(sectionSpacer))
                Surface(
                    modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth(),
                    color = eonbg.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, eonbg.copy(alpha = 0.1f))
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Text(text = "Extra Dark Modus", color = eonbg, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                            Text(text = "Optimiert für AMOLED Displays", color = eonsv, fontSize = 12.sp)
                        }
                        Switch(
                            checked = isAmoled,
                            onCheckedChange = null,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = ep,
                                uncheckedThumbColor = Color.LightGray,
                                uncheckedTrackColor = eonbg.copy(alpha = 0.1f)
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(if (isLandscape) 24.dp else 48.dp))
        }
    }
}

@Composable
fun DebugColorCircle(label: String, color: Color, textColor: Color, selectionColor: Color, isSelected: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(90.dp)) {
        Box(modifier = Modifier.size(64.dp), contentAlignment = Alignment.Center) {
            if (isSelected) Box(modifier = Modifier.size(64.dp).border(2.5.dp, selectionColor, CircleShape))
            Box(modifier = Modifier.size(50.dp).clip(CircleShape).background(color).border(1.dp, Color.Black.copy(alpha = 0.1f), CircleShape))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = textColor, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center)
    }
}

@Composable
fun DebugLightCircle(label: String, isSelected: Boolean, isSplit: Boolean, fillColorLight: Color, fillColorDark: Color, textColor: Color, selectionColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(90.dp)) {
        Box(modifier = Modifier.size(64.dp), contentAlignment = Alignment.Center) {
            if (isSelected) Box(modifier = Modifier.size(64.dp).border(2.5.dp, selectionColor, CircleShape))
            Box(modifier = Modifier.size(50.dp).clip(CircleShape).then(if (isSplit) Modifier.background(brush = Brush.horizontalGradient(0.0f to fillColorLight, 0.5f to fillColorLight, 0.5f to fillColorDark, 1.0f to fillColorDark)) else Modifier.background(fillColorLight)).border(1.dp, Color.Black.copy(alpha = 0.1f), CircleShape))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = textColor, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center)
    }
}
