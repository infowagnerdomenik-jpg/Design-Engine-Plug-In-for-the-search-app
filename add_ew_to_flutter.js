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

function formatFileName(token, suffix) {
    return "e_" + token.toLowerCase().replace(/ /g, "_") + "_" + suffix + ".dart";
}

function formatGetterName(token) {
    return "e" + token.toLowerCase().replace(/ /g, "");
}

const controllerPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/lib/layer3_logic/design_engine_controller.dart";

let content = `import 'package:flutter/material.dart';
import '../layer1_raw/design_token.dart';
import 'package:dynamic_color/dynamic_color.dart';
import 'package:material_color_utilities/material_color_utilities.dart';
import 'package:flutter/services.dart';

`;

tokens.forEach(token => {
    content += `import '../layer2_core/light/${formatFileName(token, 'light')}';\n`;
    content += `import '../layer2_core/dark/${formatFileName(token, 'dark')}';\n`;
});

content += `
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
    _channel.setMethodCallHandler((call) async {
      if (call.method == 'syncAndroidToFlutter') {
        final args = call.arguments as Map<dynamic, dynamic>;
        if (args['theme'] != null) {
          androidTheme = AppTheme.values.firstWhere((e) => e.name.toUpperCase() == args['theme'].toString().toUpperCase());
        }
        if (args['mode'] != null) {
          androidThemeMode = ThemeMode.values.firstWhere((e) => e.name.toUpperCase() == args['mode'].toString().toUpperCase());
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

  void setTheme(AppTheme theme) {
    currentTheme = theme;
    _syncFlutterToAndroid();
    notifyListeners();
  }

  void setThemeMode(ThemeMode mode) {
    themeMode = mode;
    _syncFlutterToAndroid();
    notifyListeners();
  }

  void setAmoled(bool amoled) {
    isAmoled = amoled;
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
`;

tokens.forEach(token => {
    const g = formatGetterName(token);
    const ea = "ea" + g.substring(1);
    const ew = "ew" + g.substring(1);
    const cl = getFullClassName(token, 'light');
    const cd = getFullClassName(token, 'dark');
    
    content += `
  Color ${g}(BuildContext context) {
    return _routeAndResolve('${g}', ${cl}.getToken, ${cd}.getToken, context);
  }
  Color ${g}Light(BuildContext context) => _resolveToken(${cl}.getToken(currentTheme), context, false);
  Color ${g}Dark(BuildContext context) {
    if (isAmoled && _amoledOverrides.containsKey('${g}')) return _amoledOverrides['${g}']!;
    return _resolveToken(${cd}.getToken(currentTheme), context, true);
  }

  Color ${ea}(BuildContext context) => _routeAndResolve('${ea}', ${cl}.getToken, ${cd}.getToken, context);
  Color ${ea}Light(BuildContext context) => _routeAndResolve('${ea}Light', ${cl}.getToken, ${cd}.getToken, context);
  Color ${ea}Dark(BuildContext context) => _routeAndResolve('${ea}Dark', ${cl}.getToken, ${cd}.getToken, context);

  Color ${ew}(BuildContext context) => _routeAndResolve('${ew}', ${cl}.getToken, ${cd}.getToken, context);
  Color ${ew}Light(BuildContext context) => _routeAndResolve('${ew}Light', ${cl}.getToken, ${cd}.getToken, context);
  Color ${ew}Dark(BuildContext context) => _routeAndResolve('${ew}Dark', ${cl}.getToken, ${cd}.getToken, context);
`;
});

content += "}\n";
fs.writeFileSync(controllerPath, content);

// --- UI LAYER ---
const uiPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/lib/layer4_ui/design_engine_ui.dart";
let uiContent = `import 'package:flutter/material.dart';
import '../layer3_logic/design_engine_controller.dart';

extension DesignEngineContext on BuildContext {
`;

tokens.forEach(token => {
    const g = formatGetterName(token);
    const ea = "ea" + g.substring(1);
    const ew = "ew" + g.substring(1);
    
    uiContent += `  Color get ${g} => DesignEngineController().${g}(this);\n`;
    uiContent += `  Color get ${g}Light => DesignEngineController().${g}Light(this);\n`;
    uiContent += `  Color get ${g}Dark => DesignEngineController().${g}Dark(this);\n`;

    uiContent += `  Color get ${ea} => DesignEngineController().${ea}(this);\n`;
    uiContent += `  Color get ${ea}Light => DesignEngineController().${ea}Light(this);\n`;
    uiContent += `  Color get ${ea}Dark => DesignEngineController().${ea}Dark(this);\n`;

    uiContent += `  Color get ${ew} => DesignEngineController().${ew}(this);\n`;
    uiContent += `  Color get ${ew}Light => DesignEngineController().${ew}Light(this);\n`;
    uiContent += `  Color get ${ew}Dark => DesignEngineController().${ew}Dark(this);\n`;
});

uiContent += "}\n";
fs.writeFileSync(uiPath, uiContent);

console.log("Flutter EW functions added successfully.");
