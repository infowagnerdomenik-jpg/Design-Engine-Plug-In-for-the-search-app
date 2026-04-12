import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl15;
      case 'standard': return cstl15;
      case 'blue': return cbl15;
      case 'green': return cgl15;
      case 'red': return crl15;
      case 'nothing': return cnol15;
      default: return cstl15;
    }
  }
}
