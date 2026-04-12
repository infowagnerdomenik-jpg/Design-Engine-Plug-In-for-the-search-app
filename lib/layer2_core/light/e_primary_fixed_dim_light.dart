import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EPrimaryFixedDimLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl21;
      case 'standard': return cstl21;
      case 'blue': return cbl21;
      case 'green': return cgl21;
      case 'red': return crl21;
      case 'nothing': return cnol21;
      default: return cstl21;
    }
  }
}
