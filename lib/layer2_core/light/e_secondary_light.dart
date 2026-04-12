import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESecondaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl25;
      case 'standard': return cstl25;
      case 'blue': return cbl25;
      case 'green': return cgl25;
      case 'red': return crl25;
      case 'nothing': return cnol25;
      default: return cstl25;
    }
  }
}
