import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnTertiaryFixedLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl39;
      case 'standard': return cstl39;
      case 'blue': return cbl39;
      case 'green': return cgl39;
      case 'red': return crl39;
      case 'nothing': return cnol39;
      default: return cstl39;
    }
  }
}
