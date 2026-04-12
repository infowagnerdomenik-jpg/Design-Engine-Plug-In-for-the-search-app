import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ETertiaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl33;
      case 'standard': return cstl33;
      case 'blue': return cbl33;
      case 'green': return cgl33;
      case 'red': return crl33;
      case 'nothing': return cnol33;
      default: return cstl33;
    }
  }
}
