import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EPrimaryFixedLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl20;
      case 'standard': return cstl20;
      case 'blue': return cbl20;
      case 'green': return cgl20;
      case 'red': return crl20;
      case 'nothing': return cnol20;
      default: return cstl20;
    }
  }
}
