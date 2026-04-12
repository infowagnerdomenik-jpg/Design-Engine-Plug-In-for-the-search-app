import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnTertiaryFixedVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl40;
      case 'standard': return cstl40;
      case 'blue': return cbl40;
      case 'green': return cgl40;
      case 'red': return crl40;
      case 'nothing': return cnol40;
      default: return cstl40;
    }
  }
}
