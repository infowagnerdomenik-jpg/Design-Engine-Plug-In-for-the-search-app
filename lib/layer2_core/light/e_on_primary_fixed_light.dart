import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnPrimaryFixedLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl22;
      case 'standard': return cstl22;
      case 'blue': return cbl22;
      case 'green': return cgl22;
      case 'red': return crl22;
      case 'nothing': return cnol22;
      default: return cstl22;
    }
  }
}
