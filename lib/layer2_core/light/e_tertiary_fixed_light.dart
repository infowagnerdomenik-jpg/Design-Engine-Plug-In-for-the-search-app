import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ETertiaryFixedLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl37;
      case 'standard': return cstl37;
      case 'blue': return cbl37;
      case 'green': return cgl37;
      case 'red': return crl37;
      case 'nothing': return cnol37;
      default: return cstl37;
    }
  }
}
