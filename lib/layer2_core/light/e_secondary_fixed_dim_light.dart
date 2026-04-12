import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESecondaryFixedDimLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl30;
      case 'standard': return cstl30;
      case 'blue': return cbl30;
      case 'green': return cgl30;
      case 'red': return crl30;
      case 'nothing': return cnol30;
      default: return cstl30;
    }
  }
}
