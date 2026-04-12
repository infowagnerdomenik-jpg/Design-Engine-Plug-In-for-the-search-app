import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnBackgroundLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl2;
      case 'standard': return cstl2;
      case 'blue': return cbl2;
      case 'green': return cgl2;
      case 'red': return crl2;
      case 'nothing': return cnol2;
      default: return cstl2;
    }
  }
}
