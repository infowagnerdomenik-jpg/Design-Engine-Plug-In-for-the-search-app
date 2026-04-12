import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EInverseOnSurfaceLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl8;
      case 'standard': return cstl8;
      case 'blue': return cbl8;
      case 'green': return cgl8;
      case 'red': return crl8;
      case 'nothing': return cnol8;
      default: return cstl8;
    }
  }
}
