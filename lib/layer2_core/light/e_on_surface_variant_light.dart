import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnSurfaceVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl6;
      case 'standard': return cstl6;
      case 'blue': return cbl6;
      case 'green': return cgl6;
      case 'red': return crl6;
      case 'nothing': return cnol6;
      default: return cstl6;
    }
  }
}
