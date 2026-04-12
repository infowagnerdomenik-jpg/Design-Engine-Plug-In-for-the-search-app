import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESecondaryFixedLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl29;
      case 'standard': return cstl29;
      case 'blue': return cbl29;
      case 'green': return cgl29;
      case 'red': return crl29;
      case 'nothing': return cnol29;
      default: return cstl29;
    }
  }
}
