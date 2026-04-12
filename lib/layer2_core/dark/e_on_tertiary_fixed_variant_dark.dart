import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnTertiaryFixedVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd40;
      case 'standard': return cstd40;
      case 'blue': return cbd40;
      case 'green': return cgd40;
      case 'red': return crd40;
      case 'nothing': return cnod40;
      default: return cstd40;
    }
  }
}
