import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceContainerLowLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl11;
      case 'standard': return cstl11;
      case 'blue': return cbl11;
      case 'green': return cgl11;
      case 'red': return crl11;
      case 'nothing': return cnol11;
      default: return cstl11;
    }
  }
}
