import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnSecondaryFixedVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl32;
      case 'standard': return cstl32;
      case 'blue': return cbl32;
      case 'green': return cgl32;
      case 'red': return crl32;
      case 'nothing': return cnol32;
      default: return cstl32;
    }
  }
}
