import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EInverseSurfaceLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl7;
      case 'standard': return cstl7;
      case 'blue': return cbl7;
      case 'green': return cgl7;
      case 'red': return crl7;
      case 'nothing': return cnol7;
      default: return cstl7;
    }
  }
}
