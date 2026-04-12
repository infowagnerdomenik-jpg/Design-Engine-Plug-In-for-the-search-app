import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';

// --- DESIGN ENGINE IMPORTE (NEUES SDK) ---
import 'package:design_engine/layer3_logic/design_engine_controller.dart';
import 'package:design_engine/layer4_ui/design_engine_ui.dart';

// --- LOCALIZATION MOCK ---
class AppLocalizationsMock {
  String get(String key) {
    switch (key) {
      case 'theme_title': return 'Themen-Einstellungen';
      case 'color_selection': return 'Farbauswahl';
      case 'light_control': return 'Lichtsteuerung';
      case 'auto': return 'Auto';
      case 'day': return 'Day';
      case 'night': return 'Night';
      case 'preview': return 'Vorschau';
      default: return key;
    }
  }
}
class AppLocalizations {
  static AppLocalizationsMock of(BuildContext context) => AppLocalizationsMock();
}

class AndroidDebugView extends StatelessWidget {
  const AndroidDebugView({super.key});

  @override
  Widget build(BuildContext context) {
    final controller = Provider.of<DesignEngineController>(context);

    // === DESIGN ENGINE (Live Werte) ===
    final Color ebg = context.eabackground;          
    final Color esv = context.easurfacevariant;      
    final Color ep = context.eaprimary;              
    final Color eonbg = context.eaonbackground;      
    final Color eonsv = context.eaonsurfacevariant; 

    final bool isDark = controller.isEffectiveDark(context);
    
    return Scaffold(
      backgroundColor: ebg,
      extendBody: true, // Navigationsleiste ignorieren
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        systemOverlayStyle: SystemUiOverlayStyle(
          statusBarColor: Colors.transparent,
          statusBarIconBrightness: isDark ? Brightness.light : Brightness.dark,
          statusBarBrightness: isDark ? Brightness.dark : Brightness.light,
        ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          color: eonbg,
          onPressed: () => Navigator.of(context).pop(),
        ),
        title: Text(
          "Android Debug View (Read-Only)",
          style: TextStyle(color: eonbg, fontSize: 20, fontWeight: FontWeight.normal),
        ),
      ),
      body: LayoutBuilder(
        builder: (context, constraints) {
          final bool isLandscape = constraints.maxWidth > 600 && constraints.maxHeight < constraints.maxWidth;

          if (isLandscape) {
            return Row(
              children: [
                Expanded(
                  flex: 4,
                  child: Center(
                    child: SingleChildScrollView(
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
                        child: _ThemePreviewCard(
                          accentColor: ep,
                          backgroundColor: ebg,
                          surfaceColor: esv,
                          textColor: eonbg,
                          borderColor: eonbg,
                        ),
                      ),
                    ),
                  ),
                ),
                Expanded(
                  flex: 6,
                  child: _SettingsPanel(
                    isLandscape: true,
                    esv: esv,
                    ep: ep,
                    eonbg: eonbg,
                    eonsv: eonsv,
                    isDark: isDark,
                  ),
                ),
              ],
            );
          } else {
            return Column(
              children: [
                Expanded(
                  flex: 4,
                  child: Center(
                    child: _ThemePreviewCard(
                      accentColor: ep,
                      backgroundColor: ebg,
                      surfaceColor: esv,
                      textColor: eonbg,
                      borderColor: eonbg,
                    ),
                  ),
                ),
                Expanded(
                  flex: 6,
                  child: _SettingsPanel(
                    isLandscape: false,
                    esv: esv,
                    ep: ep,
                    eonbg: eonbg,
                    eonsv: eonsv,
                    isDark: isDark,
                  ),
                ),
              ],
            );
          }
        },
      ),
    );
  }
}

class _SettingsPanel extends StatelessWidget {
  final bool isLandscape;
  final Color esv;
  final Color ep;
  final Color eonbg;
  final Color eonsv;
  final bool isDark;

