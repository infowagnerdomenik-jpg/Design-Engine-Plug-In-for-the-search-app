import 'package:flutter/services.dart';
import 'package:flutter/material.dart';

class NativeBridge {
  static const MethodChannel _channel = MethodChannel('design_engine');
  static Map<String, Color> _cachedSystemColors = {};
  static bool _isLoaded = false;

  /// Ruft die System_Neutral Farben nativ aus Android ab und speichert sie im Cache.
  /// Muss idealerweise beim App-Start (z.B. in main()) einmalig aufgerufen werden.
  static Future<void> loadSystemColors() async {
    if (_isLoaded) return;
    try {
      final Map<dynamic, dynamic>? result = await _channel.invokeMapMethod<String, String>('getSystemNeutralColors');
      if (result != null) {
        result.forEach((key, value) {
          // Konvertiert den Hex-String (#AARRGGBB) in eine Flutter Color
          String hex = value.toString().replaceAll('#', '');
          if (hex.length == 8) {
            _cachedSystemColors[key] = Color(int.parse('0x$hex'));
          }
        });
        _isLoaded = true;
      }
    } catch (e) {
      debugPrint('Fehler beim Laden der Native Colors: $e');
    }
  }

  /// Holt eine Farbe synchron aus dem Cache.
  /// Gibt die [fallback] Farbe zurück, falls der Cache leer ist (z.B. nicht Android 12+).
  static Color getSystemNeutral(String name, Color fallback) {
    return _cachedSystemColors[name] ?? fallback;
  }
}
