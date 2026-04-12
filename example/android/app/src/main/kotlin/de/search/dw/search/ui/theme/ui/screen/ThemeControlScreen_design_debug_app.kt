package de.search.dw.search.ui.theme.ui.screen

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

/**
 * Hilfsfunktion um die Activity sicher aus dem Context zu extrahieren
 */
fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Composable
fun ThemeControlScreen() {
    // === DESIGN ENGINE (Live Werte) ===
    val ebg = DesignEngineUI.ebackground
    val esv = DesignEngineUI.esurfacevariant
    val ep = DesignEngineUI.eprimary
    val eonbg = DesignEngineUI.eonbackground
    val eonsv = DesignEngineUI.eonsurfacevariant
    
    val dayAccentColor = DesignEngineUI.eprimaryLight
    val nightAccentColor = DesignEngineUI.eprimaryDark

    val currentTheme = DesignEngineController.currentTheme
    val currentMode = DesignEngineController.themeMode
    val isAmoled = DesignEngineController.isAmoled
    val isSystemDark = isSystemInDarkTheme()
    val isEffectiveDark = DesignEngineController.isEffectiveDark(isSystemDark)

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
                IconButton(onClick = { /* In example app nothing to pop */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = eonbg
                    )
                }
                Text(
                    text = "Themen-Einstellungen",
                    color = eonbg,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        },
        containerColor = ebg
    ) { innerPadding ->
        // Navigationsleiste ignorieren wir durch manuelles Handling des Paddings
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            val isLandscape = maxWidth > 600.dp && maxHeight < maxWidth

            if (isLandscape) {
                Row(modifier = Modifier.fillMaxSize()) {
                    // LINKS: Vorschau
                    Box(
                        modifier = Modifier
                            .weight(4f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        ThemePreviewCard(
                            accentColor = ep,
                            backgroundColor = ebg,
                            surfaceColor = esv,
                            textColor = eonbg,
                            borderColor = eonbg
                        )
                    }
                    // RECHTS: Panel
                    Box(
                        modifier = Modifier
                            .weight(6f)
                            .fillMaxHeight()
                    ) {
                        SettingsPanel(
                            isLandscape = true,
                            esv = esv,
                            ep = ep,
                            eonbg = eonbg,
                            eonsv = eonsv,
                            sortedThemes = sortedThemes,
                            currentTheme = currentTheme,
                            currentMode = currentMode,
                            isAmoled = isAmoled,
                            isEffectiveDark = isEffectiveDark,
                            dayAccentColor = dayAccentColor,
                            nightAccentColor = nightAccentColor,
                            isSystemDark = isSystemDark
                        )
                    }
                }
            } else {
                // HOCHFORMAT
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .weight(4f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        ThemePreviewCard(
                            accentColor = ep,
                            backgroundColor = ebg,
                            surfaceColor = esv,
                            textColor = eonbg,
                            borderColor = eonbg
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(6f)
                            .fillMaxWidth()
                    ) {
                        SettingsPanel(
                            isLandscape = false,
                            esv = esv,
                            ep = ep,
                            eonbg = eonbg,
                            eonsv = eonsv,
                            sortedThemes = sortedThemes,
                            currentTheme = currentTheme,
                            currentMode = currentMode,
                            isAmoled = isAmoled,
                            isEffectiveDark = isEffectiveDark,
                            dayAccentColor = dayAccentColor,
                            nightAccentColor = nightAccentColor,
                            isSystemDark = isSystemDark
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsPanel(
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
    val panelShape = if (isLandscape) {
        RoundedCornerShape(topStart = 24.dp, bottomStart = 24.dp)
    } else {
        RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    }

    val verticalPadding = if (isLandscape) 12.dp else 24.dp
    val sectionSpacer = if (isLandscape) 14.dp else 32.dp

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .shadow(
                elevation = 10.dp,
                shape = panelShape,
                clip = false
            ),
        color = esv,
        shape = panelShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = verticalPadding)
        ) {
            // --- FARBAUSWAHL ---
            Text(
                text = "Farbauswahl",
                color = eonbg,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp)
            ) {
                sortedThemes.forEach { theme ->
                    val themeBubbleColor = DesignEngineController.eprimaryForTheme(theme, isSystemDark)
                    ColorCircle(
                        label = theme.name.lowercase().replaceFirstChar { it.uppercase() },
                        color = themeBubbleColor,
                        textColor = eonsv,
                        selectionColor = ep,
                        isSelected = currentTheme == theme,
                        onTap = { DesignEngineController.setTheme(theme) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(sectionSpacer))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 24.dp),
                thickness = 1.dp,
                color = eonbg.copy(alpha = 0.1f)
            )
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            // --- LICHTSTEUERUNG ---
            Text(
                text = "Lichtsteuerung",
                color = eonbg,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(if (isLandscape) 10.dp else 20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                LightModeCircle(
                    label = "Auto",
                    isSelected = currentMode == ThemeMode.SYSTEM,
                    isSplit = true,
                    fillColorLight = nightAccentColor,
                    fillColorDark = dayAccentColor,
                    textColor = eonsv,
                    selectionColor = ep,
                    onTap = { DesignEngineController.setThemeMode(ThemeMode.SYSTEM) }
                )
                LightModeCircle(
                    label = "Day",
                    isSelected = currentMode == ThemeMode.LIGHT,
                    isSplit = false,
                    fillColorLight = nightAccentColor,
                    fillColorDark = nightAccentColor,
                    textColor = eonsv,
                    selectionColor = ep,
                    onTap = { DesignEngineController.setThemeMode(ThemeMode.LIGHT) }
                )
                LightModeCircle(
                    label = "Night",
                    isSelected = currentMode == ThemeMode.DARK,
                    isSplit = false,
                    fillColorLight = dayAccentColor,
                    fillColorDark = dayAccentColor,
                    textColor = eonsv,
                    selectionColor = ep,
                    onTap = { DesignEngineController.setThemeMode(ThemeMode.DARK) }
                )
            }

            // --- EXTRA DARK MODUS (AMOLED) ---
            if (isEffectiveDark) {
                Spacer(modifier = Modifier.height(sectionSpacer))
                
                Surface(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    color = eonbg.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, eonbg.copy(alpha = 0.1f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Extra Dark Modus",
                                color = eonbg,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Optimiert für AMOLED Displays",
                                color = eonsv,
                                fontSize = 12.sp
                            )
                        }
                        Switch(
                            checked = isAmoled,
                            onCheckedChange = { DesignEngineController.setAmoled(it) },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = ep,
                                uncheckedThumbColor = Color.LightGray,
                                uncheckedTrackColor = eonbg.copy(alpha = 0.1f),
                                uncheckedBorderColor = Color.Transparent
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
fun ThemePreviewCard(
    accentColor: Color,
    backgroundColor: Color,
    surfaceColor: Color,
    textColor: Color,
    borderColor: Color
) {
    Surface(
        modifier = Modifier
            .size(280.dp, 180.dp)
            .shadow(15.dp, RoundedCornerShape(24.dp)),
        color = backgroundColor,
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, borderColor.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(accentColor)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Vorschau",
                color = textColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(140.dp, 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(surfaceColor)
            )
        }
    }
}

@Composable
fun ColorCircle(
    label: String,
    color: Color,
    isSelected: Boolean,
    textColor: Color,
    selectionColor: Color,
    onTap: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable(onClick = onTap, indication = null, interactionSource = null)
    ) {
        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .border(2.5.dp, selectionColor, CircleShape)
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color)
                    .border(1.dp, Color.Black.copy(alpha = 0.1f), CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = textColor,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LightModeCircle(
    label: String,
    isSelected: Boolean,
    isSplit: Boolean,
    fillColorLight: Color,
    fillColorDark: Color,
    textColor: Color,
    selectionColor: Color,
    onTap: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable(onClick = onTap, indication = null, interactionSource = null)
    ) {
        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .border(2.5.dp, selectionColor, CircleShape)
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .then(
                        if (isSplit) {
                            Modifier.background(
                                brush = Brush.horizontalGradient(
                                    0.0f to fillColorLight,
                                    0.5f to fillColorLight,
                                    0.5f to fillColorDark,
                                    1.0f to fillColorDark
                                )
                            )
                        } else {
                            Modifier.background(fillColorLight)
                        }
                    )
                    .border(1.dp, Color.Black.copy(alpha = 0.1f), CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = textColor,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}
