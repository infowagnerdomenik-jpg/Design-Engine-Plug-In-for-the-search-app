import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../layer1_raw/design_token.dart';
import 'package:dynamic_color/dynamic_color.dart';
import 'package:material_color_utilities/material_color_utilities.dart';
import 'package:flutter/services.dart';

import '../layer2_core/light/e_background_light.dart';
import '../layer2_core/dark/e_background_dark.dart';
import '../layer2_core/light/e_on_background_light.dart';
import '../layer2_core/dark/e_on_background_dark.dart';
import '../layer2_core/light/e_surface_light.dart';
import '../layer2_core/dark/e_surface_dark.dart';
import '../layer2_core/light/e_on_surface_light.dart';
import '../layer2_core/dark/e_on_surface_dark.dart';
import '../layer2_core/light/e_surface_variant_light.dart';
import '../layer2_core/dark/e_surface_variant_dark.dart';
import '../layer2_core/light/e_on_surface_variant_light.dart';
import '../layer2_core/dark/e_on_surface_variant_dark.dart';
import '../layer2_core/light/e_inverse_surface_light.dart';
import '../layer2_core/dark/e_inverse_surface_dark.dart';
import '../layer2_core/light/e_inverse_on_surface_light.dart';
import '../layer2_core/dark/e_inverse_on_surface_dark.dart';
import '../layer2_core/light/e_surface_bright_light.dart';
import '../layer2_core/dark/e_surface_bright_dark.dart';
import '../layer2_core/light/e_surface_dim_light.dart';
import '../layer2_core/dark/e_surface_dim_dark.dart';
import '../layer2_core/light/e_surface_container_low_light.dart';
import '../layer2_core/dark/e_surface_container_low_dark.dart';
import '../layer2_core/light/e_surface_container_high_light.dart';
import '../layer2_core/dark/e_surface_container_high_dark.dart';
import '../layer2_core/light/e_surface_container_lowest_light.dart';
import '../layer2_core/dark/e_surface_container_lowest_dark.dart';
import '../layer2_core/light/e_surface_container_highest_light.dart';
import '../layer2_core/dark/e_surface_container_highest_dark.dart';
import '../layer2_core/light/e_surface_container_light.dart';
import '../layer2_core/dark/e_surface_container_dark.dart';
import '../layer2_core/light/e_primary_light.dart';
import '../layer2_core/dark/e_primary_dark.dart';
import '../layer2_core/light/e_on_primary_light.dart';
import '../layer2_core/dark/e_on_primary_dark.dart';
import '../layer2_core/light/e_primary_container_light.dart';
import '../layer2_core/dark/e_primary_container_dark.dart';
import '../layer2_core/light/e_on_primary_container_light.dart';
import '../layer2_core/dark/e_on_primary_container_dark.dart';
import '../layer2_core/light/e_primary_fixed_light.dart';
import '../layer2_core/dark/e_primary_fixed_dark.dart';
import '../layer2_core/light/e_primary_fixed_dim_light.dart';
import '../layer2_core/dark/e_primary_fixed_dim_dark.dart';
import '../layer2_core/light/e_on_primary_fixed_light.dart';
import '../layer2_core/dark/e_on_primary_fixed_dark.dart';
import '../layer2_core/light/e_on_primary_fixed_variant_light.dart';
import '../layer2_core/dark/e_on_primary_fixed_variant_dark.dart';
import '../layer2_core/light/e_inverse_primary_light.dart';
import '../layer2_core/dark/e_inverse_primary_dark.dart';
import '../layer2_core/light/e_secondary_light.dart';
import '../layer2_core/dark/e_secondary_dark.dart';
import '../layer2_core/light/e_on_secondary_light.dart';
import '../layer2_core/dark/e_on_secondary_dark.dart';
import '../layer2_core/light/e_secondary_container_light.dart';
import '../layer2_core/dark/e_secondary_container_dark.dart';
import '../layer2_core/light/e_on_secondary_container_light.dart';
import '../layer2_core/dark/e_on_secondary_container_dark.dart';
import '../layer2_core/light/e_secondary_fixed_light.dart';
import '../layer2_core/dark/e_secondary_fixed_dark.dart';
import '../layer2_core/light/e_secondary_fixed_dim_light.dart';
import '../layer2_core/dark/e_secondary_fixed_dim_dark.dart';
import '../layer2_core/light/e_on_secondary_fixed_light.dart';
import '../layer2_core/dark/e_on_secondary_fixed_dark.dart';
import '../layer2_core/light/e_on_secondary_fixed_variant_light.dart';
import '../layer2_core/dark/e_on_secondary_fixed_variant_dark.dart';
import '../layer2_core/light/e_tertiary_light.dart';
import '../layer2_core/dark/e_tertiary_dark.dart';
import '../layer2_core/light/e_on_tertiary_light.dart';
import '../layer2_core/dark/e_on_tertiary_dark.dart';
import '../layer2_core/light/e_tertiary_container_light.dart';
import '../layer2_core/dark/e_tertiary_container_dark.dart';
import '../layer2_core/light/e_on_tertiary_container_light.dart';
import '../layer2_core/dark/e_on_tertiary_container_dark.dart';
import '../layer2_core/light/e_tertiary_fixed_light.dart';
import '../layer2_core/dark/e_tertiary_fixed_dark.dart';
import '../layer2_core/light/e_tertiary_fixed_dim_light.dart';
import '../layer2_core/dark/e_tertiary_fixed_dim_dark.dart';
import '../layer2_core/light/e_on_tertiary_fixed_light.dart';
import '../layer2_core/dark/e_on_tertiary_fixed_dark.dart';
import '../layer2_core/light/e_on_tertiary_fixed_variant_light.dart';
import '../layer2_core/dark/e_on_tertiary_fixed_variant_dark.dart';
import '../layer2_core/light/e_error_light.dart';
import '../layer2_core/dark/e_error_dark.dart';
import '../layer2_core/light/e_on_error_light.dart';
import '../layer2_core/dark/e_on_error_dark.dart';
import '../layer2_core/light/e_error_container_light.dart';
import '../layer2_core/dark/e_error_container_dark.dart';
import '../layer2_core/light/e_on_error_container_light.dart';
import '../layer2_core/dark/e_on_error_container_dark.dart';
import '../layer2_core/light/e_outline_light.dart';
import '../layer2_core/dark/e_outline_dark.dart';
import '../layer2_core/light/e_outline_variant_light.dart';
import '../layer2_core/dark/e_outline_variant_dark.dart';
import '../layer2_core/light/e_erprimary_light.dart';
import '../layer2_core/dark/e_erprimary_dark.dart';
import '../layer2_core/light/e_eronprimary_light.dart';
import '../layer2_core/dark/e_eronprimary_dark.dart';
import '../layer2_core/light/e_erprimarycontainer_light.dart';
import '../layer2_core/dark/e_erprimarycontainer_dark.dart';
import '../layer2_core/light/e_eronprimarycontainer_light.dart';
import '../layer2_core/dark/e_eronprimarycontainer_dark.dart';

enum AppTheme { system, standard, blue, green, red, nothing }

class DesignEngineController extends ChangeNotifier {
  static final DesignEngineController _instance = DesignEngineController._internal();
  factory DesignEngineController() => _instance;
  DesignEngineController._internal();

  static const MethodChannel _channel = MethodChannel('design_engine_sync');

  AppTheme currentTheme = AppTheme.blue;
  ThemeMode themeMode = ThemeMode.system;
  bool isAmoled = false;
  CorePalette? _systemPalette;

  // --- DIE ANDROID SCHUBLADE ---
  AppTheme androidTheme = AppTheme.standard;
  ThemeMode androidThemeMode = ThemeMode.system;
  bool androidIsAmoled = false;

  // --- DIE WIDGET SCHUBLADE ---
  AppTheme widgetTheme = AppTheme.blue;
  ThemeMode widgetThemeMode = ThemeMode.system;
  bool widgetIsAmoled = false;

  void setAndroidTheme(AppTheme theme) { androidTheme = theme; notifyListeners(); }
  void setAndroidThemeMode(ThemeMode mode) { androidThemeMode = mode; notifyListeners(); }
  void setAndroidIsAmoled(bool amoled) { androidIsAmoled = amoled; notifyListeners(); }

  void setWidgetTheme(AppTheme theme) { widgetTheme = theme; notifyListeners(); }
  void setWidgetThemeMode(ThemeMode mode) { widgetThemeMode = mode; notifyListeners(); }
  void setWidgetIsAmoled(bool amoled) { widgetIsAmoled = amoled; notifyListeners(); }

  Future<void> init() async {
    // 1. FLUTTER EIGENEN CACHE LADEN
    try {
      final prefs = await SharedPreferences.getInstance();
      final savedTheme = prefs.getString('flutter_theme');
      final savedMode = prefs.getString('flutter_theme_mode');
      final savedAmoled = prefs.getBool('flutter_is_amoled');

      if (savedTheme != null) {
        currentTheme = AppTheme.values.firstWhere((e) => e.name.toUpperCase() == savedTheme.toUpperCase(), orElse: () => AppTheme.blue);
      }
      if (savedMode != null) {
        themeMode = ThemeMode.values.firstWhere((e) => e.name.toUpperCase() == savedMode.toUpperCase(), orElse: () => ThemeMode.system);
      }
      if (savedAmoled != null) {
        isAmoled = savedAmoled;
      }
      // Daten direkt an Android pushen
      _syncFlutterToAndroid();
    } catch (e) {
      debugPrint('DesignEngineController: Error loading SharedPreferences $e');
    }

    // 2. ANDROID LISTENER SETUP
    _channel.setMethodCallHandler((call) async {
      if (call.method == 'syncAndroidToFlutter') {
        final args = call.arguments as Map<dynamic, dynamic>;
        if (args['theme'] != null) {
          androidTheme = AppTheme.values.firstWhere((e) => e.name.toUpperCase() == args['theme'].toString().toUpperCase(), orElse: () => AppTheme.standard);
        }
        if (args['mode'] != null) {
          androidThemeMode = ThemeMode.values.firstWhere((e) => e.name.toUpperCase() == args['mode'].toString().toUpperCase(), orElse: () => ThemeMode.system);
        }
        if (args['amoled'] != null) {
          androidIsAmoled = args['amoled'] as bool;
        }
        notifyListeners();
      }
    });

    try {
      _systemPalette = await DynamicColorPlugin.getCorePalette();
      notifyListeners();
    } catch (e) {
      debugPrint('DesignEngineController: Error loading CorePalette');
    }
  }

  Future<void> _saveFlutterState() async {
    try {
      final prefs = await SharedPreferences.getInstance();
      await prefs.setString('flutter_theme', currentTheme.name);
      await prefs.setString('flutter_theme_mode', themeMode.name);
      await prefs.setBool('flutter_is_amoled', isAmoled);
    } catch (e) {
      debugPrint("Fehler beim Speichern: $e");
    }
  }

