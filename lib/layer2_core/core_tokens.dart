import 'package:flutter/material.dart';

// Import all Layer 1 light variables
import '../layer1_raw/light/blue.dart';
import '../layer1_raw/light/green.dart';
import '../layer1_raw/light/red.dart';
import '../layer1_raw/light/standard.dart';
import '../layer1_raw/light/system.dart';
import '../layer1_raw/light/nothing.dart';

// Import all Layer 1 dark variables
import '../layer1_raw/dark/blue.dart';
import '../layer1_raw/dark/green.dart';
import '../layer1_raw/dark/red.dart';
import '../layer1_raw/dark/standard.dart';
import '../layer1_raw/dark/system.dart';
import '../layer1_raw/dark/nothing.dart';

enum AppTheme { system, standard, blue, green, red, nothing }
enum AppMode { light, dark, amoled }

/// Layer 2: Core Tokens
/// Bundles the raw variables from Layer 1 into a unified class structure.
class CoreThemeTokens {
  // Example semantic tokens. We map the 42 raw variables to semantic names.
  // For now, we will use a generic map or dedicated properties.
  // I need the specific semantic names you want to use (e.g., primary, background, textOnButton).
  
  final Color t1;
  final Color t2;
  // ... up to 42.

  const CoreThemeTokens({
    required this.t1,
    required this.t2,
    // ...
  });

  // Example factory for Blue Light
  factory CoreThemeTokens.blueLight() {
    return const CoreThemeTokens(
      t1: cbl1,
      t2: cbl2,
      // ...
    );
  }

  // Example factory for Blue Dark
  factory CoreThemeTokens.blueDark() {
    return const CoreThemeTokens(
      t1: cbd1,
      t2: cbd2,
      // ...
    );
  }
  
  // TODO: Add factories for all other themes.
}
