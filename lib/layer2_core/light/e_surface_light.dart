import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl3;
      case 'standard': return cstl3;
      case 'blue': return cbl3;
      case 'green': return cgl3;
      case 'red': return crl3;
      case 'nothing': return cnol3;
      default: return cstl3;
    }
  }
}