  void setTheme(AppTheme theme) {
    currentTheme = theme;
    _saveFlutterState();
    _syncFlutterToAndroid();
    notifyListeners();
  }

  void setThemeMode(ThemeMode mode) {
    themeMode = mode;
    _saveFlutterState();
    _syncFlutterToAndroid();
    notifyListeners();
  }

  void setAmoled(bool amoled) {
    isAmoled = amoled;
    _saveFlutterState();
    _syncFlutterToAndroid();
    notifyListeners();
  }

  void _syncFlutterToAndroid() {
    _channel.invokeMethod('syncFlutterToAndroid', {
      'theme': currentTheme.name.toUpperCase(),
      'mode': themeMode.name.toUpperCase(),
      'amoled': isAmoled,
    });
  }

  /// Das fertige helle Paket für die MaterialApp
  ThemeData get lightTheme => _buildThemeData(Brightness.light);

  /// Das fertige dunkle Paket für die MaterialApp
  ThemeData get darkTheme => _buildThemeData(Brightness.dark);

  ThemeData _buildThemeData(Brightness brightness) {
    final bool isDark = brightness == Brightness.dark;

    return ThemeData(
      useMaterial3: true,
      brightness: brightness,
      colorScheme: ColorScheme.fromSeed(
        // Hier greifen wir auf deine interne Token-Logik zu
        seedColor: _resolveSeedWithoutContext(isDark),
        brightness: brightness,
      ),
    );
  }

  /// Bestimmt die Basis-Farbe (Seed) basierend auf deinen Layer-Token
  /// ohne einen BuildContext zu benötigen.
  Color _resolveSeedWithoutContext(bool isDark) {
    // Holt den Token für die Primärfarbe aus Layer 2
    final token = isDark
    ? EPrimaryDark.getToken(currentTheme)
    : EPrimaryLight.getToken(currentTheme);

    // Löst den Token auf (Hex-Wert oder Material You / System-Palette)
    if (token.isHex) return Color(token.hexValue!);
    if (token.isSystem && _systemPalette != null) {
      return Color(_extractFromPalette(token.systemId!, _systemPalette!));
    }

    // Fallback: Schwarz für Hell, Weiß für Dunkel (oder umgekehrt nach Belieben)
    return isDark ? const Color(0xFFFFFFFF) : const Color(0xFF000000);
  }

  bool isEffectiveDark(BuildContext context) {
    if (themeMode == ThemeMode.light) return false;
    if (themeMode == ThemeMode.dark) return true;
    return MediaQuery.of(context).platformBrightness == Brightness.dark;
  }

  final Map<String, Color> _amoledOverrides = {
    'ebackground': const Color(0xFF000000), 
    'esurface': const Color(0xFF000000),
  };

  Color eprimaryForTheme(AppTheme theme, BuildContext context) {
    final bool dark = isEffectiveDark(context);
    final DesignToken token = dark ? EPrimaryDark.getToken(theme) : EPrimaryLight.getToken(theme);
    return _resolveToken(token, context, dark);
  }

  Color eaprimaryForTheme(AppTheme theme, BuildContext context) {
    final activeThemeMode = androidThemeMode;
    bool dark;
    if (activeThemeMode == ThemeMode.light) { dark = false; }
    else if (activeThemeMode == ThemeMode.dark) { dark = true; }
    else { dark = MediaQuery.of(context).platformBrightness == Brightness.dark; }
    final DesignToken token = dark ? EPrimaryDark.getToken(theme) : EPrimaryLight.getToken(theme);
    return _resolveToken(token, context, dark);
  }

  Color ewprimaryForTheme(AppTheme theme, BuildContext context) {
    final activeThemeMode = widgetThemeMode;
    bool dark;
    if (activeThemeMode == ThemeMode.light) { dark = false; }
    else if (activeThemeMode == ThemeMode.dark) { dark = true; }
    else { dark = MediaQuery.of(context).platformBrightness == Brightness.dark; }
    final DesignToken token = dark ? EPrimaryDark.getToken(theme) : EPrimaryLight.getToken(theme);
    return _resolveToken(token, context, dark);
  }

  // --- DER TÜRSTEHER (ROUTING WEICHE) ---
  Color _routeAndResolve(String name, DesignToken Function(dynamic) lightRes, DesignToken Function(dynamic) darkRes, BuildContext context) {
    final isAndroidOrder = name.startsWith('ea');
    final isWidgetOrder = name.startsWith('ew');
    
    final activeTheme = isAndroidOrder ? androidTheme : (isWidgetOrder ? widgetTheme : currentTheme);
    final activeThemeMode = isAndroidOrder ? androidThemeMode : (isWidgetOrder ? widgetThemeMode : themeMode);
    final activeAmoled = isAndroidOrder ? androidIsAmoled : (isWidgetOrder ? widgetIsAmoled : isAmoled);

    bool dark;
    if (activeThemeMode == ThemeMode.light) { dark = false; }
    else if (activeThemeMode == ThemeMode.dark) { dark = true; }
    else { dark = MediaQuery.of(context).platformBrightness == Brightness.dark; }

    final baseName = (isAndroidOrder || isWidgetOrder) ? 'e' + name.substring(2) : name;
    if (dark && activeAmoled && _amoledOverrides.containsKey(baseName)) {
      return _amoledOverrides[baseName]!;
    }

    DesignToken token = dark ? darkRes(activeTheme) : lightRes(activeTheme);
    return _resolveToken(token, context, dark);
  }

  Color _resolveToken(DesignToken token, BuildContext context, bool isDark) {
    if (token.isHex) return Color(token.hexValue!);
    if (token.isSystem) {
      final String sysId = token.systemId!;
      if (sysId.startsWith('MaterialTheme.colorScheme.')) {
        return resolveMaterialCommand(context, sysId, isDark);
      }
      if (_systemPalette != null) return Color(_extractFromPalette(sysId, _systemPalette!));
      return isDark ? const Color(0xFF121212) : const Color(0xFFF0F0F0);
    }
    return isDark ? const Color(0xFF000000) : const Color(0xFFFFFFFF);
  }

  Color resolveMaterialCommand(BuildContext context, String command, bool isDark) {
    ColorScheme s;
    if (_systemPalette != null) {
      s = _systemPalette!.toColorScheme(
        brightness: isDark ? Brightness.dark : Brightness.light,
      );
    } else {
      s = Theme.of(context).colorScheme;
    }

    switch (command) {
      case 'MaterialTheme.colorScheme.background': return s.background;
      case 'MaterialTheme.colorScheme.onBackground': return s.onBackground;
      case 'MaterialTheme.colorScheme.surface': return s.surface;
      case 'MaterialTheme.colorScheme.onSurface': return s.onSurface;
      case 'MaterialTheme.colorScheme.surfaceVariant': return s.surfaceVariant;
      case 'MaterialTheme.colorScheme.onSurfaceVariant': return s.onSurfaceVariant;
      case 'MaterialTheme.colorScheme.inverseSurface': return s.inverseSurface;
      case 'MaterialTheme.colorScheme.onInverseSurface': return s.onInverseSurface;
      case 'MaterialTheme.colorScheme.surfaceBright': return s.surfaceBright;
      case 'MaterialTheme.colorScheme.surfaceDim': return s.surfaceDim;
      case 'MaterialTheme.colorScheme.surfaceContainerLow': return s.surfaceContainerLow;
      case 'MaterialTheme.colorScheme.surfaceContainerHigh': return s.surfaceContainerHigh;
      case 'MaterialTheme.colorScheme.surfaceContainerLowest': return s.surfaceContainerLowest;
      case 'MaterialTheme.colorScheme.surfaceContainerHighest': return s.surfaceContainerHighest;
      case 'MaterialTheme.colorScheme.surfaceContainer': return s.surfaceContainer;
      case 'MaterialTheme.colorScheme.primary': return s.primary;
      case 'MaterialTheme.colorScheme.onPrimary': return s.onPrimary;
      case 'MaterialTheme.colorScheme.primaryContainer': return s.primaryContainer;
      case 'MaterialTheme.colorScheme.onPrimaryContainer': return s.onPrimaryContainer;
      case 'MaterialTheme.colorScheme.primaryFixed': return s.primaryFixed;
      case 'MaterialTheme.colorScheme.primaryFixedDim': return s.primaryFixedDim;
      case 'MaterialTheme.colorScheme.onPrimaryFixed': return s.onPrimaryFixed;
      case 'MaterialTheme.colorScheme.onPrimaryFixedVariant': return s.onPrimaryFixedVariant;
      case 'MaterialTheme.colorScheme.inversePrimary': return s.inversePrimary;
      case 'MaterialTheme.colorScheme.secondary': return s.secondary;
      case 'MaterialTheme.colorScheme.onSecondary': return s.onSecondary;
      case 'MaterialTheme.colorScheme.secondaryContainer': return s.secondaryContainer;
      case 'MaterialTheme.colorScheme.onSecondaryContainer': return s.onSecondaryContainer;
      case 'MaterialTheme.colorScheme.secondaryFixed': return s.secondaryFixed;
      case 'MaterialTheme.colorScheme.secondaryFixedDim': return s.secondaryFixedDim;
      case 'MaterialTheme.colorScheme.onSecondaryFixed': return s.onSecondaryFixed;
      case 'MaterialTheme.colorScheme.onSecondaryFixedVariant': return s.onSecondaryFixedVariant;
      case 'MaterialTheme.colorScheme.tertiary': return s.tertiary;
      case 'MaterialTheme.colorScheme.onTertiary': return s.onTertiary;
      case 'MaterialTheme.colorScheme.tertiaryContainer': return s.tertiaryContainer;
      case 'MaterialTheme.colorScheme.onTertiaryContainer': return s.onTertiaryContainer;
      case 'MaterialTheme.colorScheme.tertiaryFixed': return s.tertiaryFixed;
      case 'MaterialTheme.colorScheme.tertiaryFixedDim': return s.tertiaryFixedDim;
      case 'MaterialTheme.colorScheme.onTertiaryFixed': return s.onTertiaryFixed;
      case 'MaterialTheme.colorScheme.onTertiaryFixedVariant': return s.onTertiaryFixedVariant;
      case 'MaterialTheme.colorScheme.error': return s.error;
      case 'MaterialTheme.colorScheme.onError': return s.onError;
      case 'MaterialTheme.colorScheme.errorContainer': return s.errorContainer;
      case 'MaterialTheme.colorScheme.onErrorContainer': return s.onErrorContainer;
      case 'MaterialTheme.colorScheme.outline': return s.outline;
      case 'MaterialTheme.colorScheme.outlineVariant': return s.outlineVariant;
      default: return s.primary;
    }
  }

