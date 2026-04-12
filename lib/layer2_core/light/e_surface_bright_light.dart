import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceBrightLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl9;
      case 'standard': return cstl9;
      case 'blue': return cbl9;
      case 'green': return cgl9;
      case 'red': return crl9;
      case 'nothing': return cnol9;
      default: return cstl9;
    }
  }
}
