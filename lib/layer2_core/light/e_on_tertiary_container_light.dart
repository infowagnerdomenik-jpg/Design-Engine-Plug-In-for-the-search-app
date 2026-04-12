import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnTertiaryContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl36;
      case 'standard': return cstl36;
      case 'blue': return cbl36;
      case 'green': return cgl36;
      case 'red': return crl36;
      case 'nothing': return cnol36;
      default: return cstl36;
    }
  }
}
