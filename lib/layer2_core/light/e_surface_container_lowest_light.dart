import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceContainerLowestLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl13;
      case 'standard': return cstl13;
      case 'blue': return cbl13;
      case 'green': return cgl13;
      case 'red': return crl13;
      case 'nothing': return cnol13;
      default: return cstl13;
    }
  }
}
