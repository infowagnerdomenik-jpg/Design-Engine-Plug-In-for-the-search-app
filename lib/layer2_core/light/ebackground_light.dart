import 'package:flutter/material.dart';

// Import RAW Light Values
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

import '../../layer3_logic/design_engine_controller.dart'; // Für AppTheme enum

/// Layer 2: Core Tokens - eBackground (Light Mode)
/// Mappt das gewählte Theme auf die entsprechende Konstante aus Schicht 1.
class EBackgroundLight {
  static Color getColor(AppTheme activeTheme) {
    switch (activeTheme) {
      case AppTheme.system:
        return csyl1;
      case AppTheme.standard:
        return cstl1;
      case AppTheme.blue:
        return cbl1;
      case AppTheme.green:
        return cgl1;
      case AppTheme.red:
        return crl1;
      case AppTheme.nothing:
        return cnol1;
    }
  }
}
