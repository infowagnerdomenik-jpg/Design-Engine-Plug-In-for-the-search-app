import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EErprimaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl16;
      case 'standard': return cstl16;
      case 'blue': return cbl16;
      case 'green': return cgl16;
      case 'red': return crl16;
      case 'nothing': return cnol47;
      default: return cstl16;
    }
  }
}
