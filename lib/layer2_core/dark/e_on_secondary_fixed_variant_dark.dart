import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSecondaryFixedVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd32;
      case 'standard': return cstd32;
      case 'blue': return cbd32;
      case 'green': return cgd32;
      case 'red': return crd32;
      case 'nothing': return cnod32;
      default: return cstd32;
    }
  }
}
