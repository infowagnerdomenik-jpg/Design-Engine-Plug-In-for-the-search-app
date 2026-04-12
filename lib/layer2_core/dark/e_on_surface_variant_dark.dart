import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSurfaceVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd6;
      case 'standard': return cstd6;
      case 'blue': return cbd6;
      case 'green': return cgd6;
      case 'red': return crd6;
      case 'nothing': return cnod6;
      default: return cstd6;
    }
  }
}