  const _SettingsPanel({
    required this.isLandscape,
    required this.esv,
    required this.ep,
    required this.eonbg,
    required this.eonsv,
    required this.isDark,
  });

  @override
  Widget build(BuildContext context) {
    final controller = Provider.of<DesignEngineController>(context);
    final List<AppTheme> sortedThemes = [
      AppTheme.system,
      AppTheme.standard,
      AppTheme.blue,
      AppTheme.green,
      AppTheme.red,
      AppTheme.nothing
    ];

    return Container(
      width: double.infinity,
      decoration: BoxDecoration(
        color: esv,
        borderRadius: isLandscape
            ? const BorderRadius.only(topLeft: Radius.circular(24), bottomLeft: Radius.circular(24))
            : const BorderRadius.only(topLeft: Radius.circular(24), topRight: Radius.circular(24)),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 10,
            offset: isLandscape ? const Offset(-2, 0) : const Offset(0, -2),
          )
        ],
      ),
      child: SingleChildScrollView(
        padding: EdgeInsets.symmetric(vertical: isLandscape ? 12.0 : 24.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24.0),
              child: Text(
                AppLocalizations.of(context).get('color_selection'),
                style: TextStyle(color: eonbg, fontSize: 18, fontWeight: FontWeight.bold),
              ),
            ),
            const SizedBox(height: 20),
            SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              padding: const EdgeInsets.symmetric(horizontal: 12),
              child: Row(
                children: sortedThemes.map((theme) {
                  return _buildColorCircle(
                    label: theme.name[0].toUpperCase() + theme.name.substring(1),
                    color: controller.eaprimaryForTheme(theme, context),
                    textColor: eonsv,
                    selectionColor: ep,
                    isSelected: controller.androidTheme == theme,
                    onTap: () {}, // Read-only
                  );
                }).toList(),
              ),
            ),
            const SizedBox(height: 32),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24.0),
              child: Divider(color: eonbg.withOpacity(0.1), height: 1),
            ),
            const SizedBox(height: 20),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24.0),
              child: Text(
                AppLocalizations.of(context).get('light_control'),
                style: TextStyle(color: eonbg, fontSize: 18, fontWeight: FontWeight.bold),
              ),
            ),
            const SizedBox(height: 20),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 12.0),
              child: Row(
                children: [
                  _buildLightModeCircle(
                    AppLocalizations.of(context).get('auto'),
                    isSelected: controller.androidThemeMode == ThemeMode.system,
                    isSplit: true,
                    fillColorLight: context.eaprimaryDark,
                    fillColorDark: context.eaprimaryLight,
                    textColor: eonsv,
                    selectionColor: ep,
                    onTap: () {}, // Read-only
                  ),
                  _buildLightModeCircle(
                    AppLocalizations.of(context).get('day'),
                    isSelected: controller.androidThemeMode == ThemeMode.light,
                    isSplit: false,
                    fillColorLight: context.eaprimaryDark,
                    fillColorDark: context.eaprimaryDark,
                    textColor: eonsv,
                    selectionColor: ep,
                    onTap: () {}, // Read-only
                  ),
                  _buildLightModeCircle(
                    AppLocalizations.of(context).get('night'),
                    isSelected: controller.androidThemeMode == ThemeMode.dark,
                    isSplit: false,
                    fillColorLight: context.eaprimaryLight,
                    fillColorDark: context.eaprimaryLight,
                    textColor: eonsv,
                    selectionColor: ep,
                    onTap: () {}, // Read-only
                  ),
                ],
              ),
            ),
            if (isDark) ...[
              const SizedBox(height: 32),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24.0),
                child: Container(
                  padding: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: eonbg.withOpacity(0.05),
                    borderRadius: BorderRadius.circular(16),
                    border: Border.all(color: eonbg.withOpacity(0.1)),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            "Extra Dark Modus",
                            style: TextStyle(color: eonbg, fontSize: 16, fontWeight: FontWeight.w600),
                          ),
                          Text(
                            "Optimiert für AMOLED Displays",
                            style: TextStyle(color: eonsv, fontSize: 12),
                          ),
                        ],
                      ),
                      Switch(
                        value: controller.androidIsAmoled,
                        onChanged: null, // Read-only
                        activeColor: Colors.white,
                        activeTrackColor: ep,
                        inactiveThumbColor: Colors.grey,
                        inactiveTrackColor: eonbg.withOpacity(0.1),
                      ),
                    ],
                  ),
                ),
              ),
            ],
            const SizedBox(height: 48),
          ],
        ),
      ),
    );
  }

  Widget _buildColorCircle({
    required String label,
    required Color color,
    required bool isSelected,
    required Color textColor,
    required Color selectionColor,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      onTap: onTap,
      child: SizedBox(
        width: 90,
        child: Column(
          children: [
            Stack(
              alignment: Alignment.center,
              children: [
                if (isSelected)
                  Container(
                    width: 64,
                    height: 64,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      border: Border.all(color: selectionColor, width: 2.5),
                    ),
                  ),
                Container(
                  width: 50,
                  height: 50,
                  decoration: BoxDecoration(
                    color: color,
                    shape: BoxShape.circle,
                    border: Border.all(color: Colors.black.withOpacity(0.1), width: 1),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),
            Text(
              label,
              textAlign: TextAlign.center,
              style: TextStyle(color: textColor, fontSize: 12),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildLightModeCircle(
    String label, {
    required bool isSelected,
    required bool isSplit,
    required Color fillColorLight,
    required Color fillColorDark,
    required Color textColor,
    required Color selectionColor,
    required VoidCallback onTap,
  }) {
    return GestureDetector(
      onTap: onTap,
      child: SizedBox(
        width: 90,
        child: Column(
          children: [
            Stack(
              alignment: Alignment.center,
              children: [
                if (isSelected)
                  Container(
                    width: 64,
                    height: 64,
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      border: Border.all(color: selectionColor, width: 2.5),
                    ),
                  ),
                Container(
                  width: 50,
                  height: 50,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    gradient: isSplit
                        ? LinearGradient(
                            begin: Alignment.centerLeft,
                            end: Alignment.centerRight,
                            colors: [fillColorLight, fillColorLight, fillColorDark, fillColorDark],
                            stops: const [0.0, 0.5, 0.5, 1.0],
                          )
                        : null,
                    color: isSplit ? null : fillColorLight,
                    border: Border.all(color: Colors.black.withOpacity(0.1), width: 1),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),
            Text(
              label,
              textAlign: TextAlign.center,
              style: TextStyle(color: textColor, fontSize: 12),
            ),
          ],
        ),
      ),
    );
  }
}

class _ThemePreviewCard extends StatelessWidget {
  final Color accentColor;
  final Color backgroundColor;
  final Color surfaceColor;
  final Color textColor;
  final Color borderColor;

  const _ThemePreviewCard({
    required this.accentColor,
    required this.backgroundColor,
    required this.surfaceColor,
    required this.textColor,
    required this.borderColor,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 280,
      height: 180,
      decoration: BoxDecoration(
          color: backgroundColor,
          borderRadius: BorderRadius.circular(24),
          border: Border.all(color: borderColor.withOpacity(0.1), width: 1),
          boxShadow: [
            BoxShadow(
                color: Colors.black.withOpacity(0.05),
                blurRadius: 15,
                offset: const Offset(0, 5)
            )
          ]
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Container(
            width: 56,
            height: 56,
            decoration: BoxDecoration(
              color: accentColor,
              borderRadius: BorderRadius.circular(16),
            ),
          ),
          const SizedBox(height: 20),
          Text(
            "Vorschau",
            style: TextStyle(color: textColor, fontSize: 22, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 20),
          Container(
            width: 140,
            height: 10,
            decoration: BoxDecoration(
              color: surfaceColor,
              borderRadius: BorderRadius.circular(10),
            ),
          ),
        ],
      ),
    );
  }
}
