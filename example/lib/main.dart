import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'package:design_engine/layer3_logic/design_engine_controller.dart';
import 'package:design_engine_example/ui/flutter_engine/theme_settings_screen.dart';
import 'package:design_engine_example/ui/flutter_engine/debug/android_debug_view.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  // Initialisiert die Engine (lädt z.B. Systemfarben)
  await DesignEngineController().init();
  
  runApp(
    ChangeNotifierProvider.value(
      value: DesignEngineController(),
      child: const ShowcaseApp(),
    ),
  );
}

class ShowcaseApp extends StatelessWidget {
  const ShowcaseApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Design Engine Showcase',
      theme: ThemeData.light(),
      darkTheme: ThemeData.dark(),
      themeMode: ThemeMode.system,
      home: const MainScreen(),
    );
  }
}

class MainScreen extends StatelessWidget {
  const MainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Design Engine - Dual SDK'),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton.icon(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const ThemeSettingsScreen()),
                );
              },
              icon: const Icon(Icons.flutter_dash),
              label: const Text('Flutter Engine'),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
                textStyle: const TextStyle(fontSize: 18),
              ),
            ),
            const SizedBox(height: 24),
            ElevatedButton.icon(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const AndroidDebugView()),
                );
              },
              icon: const Icon(Icons.bug_report),
              label: const Text('Android Debug View'),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
                textStyle: const TextStyle(fontSize: 18),
                backgroundColor: Colors.orange.shade700,
                foregroundColor: Colors.white,
              ),
            ),
            const SizedBox(height: 24),
            ElevatedButton.icon(
              onPressed: () async {
                const platform = MethodChannel('design_engine_showcase');
                try {
                  await platform.invokeMethod('openFlutterDebug');
                } catch (e) {
                  debugPrint("Fehler beim Öffnen des Flutter Debug Views: $e");
                }
              },
              icon: const Icon(Icons.bug_report),
              label: const Text('Flutter Debug View (Native)'),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
                textStyle: const TextStyle(fontSize: 18),
                backgroundColor: Colors.blue.shade700,
                foregroundColor: Colors.white,
              ),
            ),
            const SizedBox(height: 24),
            ElevatedButton.icon(
              onPressed: () async {
                const platform = MethodChannel('design_engine_showcase');
                try {
                  await platform.invokeMethod('openAndroidEngine');
                } catch (e) {
                  debugPrint("Fehler beim Öffnen der Android Engine: $e");
                }
              },
              icon: const Icon(Icons.android),
              label: const Text('Android Engine'),
              style: ElevatedButton.styleFrom(
                padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
                textStyle: const TextStyle(fontSize: 18),
                backgroundColor: Colors.green.shade700,
                foregroundColor: Colors.white,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
