import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceDimLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl10;
      case 'standard': return cstl10;
      case 'blue': return cbl10;
      case 'green': return cgl10;
      case 'red': return crl10;
      case 'nothing': return cnol10;
      default: return cstl10;
    }
  }
}
