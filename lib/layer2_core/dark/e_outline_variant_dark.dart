import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOutlineVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd46;
      case 'standard': return cstd46;
      case 'blue': return cbd46;
      case 'green': return cgd46;
      case 'red': return crd46;
      case 'nothing': return cnod46;
      default: return cstd46;
    }
  }
}