  int _extractFromPalette(String sysId, CorePalette palette) {
    int tone = 40; 
    TonalPalette target = palette.primary;
    if (sysId.contains('neutral1')) target = palette.neutral;
    else if (sysId.contains('neutral2')) target = palette.neutralVariant;
    else if (sysId.contains('accent1')) target = palette.primary;
    else if (sysId.contains('accent2')) target = palette.secondary;
    else if (sysId.contains('accent3')) target = palette.tertiary;
    tone = _extractTone(sysId);
    return target.get(tone);
  }

  int _extractTone(String id) {
    final parts = id.split('_');
    final int resourceValue = int.tryParse(parts[parts.length - 1]) ?? 40;
    switch (resourceValue) {
      case 0: return 100; case 10: return 99; case 50: return 95; case 100: return 90;
      case 200: return 80; case 300: return 70; case 400: return 60; case 500: return 50;
      case 600: return 40; case 700: return 30; case 800: return 20; case 900: return 10;
      case 1000: return 0; default: return 40;
    }
  }

  Color ebackground(BuildContext context) {
    return _routeAndResolve('ebackground', EBackgroundLight.getToken, EBackgroundDark.getToken, context);
  }
  Color ebackgroundLight(BuildContext context) => _resolveToken(EBackgroundLight.getToken(currentTheme), context, false);
  Color ebackgroundDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('ebackground')) return _amoledOverrides['ebackground']!;
    return _resolveToken(EBackgroundDark.getToken(currentTheme), context, true);
  }

  Color eabackground(BuildContext context) => _routeAndResolve('eabackground', EBackgroundLight.getToken, EBackgroundDark.getToken, context);
  Color eabackgroundLight(BuildContext context) => _routeAndResolve('eabackgroundLight', EBackgroundLight.getToken, EBackgroundDark.getToken, context);
  Color eabackgroundDark(BuildContext context) => _routeAndResolve('eabackgroundDark', EBackgroundLight.getToken, EBackgroundDark.getToken, context);

  Color ewbackground(BuildContext context) => _routeAndResolve('ewbackground', EBackgroundLight.getToken, EBackgroundDark.getToken, context);
  Color ewbackgroundLight(BuildContext context) => _routeAndResolve('ewbackgroundLight', EBackgroundLight.getToken, EBackgroundDark.getToken, context);
  Color ewbackgroundDark(BuildContext context) => _routeAndResolve('ewbackgroundDark', EBackgroundLight.getToken, EBackgroundDark.getToken, context);

  Color eonbackground(BuildContext context) {
    return _routeAndResolve('eonbackground', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);
  }
  Color eonbackgroundLight(BuildContext context) => _resolveToken(EOnBackgroundLight.getToken(currentTheme), context, false);
  Color eonbackgroundDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonbackground')) return _amoledOverrides['eonbackground']!;
    return _resolveToken(EOnBackgroundDark.getToken(currentTheme), context, true);
  }

  Color eaonbackground(BuildContext context) => _routeAndResolve('eaonbackground', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);
  Color eaonbackgroundLight(BuildContext context) => _routeAndResolve('eaonbackgroundLight', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);
  Color eaonbackgroundDark(BuildContext context) => _routeAndResolve('eaonbackgroundDark', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);

  Color ewonbackground(BuildContext context) => _routeAndResolve('ewonbackground', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);
  Color ewonbackgroundLight(BuildContext context) => _routeAndResolve('ewonbackgroundLight', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);
  Color ewonbackgroundDark(BuildContext context) => _routeAndResolve('ewonbackgroundDark', EOnBackgroundLight.getToken, EOnBackgroundDark.getToken, context);

  Color esurface(BuildContext context) {
    return _routeAndResolve('esurface', ESurfaceLight.getToken, ESurfaceDark.getToken, context);
  }
  Color esurfaceLight(BuildContext context) => _resolveToken(ESurfaceLight.getToken(currentTheme), context, false);
  Color esurfaceDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurface')) return _amoledOverrides['esurface']!;
    return _resolveToken(ESurfaceDark.getToken(currentTheme), context, true);
  }

  Color easurface(BuildContext context) => _routeAndResolve('easurface', ESurfaceLight.getToken, ESurfaceDark.getToken, context);
  Color easurfaceLight(BuildContext context) => _routeAndResolve('easurfaceLight', ESurfaceLight.getToken, ESurfaceDark.getToken, context);
  Color easurfaceDark(BuildContext context) => _routeAndResolve('easurfaceDark', ESurfaceLight.getToken, ESurfaceDark.getToken, context);

  Color ewsurface(BuildContext context) => _routeAndResolve('ewsurface', ESurfaceLight.getToken, ESurfaceDark.getToken, context);
  Color ewsurfaceLight(BuildContext context) => _routeAndResolve('ewsurfaceLight', ESurfaceLight.getToken, ESurfaceDark.getToken, context);
  Color ewsurfaceDark(BuildContext context) => _routeAndResolve('ewsurfaceDark', ESurfaceLight.getToken, ESurfaceDark.getToken, context);

  Color eonsurface(BuildContext context) {
    return _routeAndResolve('eonsurface', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);
  }
  Color eonsurfaceLight(BuildContext context) => _resolveToken(EOnSurfaceLight.getToken(currentTheme), context, false);
  Color eonsurfaceDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsurface')) return _amoledOverrides['eonsurface']!;
    return _resolveToken(EOnSurfaceDark.getToken(currentTheme), context, true);
  }

  Color eaonsurface(BuildContext context) => _routeAndResolve('eaonsurface', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);
  Color eaonsurfaceLight(BuildContext context) => _routeAndResolve('eaonsurfaceLight', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);
  Color eaonsurfaceDark(BuildContext context) => _routeAndResolve('eaonsurfaceDark', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);

  Color ewonsurface(BuildContext context) => _routeAndResolve('ewonsurface', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);
  Color ewonsurfaceLight(BuildContext context) => _routeAndResolve('ewonsurfaceLight', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);
  Color ewonsurfaceDark(BuildContext context) => _routeAndResolve('ewonsurfaceDark', EOnSurfaceLight.getToken, EOnSurfaceDark.getToken, context);

  Color esurfacevariant(BuildContext context) {
    return _routeAndResolve('esurfacevariant', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);
  }
  Color esurfacevariantLight(BuildContext context) => _resolveToken(ESurfaceVariantLight.getToken(currentTheme), context, false);
  Color esurfacevariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacevariant')) return _amoledOverrides['esurfacevariant']!;
    return _resolveToken(ESurfaceVariantDark.getToken(currentTheme), context, true);
  }

  Color easurfacevariant(BuildContext context) => _routeAndResolve('easurfacevariant', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);
  Color easurfacevariantLight(BuildContext context) => _routeAndResolve('easurfacevariantLight', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);
  Color easurfacevariantDark(BuildContext context) => _routeAndResolve('easurfacevariantDark', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);

  Color ewsurfacevariant(BuildContext context) => _routeAndResolve('ewsurfacevariant', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);
  Color ewsurfacevariantLight(BuildContext context) => _routeAndResolve('ewsurfacevariantLight', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);
  Color ewsurfacevariantDark(BuildContext context) => _routeAndResolve('ewsurfacevariantDark', ESurfaceVariantLight.getToken, ESurfaceVariantDark.getToken, context);

  Color eonsurfacevariant(BuildContext context) {
    return _routeAndResolve('eonsurfacevariant', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);
  }
  Color eonsurfacevariantLight(BuildContext context) => _resolveToken(EOnSurfaceVariantLight.getToken(currentTheme), context, false);
  Color eonsurfacevariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsurfacevariant')) return _amoledOverrides['eonsurfacevariant']!;
    return _resolveToken(EOnSurfaceVariantDark.getToken(currentTheme), context, true);
  }

  Color eaonsurfacevariant(BuildContext context) => _routeAndResolve('eaonsurfacevariant', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);
  Color eaonsurfacevariantLight(BuildContext context) => _routeAndResolve('eaonsurfacevariantLight', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);
  Color eaonsurfacevariantDark(BuildContext context) => _routeAndResolve('eaonsurfacevariantDark', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);

  Color ewonsurfacevariant(BuildContext context) => _routeAndResolve('ewonsurfacevariant', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);
  Color ewonsurfacevariantLight(BuildContext context) => _routeAndResolve('ewonsurfacevariantLight', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);
  Color ewonsurfacevariantDark(BuildContext context) => _routeAndResolve('ewonsurfacevariantDark', EOnSurfaceVariantLight.getToken, EOnSurfaceVariantDark.getToken, context);

  Color einversesurface(BuildContext context) {
    return _routeAndResolve('einversesurface', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);
  }
  Color einversesurfaceLight(BuildContext context) => _resolveToken(EInverseSurfaceLight.getToken(currentTheme), context, false);
  Color einversesurfaceDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('einversesurface')) return _amoledOverrides['einversesurface']!;
    return _resolveToken(EInverseSurfaceDark.getToken(currentTheme), context, true);
  }

  Color eainversesurface(BuildContext context) => _routeAndResolve('eainversesurface', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);
  Color eainversesurfaceLight(BuildContext context) => _routeAndResolve('eainversesurfaceLight', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);
  Color eainversesurfaceDark(BuildContext context) => _routeAndResolve('eainversesurfaceDark', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);

  Color ewinversesurface(BuildContext context) => _routeAndResolve('ewinversesurface', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);
  Color ewinversesurfaceLight(BuildContext context) => _routeAndResolve('ewinversesurfaceLight', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);
  Color ewinversesurfaceDark(BuildContext context) => _routeAndResolve('ewinversesurfaceDark', EInverseSurfaceLight.getToken, EInverseSurfaceDark.getToken, context);

  Color einverseonsurface(BuildContext context) {
    return _routeAndResolve('einverseonsurface', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);
  }
  Color einverseonsurfaceLight(BuildContext context) => _resolveToken(EInverseOnSurfaceLight.getToken(currentTheme), context, false);
  Color einverseonsurfaceDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('einverseonsurface')) return _amoledOverrides['einverseonsurface']!;
    return _resolveToken(EInverseOnSurfaceDark.getToken(currentTheme), context, true);
  }

  Color eainverseonsurface(BuildContext context) => _routeAndResolve('eainverseonsurface', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);
  Color eainverseonsurfaceLight(BuildContext context) => _routeAndResolve('eainverseonsurfaceLight', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);
  Color eainverseonsurfaceDark(BuildContext context) => _routeAndResolve('eainverseonsurfaceDark', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);

  Color ewinverseonsurface(BuildContext context) => _routeAndResolve('ewinverseonsurface', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);
  Color ewinverseonsurfaceLight(BuildContext context) => _routeAndResolve('ewinverseonsurfaceLight', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);
  Color ewinverseonsurfaceDark(BuildContext context) => _routeAndResolve('ewinverseonsurfaceDark', EInverseOnSurfaceLight.getToken, EInverseOnSurfaceDark.getToken, context);

  Color esurfacebright(BuildContext context) {
    return _routeAndResolve('esurfacebright', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);
  }
  Color esurfacebrightLight(BuildContext context) => _resolveToken(ESurfaceBrightLight.getToken(currentTheme), context, false);
  Color esurfacebrightDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacebright')) return _amoledOverrides['esurfacebright']!;
    return _resolveToken(ESurfaceBrightDark.getToken(currentTheme), context, true);
  }

  Color easurfacebright(BuildContext context) => _routeAndResolve('easurfacebright', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);
  Color easurfacebrightLight(BuildContext context) => _routeAndResolve('easurfacebrightLight', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);
  Color easurfacebrightDark(BuildContext context) => _routeAndResolve('easurfacebrightDark', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);

  Color ewsurfacebright(BuildContext context) => _routeAndResolve('ewsurfacebright', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);
  Color ewsurfacebrightLight(BuildContext context) => _routeAndResolve('ewsurfacebrightLight', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);
  Color ewsurfacebrightDark(BuildContext context) => _routeAndResolve('ewsurfacebrightDark', ESurfaceBrightLight.getToken, ESurfaceBrightDark.getToken, context);

  Color esurfacedim(BuildContext context) {
    return _routeAndResolve('esurfacedim', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);
  }
  Color esurfacedimLight(BuildContext context) => _resolveToken(ESurfaceDimLight.getToken(currentTheme), context, false);
  Color esurfacedimDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacedim')) return _amoledOverrides['esurfacedim']!;
    return _resolveToken(ESurfaceDimDark.getToken(currentTheme), context, true);
  }

  Color easurfacedim(BuildContext context) => _routeAndResolve('easurfacedim', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);
  Color easurfacedimLight(BuildContext context) => _routeAndResolve('easurfacedimLight', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);
  Color easurfacedimDark(BuildContext context) => _routeAndResolve('easurfacedimDark', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);

  Color ewsurfacedim(BuildContext context) => _routeAndResolve('ewsurfacedim', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);
  Color ewsurfacedimLight(BuildContext context) => _routeAndResolve('ewsurfacedimLight', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);
  Color ewsurfacedimDark(BuildContext context) => _routeAndResolve('ewsurfacedimDark', ESurfaceDimLight.getToken, ESurfaceDimDark.getToken, context);

  Color esurfacecontainerlow(BuildContext context) {
    return _routeAndResolve('esurfacecontainerlow', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);
  }
  Color esurfacecontainerlowLight(BuildContext context) => _resolveToken(ESurfaceContainerLowLight.getToken(currentTheme), context, false);
  Color esurfacecontainerlowDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacecontainerlow')) return _amoledOverrides['esurfacecontainerlow']!;
    return _resolveToken(ESurfaceContainerLowDark.getToken(currentTheme), context, true);
  }

  Color easurfacecontainerlow(BuildContext context) => _routeAndResolve('easurfacecontainerlow', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);
  Color easurfacecontainerlowLight(BuildContext context) => _routeAndResolve('easurfacecontainerlowLight', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);
  Color easurfacecontainerlowDark(BuildContext context) => _routeAndResolve('easurfacecontainerlowDark', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);

  Color ewsurfacecontainerlow(BuildContext context) => _routeAndResolve('ewsurfacecontainerlow', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);
  Color ewsurfacecontainerlowLight(BuildContext context) => _routeAndResolve('ewsurfacecontainerlowLight', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);
  Color ewsurfacecontainerlowDark(BuildContext context) => _routeAndResolve('ewsurfacecontainerlowDark', ESurfaceContainerLowLight.getToken, ESurfaceContainerLowDark.getToken, context);

  Color esurfacecontainerhigh(BuildContext context) {
    return _routeAndResolve('esurfacecontainerhigh', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);
  }
  Color esurfacecontainerhighLight(BuildContext context) => _resolveToken(ESurfaceContainerHighLight.getToken(currentTheme), context, false);
  Color esurfacecontainerhighDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacecontainerhigh')) return _amoledOverrides['esurfacecontainerhigh']!;
    return _resolveToken(ESurfaceContainerHighDark.getToken(currentTheme), context, true);
  }

  Color easurfacecontainerhigh(BuildContext context) => _routeAndResolve('easurfacecontainerhigh', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);
  Color easurfacecontainerhighLight(BuildContext context) => _routeAndResolve('easurfacecontainerhighLight', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);
  Color easurfacecontainerhighDark(BuildContext context) => _routeAndResolve('easurfacecontainerhighDark', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);

  Color ewsurfacecontainerhigh(BuildContext context) => _routeAndResolve('ewsurfacecontainerhigh', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);
  Color ewsurfacecontainerhighLight(BuildContext context) => _routeAndResolve('ewsurfacecontainerhighLight', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);
  Color ewsurfacecontainerhighDark(BuildContext context) => _routeAndResolve('ewsurfacecontainerhighDark', ESurfaceContainerHighLight.getToken, ESurfaceContainerHighDark.getToken, context);

  Color esurfacecontainerlowest(BuildContext context) {
    return _routeAndResolve('esurfacecontainerlowest', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);
  }
  Color esurfacecontainerlowestLight(BuildContext context) => _resolveToken(ESurfaceContainerLowestLight.getToken(currentTheme), context, false);
  Color esurfacecontainerlowestDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacecontainerlowest')) return _amoledOverrides['esurfacecontainerlowest']!;
    return _resolveToken(ESurfaceContainerLowestDark.getToken(currentTheme), context, true);
  }

  Color easurfacecontainerlowest(BuildContext context) => _routeAndResolve('easurfacecontainerlowest', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);
  Color easurfacecontainerlowestLight(BuildContext context) => _routeAndResolve('easurfacecontainerlowestLight', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);
  Color easurfacecontainerlowestDark(BuildContext context) => _routeAndResolve('easurfacecontainerlowestDark', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);

  Color ewsurfacecontainerlowest(BuildContext context) => _routeAndResolve('ewsurfacecontainerlowest', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);
  Color ewsurfacecontainerlowestLight(BuildContext context) => _routeAndResolve('ewsurfacecontainerlowestLight', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);
  Color ewsurfacecontainerlowestDark(BuildContext context) => _routeAndResolve('ewsurfacecontainerlowestDark', ESurfaceContainerLowestLight.getToken, ESurfaceContainerLowestDark.getToken, context);

  Color esurfacecontainerhighest(BuildContext context) {
    return _routeAndResolve('esurfacecontainerhighest', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);
  }
  Color esurfacecontainerhighestLight(BuildContext context) => _resolveToken(ESurfaceContainerHighestLight.getToken(currentTheme), context, false);
  Color esurfacecontainerhighestDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacecontainerhighest')) return _amoledOverrides['esurfacecontainerhighest']!;
    return _resolveToken(ESurfaceContainerHighestDark.getToken(currentTheme), context, true);
  }

  Color easurfacecontainerhighest(BuildContext context) => _routeAndResolve('easurfacecontainerhighest', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);
  Color easurfacecontainerhighestLight(BuildContext context) => _routeAndResolve('easurfacecontainerhighestLight', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);
  Color easurfacecontainerhighestDark(BuildContext context) => _routeAndResolve('easurfacecontainerhighestDark', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);

  Color ewsurfacecontainerhighest(BuildContext context) => _routeAndResolve('ewsurfacecontainerhighest', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);
  Color ewsurfacecontainerhighestLight(BuildContext context) => _routeAndResolve('ewsurfacecontainerhighestLight', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);
  Color ewsurfacecontainerhighestDark(BuildContext context) => _routeAndResolve('ewsurfacecontainerhighestDark', ESurfaceContainerHighestLight.getToken, ESurfaceContainerHighestDark.getToken, context);

  Color esurfacecontainer(BuildContext context) {
    return _routeAndResolve('esurfacecontainer', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);
  }
  Color esurfacecontainerLight(BuildContext context) => _resolveToken(ESurfaceContainerLight.getToken(currentTheme), context, false);
  Color esurfacecontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esurfacecontainer')) return _amoledOverrides['esurfacecontainer']!;
    return _resolveToken(ESurfaceContainerDark.getToken(currentTheme), context, true);
  }

  Color easurfacecontainer(BuildContext context) => _routeAndResolve('easurfacecontainer', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);
  Color easurfacecontainerLight(BuildContext context) => _routeAndResolve('easurfacecontainerLight', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);
  Color easurfacecontainerDark(BuildContext context) => _routeAndResolve('easurfacecontainerDark', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);

  Color ewsurfacecontainer(BuildContext context) => _routeAndResolve('ewsurfacecontainer', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);
  Color ewsurfacecontainerLight(BuildContext context) => _routeAndResolve('ewsurfacecontainerLight', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);
  Color ewsurfacecontainerDark(BuildContext context) => _routeAndResolve('ewsurfacecontainerDark', ESurfaceContainerLight.getToken, ESurfaceContainerDark.getToken, context);

  Color eprimary(BuildContext context) {
    return _routeAndResolve('eprimary', EPrimaryLight.getToken, EPrimaryDark.getToken, context);
  }
  Color eprimaryLight(BuildContext context) => _resolveToken(EPrimaryLight.getToken(currentTheme), context, false);
  Color eprimaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eprimary')) return _amoledOverrides['eprimary']!;
    return _resolveToken(EPrimaryDark.getToken(currentTheme), context, true);
  }

  Color eaprimary(BuildContext context) => _routeAndResolve('eaprimary', EPrimaryLight.getToken, EPrimaryDark.getToken, context);
  Color eaprimaryLight(BuildContext context) => _routeAndResolve('eaprimaryLight', EPrimaryLight.getToken, EPrimaryDark.getToken, context);
  Color eaprimaryDark(BuildContext context) => _routeAndResolve('eaprimaryDark', EPrimaryLight.getToken, EPrimaryDark.getToken, context);

  Color ewprimary(BuildContext context) => _routeAndResolve('ewprimary', EPrimaryLight.getToken, EPrimaryDark.getToken, context);
  Color ewprimaryLight(BuildContext context) => _routeAndResolve('ewprimaryLight', EPrimaryLight.getToken, EPrimaryDark.getToken, context);
  Color ewprimaryDark(BuildContext context) => _routeAndResolve('ewprimaryDark', EPrimaryLight.getToken, EPrimaryDark.getToken, context);

  Color eonprimary(BuildContext context) {
    return _routeAndResolve('eonprimary', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);
  }
  Color eonprimaryLight(BuildContext context) => _resolveToken(EOnPrimaryLight.getToken(currentTheme), context, false);
  Color eonprimaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonprimary')) return _amoledOverrides['eonprimary']!;
    return _resolveToken(EOnPrimaryDark.getToken(currentTheme), context, true);
  }

  Color eaonprimary(BuildContext context) => _routeAndResolve('eaonprimary', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);
  Color eaonprimaryLight(BuildContext context) => _routeAndResolve('eaonprimaryLight', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);
  Color eaonprimaryDark(BuildContext context) => _routeAndResolve('eaonprimaryDark', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);

  Color ewonprimary(BuildContext context) => _routeAndResolve('ewonprimary', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);
  Color ewonprimaryLight(BuildContext context) => _routeAndResolve('ewonprimaryLight', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);
  Color ewonprimaryDark(BuildContext context) => _routeAndResolve('ewonprimaryDark', EOnPrimaryLight.getToken, EOnPrimaryDark.getToken, context);

  Color eprimarycontainer(BuildContext context) {
    return _routeAndResolve('eprimarycontainer', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);
  }
  Color eprimarycontainerLight(BuildContext context) => _resolveToken(EPrimaryContainerLight.getToken(currentTheme), context, false);
  Color eprimarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eprimarycontainer')) return _amoledOverrides['eprimarycontainer']!;
    return _resolveToken(EPrimaryContainerDark.getToken(currentTheme), context, true);
  }

  Color eaprimarycontainer(BuildContext context) => _routeAndResolve('eaprimarycontainer', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);
  Color eaprimarycontainerLight(BuildContext context) => _routeAndResolve('eaprimarycontainerLight', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);
  Color eaprimarycontainerDark(BuildContext context) => _routeAndResolve('eaprimarycontainerDark', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);

  Color ewprimarycontainer(BuildContext context) => _routeAndResolve('ewprimarycontainer', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);
  Color ewprimarycontainerLight(BuildContext context) => _routeAndResolve('ewprimarycontainerLight', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);
  Color ewprimarycontainerDark(BuildContext context) => _routeAndResolve('ewprimarycontainerDark', EPrimaryContainerLight.getToken, EPrimaryContainerDark.getToken, context);

  Color eonprimarycontainer(BuildContext context) {
    return _routeAndResolve('eonprimarycontainer', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);
  }
  Color eonprimarycontainerLight(BuildContext context) => _resolveToken(EOnPrimaryContainerLight.getToken(currentTheme), context, false);
  Color eonprimarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonprimarycontainer')) return _amoledOverrides['eonprimarycontainer']!;
    return _resolveToken(EOnPrimaryContainerDark.getToken(currentTheme), context, true);
  }

  Color eaonprimarycontainer(BuildContext context) => _routeAndResolve('eaonprimarycontainer', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);
  Color eaonprimarycontainerLight(BuildContext context) => _routeAndResolve('eaonprimarycontainerLight', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);
  Color eaonprimarycontainerDark(BuildContext context) => _routeAndResolve('eaonprimarycontainerDark', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);

  Color ewonprimarycontainer(BuildContext context) => _routeAndResolve('ewonprimarycontainer', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);
  Color ewonprimarycontainerLight(BuildContext context) => _routeAndResolve('ewonprimarycontainerLight', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);
  Color ewonprimarycontainerDark(BuildContext context) => _routeAndResolve('ewonprimarycontainerDark', EOnPrimaryContainerLight.getToken, EOnPrimaryContainerDark.getToken, context);

  Color eprimaryfixed(BuildContext context) {
    return _routeAndResolve('eprimaryfixed', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);
  }
  Color eprimaryfixedLight(BuildContext context) => _resolveToken(EPrimaryFixedLight.getToken(currentTheme), context, false);
  Color eprimaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eprimaryfixed')) return _amoledOverrides['eprimaryfixed']!;
    return _resolveToken(EPrimaryFixedDark.getToken(currentTheme), context, true);
  }

  Color eaprimaryfixed(BuildContext context) => _routeAndResolve('eaprimaryfixed', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);
  Color eaprimaryfixedLight(BuildContext context) => _routeAndResolve('eaprimaryfixedLight', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);
  Color eaprimaryfixedDark(BuildContext context) => _routeAndResolve('eaprimaryfixedDark', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);

  Color ewprimaryfixed(BuildContext context) => _routeAndResolve('ewprimaryfixed', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);
  Color ewprimaryfixedLight(BuildContext context) => _routeAndResolve('ewprimaryfixedLight', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);
  Color ewprimaryfixedDark(BuildContext context) => _routeAndResolve('ewprimaryfixedDark', EPrimaryFixedLight.getToken, EPrimaryFixedDark.getToken, context);

  Color eprimaryfixeddim(BuildContext context) {
    return _routeAndResolve('eprimaryfixeddim', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);
  }
  Color eprimaryfixeddimLight(BuildContext context) => _resolveToken(EPrimaryFixedDimLight.getToken(currentTheme), context, false);
  Color eprimaryfixeddimDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eprimaryfixeddim')) return _amoledOverrides['eprimaryfixeddim']!;
    return _resolveToken(EPrimaryFixedDimDark.getToken(currentTheme), context, true);
  }

  Color eaprimaryfixeddim(BuildContext context) => _routeAndResolve('eaprimaryfixeddim', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);
  Color eaprimaryfixeddimLight(BuildContext context) => _routeAndResolve('eaprimaryfixeddimLight', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);
  Color eaprimaryfixeddimDark(BuildContext context) => _routeAndResolve('eaprimaryfixeddimDark', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);

  Color ewprimaryfixeddim(BuildContext context) => _routeAndResolve('ewprimaryfixeddim', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);
  Color ewprimaryfixeddimLight(BuildContext context) => _routeAndResolve('ewprimaryfixeddimLight', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);
  Color ewprimaryfixeddimDark(BuildContext context) => _routeAndResolve('ewprimaryfixeddimDark', EPrimaryFixedDimLight.getToken, EPrimaryFixedDimDark.getToken, context);

  Color eonprimaryfixed(BuildContext context) {
    return _routeAndResolve('eonprimaryfixed', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);
  }
  Color eonprimaryfixedLight(BuildContext context) => _resolveToken(EOnPrimaryFixedLight.getToken(currentTheme), context, false);
  Color eonprimaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonprimaryfixed')) return _amoledOverrides['eonprimaryfixed']!;
    return _resolveToken(EOnPrimaryFixedDark.getToken(currentTheme), context, true);
  }

  Color eaonprimaryfixed(BuildContext context) => _routeAndResolve('eaonprimaryfixed', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);
  Color eaonprimaryfixedLight(BuildContext context) => _routeAndResolve('eaonprimaryfixedLight', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);
  Color eaonprimaryfixedDark(BuildContext context) => _routeAndResolve('eaonprimaryfixedDark', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);

  Color ewonprimaryfixed(BuildContext context) => _routeAndResolve('ewonprimaryfixed', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);
  Color ewonprimaryfixedLight(BuildContext context) => _routeAndResolve('ewonprimaryfixedLight', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);
  Color ewonprimaryfixedDark(BuildContext context) => _routeAndResolve('ewonprimaryfixedDark', EOnPrimaryFixedLight.getToken, EOnPrimaryFixedDark.getToken, context);

  Color eonprimaryfixedvariant(BuildContext context) {
    return _routeAndResolve('eonprimaryfixedvariant', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);
  }
  Color eonprimaryfixedvariantLight(BuildContext context) => _resolveToken(EOnPrimaryFixedVariantLight.getToken(currentTheme), context, false);
  Color eonprimaryfixedvariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonprimaryfixedvariant')) return _amoledOverrides['eonprimaryfixedvariant']!;
    return _resolveToken(EOnPrimaryFixedVariantDark.getToken(currentTheme), context, true);
  }

  Color eaonprimaryfixedvariant(BuildContext context) => _routeAndResolve('eaonprimaryfixedvariant', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);
  Color eaonprimaryfixedvariantLight(BuildContext context) => _routeAndResolve('eaonprimaryfixedvariantLight', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);
  Color eaonprimaryfixedvariantDark(BuildContext context) => _routeAndResolve('eaonprimaryfixedvariantDark', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);

  Color ewonprimaryfixedvariant(BuildContext context) => _routeAndResolve('ewonprimaryfixedvariant', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);
  Color ewonprimaryfixedvariantLight(BuildContext context) => _routeAndResolve('ewonprimaryfixedvariantLight', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);
  Color ewonprimaryfixedvariantDark(BuildContext context) => _routeAndResolve('ewonprimaryfixedvariantDark', EOnPrimaryFixedVariantLight.getToken, EOnPrimaryFixedVariantDark.getToken, context);

  Color einverseprimary(BuildContext context) {
    return _routeAndResolve('einverseprimary', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);
  }
  Color einverseprimaryLight(BuildContext context) => _resolveToken(EInversePrimaryLight.getToken(currentTheme), context, false);
  Color einverseprimaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('einverseprimary')) return _amoledOverrides['einverseprimary']!;
    return _resolveToken(EInversePrimaryDark.getToken(currentTheme), context, true);
  }

  Color eainverseprimary(BuildContext context) => _routeAndResolve('eainverseprimary', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);
  Color eainverseprimaryLight(BuildContext context) => _routeAndResolve('eainverseprimaryLight', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);
  Color eainverseprimaryDark(BuildContext context) => _routeAndResolve('eainverseprimaryDark', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);

  Color ewinverseprimary(BuildContext context) => _routeAndResolve('ewinverseprimary', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);
  Color ewinverseprimaryLight(BuildContext context) => _routeAndResolve('ewinverseprimaryLight', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);
  Color ewinverseprimaryDark(BuildContext context) => _routeAndResolve('ewinverseprimaryDark', EInversePrimaryLight.getToken, EInversePrimaryDark.getToken, context);

  Color esecondary(BuildContext context) {
    return _routeAndResolve('esecondary', ESecondaryLight.getToken, ESecondaryDark.getToken, context);
  }
  Color esecondaryLight(BuildContext context) => _resolveToken(ESecondaryLight.getToken(currentTheme), context, false);
  Color esecondaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esecondary')) return _amoledOverrides['esecondary']!;
    return _resolveToken(ESecondaryDark.getToken(currentTheme), context, true);
  }

  Color easecondary(BuildContext context) => _routeAndResolve('easecondary', ESecondaryLight.getToken, ESecondaryDark.getToken, context);
  Color easecondaryLight(BuildContext context) => _routeAndResolve('easecondaryLight', ESecondaryLight.getToken, ESecondaryDark.getToken, context);
  Color easecondaryDark(BuildContext context) => _routeAndResolve('easecondaryDark', ESecondaryLight.getToken, ESecondaryDark.getToken, context);

  Color ewsecondary(BuildContext context) => _routeAndResolve('ewsecondary', ESecondaryLight.getToken, ESecondaryDark.getToken, context);
  Color ewsecondaryLight(BuildContext context) => _routeAndResolve('ewsecondaryLight', ESecondaryLight.getToken, ESecondaryDark.getToken, context);
  Color ewsecondaryDark(BuildContext context) => _routeAndResolve('ewsecondaryDark', ESecondaryLight.getToken, ESecondaryDark.getToken, context);

  Color eonsecondary(BuildContext context) {
    return _routeAndResolve('eonsecondary', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);
  }
  Color eonsecondaryLight(BuildContext context) => _resolveToken(EOnSecondaryLight.getToken(currentTheme), context, false);
  Color eonsecondaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsecondary')) return _amoledOverrides['eonsecondary']!;
    return _resolveToken(EOnSecondaryDark.getToken(currentTheme), context, true);
  }

  Color eaonsecondary(BuildContext context) => _routeAndResolve('eaonsecondary', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);
  Color eaonsecondaryLight(BuildContext context) => _routeAndResolve('eaonsecondaryLight', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);
  Color eaonsecondaryDark(BuildContext context) => _routeAndResolve('eaonsecondaryDark', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);

  Color ewonsecondary(BuildContext context) => _routeAndResolve('ewonsecondary', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);
  Color ewonsecondaryLight(BuildContext context) => _routeAndResolve('ewonsecondaryLight', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);
  Color ewonsecondaryDark(BuildContext context) => _routeAndResolve('ewonsecondaryDark', EOnSecondaryLight.getToken, EOnSecondaryDark.getToken, context);

  Color esecondarycontainer(BuildContext context) {
    return _routeAndResolve('esecondarycontainer', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);
  }
  Color esecondarycontainerLight(BuildContext context) => _resolveToken(ESecondaryContainerLight.getToken(currentTheme), context, false);
  Color esecondarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esecondarycontainer')) return _amoledOverrides['esecondarycontainer']!;
    return _resolveToken(ESecondaryContainerDark.getToken(currentTheme), context, true);
  }

  Color easecondarycontainer(BuildContext context) => _routeAndResolve('easecondarycontainer', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);
  Color easecondarycontainerLight(BuildContext context) => _routeAndResolve('easecondarycontainerLight', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);
  Color easecondarycontainerDark(BuildContext context) => _routeAndResolve('easecondarycontainerDark', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);

  Color ewsecondarycontainer(BuildContext context) => _routeAndResolve('ewsecondarycontainer', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);
  Color ewsecondarycontainerLight(BuildContext context) => _routeAndResolve('ewsecondarycontainerLight', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);
  Color ewsecondarycontainerDark(BuildContext context) => _routeAndResolve('ewsecondarycontainerDark', ESecondaryContainerLight.getToken, ESecondaryContainerDark.getToken, context);

  Color eonsecondarycontainer(BuildContext context) {
    return _routeAndResolve('eonsecondarycontainer', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);
  }
  Color eonsecondarycontainerLight(BuildContext context) => _resolveToken(EOnSecondaryContainerLight.getToken(currentTheme), context, false);
  Color eonsecondarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsecondarycontainer')) return _amoledOverrides['eonsecondarycontainer']!;
    return _resolveToken(EOnSecondaryContainerDark.getToken(currentTheme), context, true);
  }

  Color eaonsecondarycontainer(BuildContext context) => _routeAndResolve('eaonsecondarycontainer', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);
  Color eaonsecondarycontainerLight(BuildContext context) => _routeAndResolve('eaonsecondarycontainerLight', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);
  Color eaonsecondarycontainerDark(BuildContext context) => _routeAndResolve('eaonsecondarycontainerDark', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);

  Color ewonsecondarycontainer(BuildContext context) => _routeAndResolve('ewonsecondarycontainer', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);
  Color ewonsecondarycontainerLight(BuildContext context) => _routeAndResolve('ewonsecondarycontainerLight', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);
  Color ewonsecondarycontainerDark(BuildContext context) => _routeAndResolve('ewonsecondarycontainerDark', EOnSecondaryContainerLight.getToken, EOnSecondaryContainerDark.getToken, context);

  Color esecondaryfixed(BuildContext context) {
    return _routeAndResolve('esecondaryfixed', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);
  }
  Color esecondaryfixedLight(BuildContext context) => _resolveToken(ESecondaryFixedLight.getToken(currentTheme), context, false);
  Color esecondaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esecondaryfixed')) return _amoledOverrides['esecondaryfixed']!;
    return _resolveToken(ESecondaryFixedDark.getToken(currentTheme), context, true);
  }

  Color easecondaryfixed(BuildContext context) => _routeAndResolve('easecondaryfixed', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);
  Color easecondaryfixedLight(BuildContext context) => _routeAndResolve('easecondaryfixedLight', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);
  Color easecondaryfixedDark(BuildContext context) => _routeAndResolve('easecondaryfixedDark', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);

  Color ewsecondaryfixed(BuildContext context) => _routeAndResolve('ewsecondaryfixed', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);
  Color ewsecondaryfixedLight(BuildContext context) => _routeAndResolve('ewsecondaryfixedLight', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);
  Color ewsecondaryfixedDark(BuildContext context) => _routeAndResolve('ewsecondaryfixedDark', ESecondaryFixedLight.getToken, ESecondaryFixedDark.getToken, context);

  Color esecondaryfixeddim(BuildContext context) {
    return _routeAndResolve('esecondaryfixeddim', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);
  }
  Color esecondaryfixeddimLight(BuildContext context) => _resolveToken(ESecondaryFixedDimLight.getToken(currentTheme), context, false);
  Color esecondaryfixeddimDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('esecondaryfixeddim')) return _amoledOverrides['esecondaryfixeddim']!;
    return _resolveToken(ESecondaryFixedDimDark.getToken(currentTheme), context, true);
  }

  Color easecondaryfixeddim(BuildContext context) => _routeAndResolve('easecondaryfixeddim', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);
  Color easecondaryfixeddimLight(BuildContext context) => _routeAndResolve('easecondaryfixeddimLight', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);
  Color easecondaryfixeddimDark(BuildContext context) => _routeAndResolve('easecondaryfixeddimDark', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);

  Color ewsecondaryfixeddim(BuildContext context) => _routeAndResolve('ewsecondaryfixeddim', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);
  Color ewsecondaryfixeddimLight(BuildContext context) => _routeAndResolve('ewsecondaryfixeddimLight', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);
  Color ewsecondaryfixeddimDark(BuildContext context) => _routeAndResolve('ewsecondaryfixeddimDark', ESecondaryFixedDimLight.getToken, ESecondaryFixedDimDark.getToken, context);

  Color eonsecondaryfixed(BuildContext context) {
    return _routeAndResolve('eonsecondaryfixed', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);
  }
  Color eonsecondaryfixedLight(BuildContext context) => _resolveToken(EOnSecondaryFixedLight.getToken(currentTheme), context, false);
  Color eonsecondaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsecondaryfixed')) return _amoledOverrides['eonsecondaryfixed']!;
    return _resolveToken(EOnSecondaryFixedDark.getToken(currentTheme), context, true);
  }

  Color eaonsecondaryfixed(BuildContext context) => _routeAndResolve('eaonsecondaryfixed', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);
  Color eaonsecondaryfixedLight(BuildContext context) => _routeAndResolve('eaonsecondaryfixedLight', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);
  Color eaonsecondaryfixedDark(BuildContext context) => _routeAndResolve('eaonsecondaryfixedDark', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);

  Color ewonsecondaryfixed(BuildContext context) => _routeAndResolve('ewonsecondaryfixed', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);
  Color ewonsecondaryfixedLight(BuildContext context) => _routeAndResolve('ewonsecondaryfixedLight', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);
  Color ewonsecondaryfixedDark(BuildContext context) => _routeAndResolve('ewonsecondaryfixedDark', EOnSecondaryFixedLight.getToken, EOnSecondaryFixedDark.getToken, context);

  Color eonsecondaryfixedvariant(BuildContext context) {
    return _routeAndResolve('eonsecondaryfixedvariant', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);
  }
  Color eonsecondaryfixedvariantLight(BuildContext context) => _resolveToken(EOnSecondaryFixedVariantLight.getToken(currentTheme), context, false);
  Color eonsecondaryfixedvariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonsecondaryfixedvariant')) return _amoledOverrides['eonsecondaryfixedvariant']!;
    return _resolveToken(EOnSecondaryFixedVariantDark.getToken(currentTheme), context, true);
  }

  Color eaonsecondaryfixedvariant(BuildContext context) => _routeAndResolve('eaonsecondaryfixedvariant', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);
  Color eaonsecondaryfixedvariantLight(BuildContext context) => _routeAndResolve('eaonsecondaryfixedvariantLight', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);
  Color eaonsecondaryfixedvariantDark(BuildContext context) => _routeAndResolve('eaonsecondaryfixedvariantDark', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);

  Color ewonsecondaryfixedvariant(BuildContext context) => _routeAndResolve('ewonsecondaryfixedvariant', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);
  Color ewonsecondaryfixedvariantLight(BuildContext context) => _routeAndResolve('ewonsecondaryfixedvariantLight', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);
  Color ewonsecondaryfixedvariantDark(BuildContext context) => _routeAndResolve('ewonsecondaryfixedvariantDark', EOnSecondaryFixedVariantLight.getToken, EOnSecondaryFixedVariantDark.getToken, context);

  Color etertiary(BuildContext context) {
    return _routeAndResolve('etertiary', ETertiaryLight.getToken, ETertiaryDark.getToken, context);
  }
  Color etertiaryLight(BuildContext context) => _resolveToken(ETertiaryLight.getToken(currentTheme), context, false);
  Color etertiaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('etertiary')) return _amoledOverrides['etertiary']!;
    return _resolveToken(ETertiaryDark.getToken(currentTheme), context, true);
  }

  Color eatertiary(BuildContext context) => _routeAndResolve('eatertiary', ETertiaryLight.getToken, ETertiaryDark.getToken, context);
  Color eatertiaryLight(BuildContext context) => _routeAndResolve('eatertiaryLight', ETertiaryLight.getToken, ETertiaryDark.getToken, context);
  Color eatertiaryDark(BuildContext context) => _routeAndResolve('eatertiaryDark', ETertiaryLight.getToken, ETertiaryDark.getToken, context);

  Color ewtertiary(BuildContext context) => _routeAndResolve('ewtertiary', ETertiaryLight.getToken, ETertiaryDark.getToken, context);
  Color ewtertiaryLight(BuildContext context) => _routeAndResolve('ewtertiaryLight', ETertiaryLight.getToken, ETertiaryDark.getToken, context);
  Color ewtertiaryDark(BuildContext context) => _routeAndResolve('ewtertiaryDark', ETertiaryLight.getToken, ETertiaryDark.getToken, context);

  Color eontertiary(BuildContext context) {
    return _routeAndResolve('eontertiary', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);
  }
  Color eontertiaryLight(BuildContext context) => _resolveToken(EOnTertiaryLight.getToken(currentTheme), context, false);
  Color eontertiaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eontertiary')) return _amoledOverrides['eontertiary']!;
    return _resolveToken(EOnTertiaryDark.getToken(currentTheme), context, true);
  }

  Color eaontertiary(BuildContext context) => _routeAndResolve('eaontertiary', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);
  Color eaontertiaryLight(BuildContext context) => _routeAndResolve('eaontertiaryLight', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);
  Color eaontertiaryDark(BuildContext context) => _routeAndResolve('eaontertiaryDark', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);

  Color ewontertiary(BuildContext context) => _routeAndResolve('ewontertiary', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);
  Color ewontertiaryLight(BuildContext context) => _routeAndResolve('ewontertiaryLight', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);
  Color ewontertiaryDark(BuildContext context) => _routeAndResolve('ewontertiaryDark', EOnTertiaryLight.getToken, EOnTertiaryDark.getToken, context);

  Color etertiarycontainer(BuildContext context) {
    return _routeAndResolve('etertiarycontainer', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);
  }
  Color etertiarycontainerLight(BuildContext context) => _resolveToken(ETertiaryContainerLight.getToken(currentTheme), context, false);
  Color etertiarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('etertiarycontainer')) return _amoledOverrides['etertiarycontainer']!;
    return _resolveToken(ETertiaryContainerDark.getToken(currentTheme), context, true);
  }

  Color eatertiarycontainer(BuildContext context) => _routeAndResolve('eatertiarycontainer', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);
  Color eatertiarycontainerLight(BuildContext context) => _routeAndResolve('eatertiarycontainerLight', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);
  Color eatertiarycontainerDark(BuildContext context) => _routeAndResolve('eatertiarycontainerDark', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);

  Color ewtertiarycontainer(BuildContext context) => _routeAndResolve('ewtertiarycontainer', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);
  Color ewtertiarycontainerLight(BuildContext context) => _routeAndResolve('ewtertiarycontainerLight', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);
  Color ewtertiarycontainerDark(BuildContext context) => _routeAndResolve('ewtertiarycontainerDark', ETertiaryContainerLight.getToken, ETertiaryContainerDark.getToken, context);

  Color eontertiarycontainer(BuildContext context) {
    return _routeAndResolve('eontertiarycontainer', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);
  }
  Color eontertiarycontainerLight(BuildContext context) => _resolveToken(EOnTertiaryContainerLight.getToken(currentTheme), context, false);
  Color eontertiarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eontertiarycontainer')) return _amoledOverrides['eontertiarycontainer']!;
    return _resolveToken(EOnTertiaryContainerDark.getToken(currentTheme), context, true);
  }

  Color eaontertiarycontainer(BuildContext context) => _routeAndResolve('eaontertiarycontainer', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);
  Color eaontertiarycontainerLight(BuildContext context) => _routeAndResolve('eaontertiarycontainerLight', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);
  Color eaontertiarycontainerDark(BuildContext context) => _routeAndResolve('eaontertiarycontainerDark', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);

  Color ewontertiarycontainer(BuildContext context) => _routeAndResolve('ewontertiarycontainer', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);
  Color ewontertiarycontainerLight(BuildContext context) => _routeAndResolve('ewontertiarycontainerLight', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);
  Color ewontertiarycontainerDark(BuildContext context) => _routeAndResolve('ewontertiarycontainerDark', EOnTertiaryContainerLight.getToken, EOnTertiaryContainerDark.getToken, context);

  Color etertiaryfixed(BuildContext context) {
    return _routeAndResolve('etertiaryfixed', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);
  }
  Color etertiaryfixedLight(BuildContext context) => _resolveToken(ETertiaryFixedLight.getToken(currentTheme), context, false);
  Color etertiaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('etertiaryfixed')) return _amoledOverrides['etertiaryfixed']!;
    return _resolveToken(ETertiaryFixedDark.getToken(currentTheme), context, true);
  }

  Color eatertiaryfixed(BuildContext context) => _routeAndResolve('eatertiaryfixed', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);
  Color eatertiaryfixedLight(BuildContext context) => _routeAndResolve('eatertiaryfixedLight', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);
  Color eatertiaryfixedDark(BuildContext context) => _routeAndResolve('eatertiaryfixedDark', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);

  Color ewtertiaryfixed(BuildContext context) => _routeAndResolve('ewtertiaryfixed', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);
  Color ewtertiaryfixedLight(BuildContext context) => _routeAndResolve('ewtertiaryfixedLight', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);
  Color ewtertiaryfixedDark(BuildContext context) => _routeAndResolve('ewtertiaryfixedDark', ETertiaryFixedLight.getToken, ETertiaryFixedDark.getToken, context);

  Color etertiaryfixeddim(BuildContext context) {
    return _routeAndResolve('etertiaryfixeddim', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);
  }
  Color etertiaryfixeddimLight(BuildContext context) => _resolveToken(ETertiaryFixedDimLight.getToken(currentTheme), context, false);
  Color etertiaryfixeddimDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('etertiaryfixeddim')) return _amoledOverrides['etertiaryfixeddim']!;
    return _resolveToken(ETertiaryFixedDimDark.getToken(currentTheme), context, true);
  }

  Color eatertiaryfixeddim(BuildContext context) => _routeAndResolve('eatertiaryfixeddim', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);
  Color eatertiaryfixeddimLight(BuildContext context) => _routeAndResolve('eatertiaryfixeddimLight', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);
  Color eatertiaryfixeddimDark(BuildContext context) => _routeAndResolve('eatertiaryfixeddimDark', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);

  Color ewtertiaryfixeddim(BuildContext context) => _routeAndResolve('ewtertiaryfixeddim', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);
  Color ewtertiaryfixeddimLight(BuildContext context) => _routeAndResolve('ewtertiaryfixeddimLight', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);
  Color ewtertiaryfixeddimDark(BuildContext context) => _routeAndResolve('ewtertiaryfixeddimDark', ETertiaryFixedDimLight.getToken, ETertiaryFixedDimDark.getToken, context);

  Color eontertiaryfixed(BuildContext context) {
    return _routeAndResolve('eontertiaryfixed', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);
  }
  Color eontertiaryfixedLight(BuildContext context) => _resolveToken(EOnTertiaryFixedLight.getToken(currentTheme), context, false);
  Color eontertiaryfixedDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eontertiaryfixed')) return _amoledOverrides['eontertiaryfixed']!;
    return _resolveToken(EOnTertiaryFixedDark.getToken(currentTheme), context, true);
  }

  Color eaontertiaryfixed(BuildContext context) => _routeAndResolve('eaontertiaryfixed', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);
  Color eaontertiaryfixedLight(BuildContext context) => _routeAndResolve('eaontertiaryfixedLight', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);
  Color eaontertiaryfixedDark(BuildContext context) => _routeAndResolve('eaontertiaryfixedDark', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);

  Color ewontertiaryfixed(BuildContext context) => _routeAndResolve('ewontertiaryfixed', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);
  Color ewontertiaryfixedLight(BuildContext context) => _routeAndResolve('ewontertiaryfixedLight', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);
  Color ewontertiaryfixedDark(BuildContext context) => _routeAndResolve('ewontertiaryfixedDark', EOnTertiaryFixedLight.getToken, EOnTertiaryFixedDark.getToken, context);

  Color eontertiaryfixedvariant(BuildContext context) {
    return _routeAndResolve('eontertiaryfixedvariant', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);
  }
  Color eontertiaryfixedvariantLight(BuildContext context) => _resolveToken(EOnTertiaryFixedVariantLight.getToken(currentTheme), context, false);
  Color eontertiaryfixedvariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eontertiaryfixedvariant')) return _amoledOverrides['eontertiaryfixedvariant']!;
    return _resolveToken(EOnTertiaryFixedVariantDark.getToken(currentTheme), context, true);
  }

  Color eaontertiaryfixedvariant(BuildContext context) => _routeAndResolve('eaontertiaryfixedvariant', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);
  Color eaontertiaryfixedvariantLight(BuildContext context) => _routeAndResolve('eaontertiaryfixedvariantLight', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);
  Color eaontertiaryfixedvariantDark(BuildContext context) => _routeAndResolve('eaontertiaryfixedvariantDark', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);

  Color ewontertiaryfixedvariant(BuildContext context) => _routeAndResolve('ewontertiaryfixedvariant', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);
  Color ewontertiaryfixedvariantLight(BuildContext context) => _routeAndResolve('ewontertiaryfixedvariantLight', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);
  Color ewontertiaryfixedvariantDark(BuildContext context) => _routeAndResolve('ewontertiaryfixedvariantDark', EOnTertiaryFixedVariantLight.getToken, EOnTertiaryFixedVariantDark.getToken, context);

  Color eerror(BuildContext context) {
    return _routeAndResolve('eerror', EErrorLight.getToken, EErrorDark.getToken, context);
  }
  Color eerrorLight(BuildContext context) => _resolveToken(EErrorLight.getToken(currentTheme), context, false);
  Color eerrorDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eerror')) return _amoledOverrides['eerror']!;
    return _resolveToken(EErrorDark.getToken(currentTheme), context, true);
  }

  Color eaerror(BuildContext context) => _routeAndResolve('eaerror', EErrorLight.getToken, EErrorDark.getToken, context);
  Color eaerrorLight(BuildContext context) => _routeAndResolve('eaerrorLight', EErrorLight.getToken, EErrorDark.getToken, context);
  Color eaerrorDark(BuildContext context) => _routeAndResolve('eaerrorDark', EErrorLight.getToken, EErrorDark.getToken, context);

  Color ewerror(BuildContext context) => _routeAndResolve('ewerror', EErrorLight.getToken, EErrorDark.getToken, context);
  Color ewerrorLight(BuildContext context) => _routeAndResolve('ewerrorLight', EErrorLight.getToken, EErrorDark.getToken, context);
  Color ewerrorDark(BuildContext context) => _routeAndResolve('ewerrorDark', EErrorLight.getToken, EErrorDark.getToken, context);

  Color eonerror(BuildContext context) {
    return _routeAndResolve('eonerror', EOnErrorLight.getToken, EOnErrorDark.getToken, context);
  }
  Color eonerrorLight(BuildContext context) => _resolveToken(EOnErrorLight.getToken(currentTheme), context, false);
  Color eonerrorDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonerror')) return _amoledOverrides['eonerror']!;
    return _resolveToken(EOnErrorDark.getToken(currentTheme), context, true);
  }

  Color eaonerror(BuildContext context) => _routeAndResolve('eaonerror', EOnErrorLight.getToken, EOnErrorDark.getToken, context);
  Color eaonerrorLight(BuildContext context) => _routeAndResolve('eaonerrorLight', EOnErrorLight.getToken, EOnErrorDark.getToken, context);
  Color eaonerrorDark(BuildContext context) => _routeAndResolve('eaonerrorDark', EOnErrorLight.getToken, EOnErrorDark.getToken, context);

  Color ewonerror(BuildContext context) => _routeAndResolve('ewonerror', EOnErrorLight.getToken, EOnErrorDark.getToken, context);
  Color ewonerrorLight(BuildContext context) => _routeAndResolve('ewonerrorLight', EOnErrorLight.getToken, EOnErrorDark.getToken, context);
  Color ewonerrorDark(BuildContext context) => _routeAndResolve('ewonerrorDark', EOnErrorLight.getToken, EOnErrorDark.getToken, context);

  Color eerrorcontainer(BuildContext context) {
    return _routeAndResolve('eerrorcontainer', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);
  }
  Color eerrorcontainerLight(BuildContext context) => _resolveToken(EErrorContainerLight.getToken(currentTheme), context, false);
  Color eerrorcontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eerrorcontainer')) return _amoledOverrides['eerrorcontainer']!;
    return _resolveToken(EErrorContainerDark.getToken(currentTheme), context, true);
  }

  Color eaerrorcontainer(BuildContext context) => _routeAndResolve('eaerrorcontainer', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);
  Color eaerrorcontainerLight(BuildContext context) => _routeAndResolve('eaerrorcontainerLight', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);
  Color eaerrorcontainerDark(BuildContext context) => _routeAndResolve('eaerrorcontainerDark', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);

  Color ewerrorcontainer(BuildContext context) => _routeAndResolve('ewerrorcontainer', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);
  Color ewerrorcontainerLight(BuildContext context) => _routeAndResolve('ewerrorcontainerLight', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);
  Color ewerrorcontainerDark(BuildContext context) => _routeAndResolve('ewerrorcontainerDark', EErrorContainerLight.getToken, EErrorContainerDark.getToken, context);

  Color eonerrorcontainer(BuildContext context) {
    return _routeAndResolve('eonerrorcontainer', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);
  }
  Color eonerrorcontainerLight(BuildContext context) => _resolveToken(EOnErrorContainerLight.getToken(currentTheme), context, false);
  Color eonerrorcontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eonerrorcontainer')) return _amoledOverrides['eonerrorcontainer']!;
    return _resolveToken(EOnErrorContainerDark.getToken(currentTheme), context, true);
  }

  Color eaonerrorcontainer(BuildContext context) => _routeAndResolve('eaonerrorcontainer', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);
  Color eaonerrorcontainerLight(BuildContext context) => _routeAndResolve('eaonerrorcontainerLight', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);
  Color eaonerrorcontainerDark(BuildContext context) => _routeAndResolve('eaonerrorcontainerDark', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);

  Color ewonerrorcontainer(BuildContext context) => _routeAndResolve('ewonerrorcontainer', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);
  Color ewonerrorcontainerLight(BuildContext context) => _routeAndResolve('ewonerrorcontainerLight', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);
  Color ewonerrorcontainerDark(BuildContext context) => _routeAndResolve('ewonerrorcontainerDark', EOnErrorContainerLight.getToken, EOnErrorContainerDark.getToken, context);

  Color eoutline(BuildContext context) {
    return _routeAndResolve('eoutline', EOutlineLight.getToken, EOutlineDark.getToken, context);
  }
  Color eoutlineLight(BuildContext context) => _resolveToken(EOutlineLight.getToken(currentTheme), context, false);
  Color eoutlineDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eoutline')) return _amoledOverrides['eoutline']!;
    return _resolveToken(EOutlineDark.getToken(currentTheme), context, true);
  }

  Color eaoutline(BuildContext context) => _routeAndResolve('eaoutline', EOutlineLight.getToken, EOutlineDark.getToken, context);
  Color eaoutlineLight(BuildContext context) => _routeAndResolve('eaoutlineLight', EOutlineLight.getToken, EOutlineDark.getToken, context);
  Color eaoutlineDark(BuildContext context) => _routeAndResolve('eaoutlineDark', EOutlineLight.getToken, EOutlineDark.getToken, context);

  Color ewoutline(BuildContext context) => _routeAndResolve('ewoutline', EOutlineLight.getToken, EOutlineDark.getToken, context);
  Color ewoutlineLight(BuildContext context) => _routeAndResolve('ewoutlineLight', EOutlineLight.getToken, EOutlineDark.getToken, context);
  Color ewoutlineDark(BuildContext context) => _routeAndResolve('ewoutlineDark', EOutlineLight.getToken, EOutlineDark.getToken, context);

  Color eoutlinevariant(BuildContext context) {
    return _routeAndResolve('eoutlinevariant', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);
  }
  Color eoutlinevariantLight(BuildContext context) => _resolveToken(EOutlineVariantLight.getToken(currentTheme), context, false);
  Color eoutlinevariantDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eoutlinevariant')) return _amoledOverrides['eoutlinevariant']!;
    return _resolveToken(EOutlineVariantDark.getToken(currentTheme), context, true);
  }

  Color eaoutlinevariant(BuildContext context) => _routeAndResolve('eaoutlinevariant', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);
  Color eaoutlinevariantLight(BuildContext context) => _routeAndResolve('eaoutlinevariantLight', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);
  Color eaoutlinevariantDark(BuildContext context) => _routeAndResolve('eaoutlinevariantDark', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);

  Color ewoutlinevariant(BuildContext context) => _routeAndResolve('ewoutlinevariant', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);
  Color ewoutlinevariantLight(BuildContext context) => _routeAndResolve('ewoutlinevariantLight', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);
  Color ewoutlinevariantDark(BuildContext context) => _routeAndResolve('ewoutlinevariantDark', EOutlineVariantLight.getToken, EOutlineVariantDark.getToken, context);

  Color eerprimary(BuildContext context) {
    return _routeAndResolve('eerprimary', EErprimaryLight.getToken, EErprimaryDark.getToken, context);
  }
  Color eerprimaryLight(BuildContext context) => _resolveToken(EErprimaryLight.getToken(currentTheme), context, false);
  Color eerprimaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eerprimary')) return _amoledOverrides['eerprimary']!;
    return _resolveToken(EErprimaryDark.getToken(currentTheme), context, true);
  }

  Color eaerprimary(BuildContext context) => _routeAndResolve('eaerprimary', EErprimaryLight.getToken, EErprimaryDark.getToken, context);
  Color eaerprimaryLight(BuildContext context) => _routeAndResolve('eaerprimaryLight', EErprimaryLight.getToken, EErprimaryDark.getToken, context);
  Color eaerprimaryDark(BuildContext context) => _routeAndResolve('eaerprimaryDark', EErprimaryLight.getToken, EErprimaryDark.getToken, context);

  Color ewerprimary(BuildContext context) => _routeAndResolve('ewerprimary', EErprimaryLight.getToken, EErprimaryDark.getToken, context);
  Color ewerprimaryLight(BuildContext context) => _routeAndResolve('ewerprimaryLight', EErprimaryLight.getToken, EErprimaryDark.getToken, context);
  Color ewerprimaryDark(BuildContext context) => _routeAndResolve('ewerprimaryDark', EErprimaryLight.getToken, EErprimaryDark.getToken, context);

  Color eeronprimary(BuildContext context) {
    return _routeAndResolve('eeronprimary', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);
  }
  Color eeronprimaryLight(BuildContext context) => _resolveToken(EEronprimaryLight.getToken(currentTheme), context, false);
  Color eeronprimaryDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eeronprimary')) return _amoledOverrides['eeronprimary']!;
    return _resolveToken(EEronprimaryDark.getToken(currentTheme), context, true);
  }

  Color eaeronprimary(BuildContext context) => _routeAndResolve('eaeronprimary', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);
  Color eaeronprimaryLight(BuildContext context) => _routeAndResolve('eaeronprimaryLight', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);
  Color eaeronprimaryDark(BuildContext context) => _routeAndResolve('eaeronprimaryDark', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);

  Color eweronprimary(BuildContext context) => _routeAndResolve('eweronprimary', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);
  Color eweronprimaryLight(BuildContext context) => _routeAndResolve('eweronprimaryLight', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);
  Color eweronprimaryDark(BuildContext context) => _routeAndResolve('eweronprimaryDark', EEronprimaryLight.getToken, EEronprimaryDark.getToken, context);

  Color eerprimarycontainer(BuildContext context) {
    return _routeAndResolve('eerprimarycontainer', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);
  }
  Color eerprimarycontainerLight(BuildContext context) => _resolveToken(EErprimarycontainerLight.getToken(currentTheme), context, false);
  Color eerprimarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eerprimarycontainer')) return _amoledOverrides['eerprimarycontainer']!;
    return _resolveToken(EErprimarycontainerDark.getToken(currentTheme), context, true);
  }

  Color eaerprimarycontainer(BuildContext context) => _routeAndResolve('eaerprimarycontainer', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);
  Color eaerprimarycontainerLight(BuildContext context) => _routeAndResolve('eaerprimarycontainerLight', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);
  Color eaerprimarycontainerDark(BuildContext context) => _routeAndResolve('eaerprimarycontainerDark', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);

  Color ewerprimarycontainer(BuildContext context) => _routeAndResolve('ewerprimarycontainer', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);
  Color ewerprimarycontainerLight(BuildContext context) => _routeAndResolve('ewerprimarycontainerLight', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);
  Color ewerprimarycontainerDark(BuildContext context) => _routeAndResolve('ewerprimarycontainerDark', EErprimarycontainerLight.getToken, EErprimarycontainerDark.getToken, context);

  Color eeronprimarycontainer(BuildContext context) {
    return _routeAndResolve('eeronprimarycontainer', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
  }
  Color eeronprimarycontainerLight(BuildContext context) => _resolveToken(EEronprimarycontainerLight.getToken(currentTheme), context, false);
  Color eeronprimarycontainerDark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('eeronprimarycontainer')) return _amoledOverrides['eeronprimarycontainer']!;
    return _resolveToken(EEronprimarycontainerDark.getToken(currentTheme), context, true);
  }

  Color eaeronprimarycontainer(BuildContext context) => _routeAndResolve('eaeronprimarycontainer', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
  Color eaeronprimarycontainerLight(BuildContext context) => _routeAndResolve('eaeronprimarycontainerLight', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
  Color eaeronprimarycontainerDark(BuildContext context) => _routeAndResolve('eaeronprimarycontainerDark', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);

  Color eweronprimarycontainer(BuildContext context) => _routeAndResolve('eweronprimarycontainer', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
  Color eweronprimarycontainerLight(BuildContext context) => _routeAndResolve('eweronprimarycontainerLight', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
  Color eweronprimarycontainerDark(BuildContext context) => _routeAndResolve('eweronprimarycontainerDark', EEronprimarycontainerLight.getToken, EEronprimarycontainerDark.getToken, context);
}
