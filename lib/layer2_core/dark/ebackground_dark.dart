import 'package:flutter/material.dart';

// Import RAW Dark Values
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

import '../../layer3_logic/design_engine_controller.dart'; // Für AppTheme enum

/// Layer 2: Core Tokens - eBackground (Dark Mode)
/// Mappt das gewählte Theme auf die entsprechende Konstante aus Schicht 1.
class EBackgroundDark {
  static Color getColor(AppTheme activeTheme) {
    switch (activeTheme) {
      case AppTheme.system:
        return csyd1;
      case AppTheme.standard:
        return cstd1;
      case AppTheme.blue:
        return cbd1;
      case AppTheme.green:
        return cgd1;
      case AppTheme.red:
        return crd1;
      case AppTheme.nothing:
        return cnod1;
    }
  }
}
