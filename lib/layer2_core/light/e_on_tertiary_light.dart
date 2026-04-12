import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnTertiaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl34;
      case 'standard': return cstl34;
      case 'blue': return cbl34;
      case 'green': return cgl34;
      case 'red': return crl34;
      case 'nothing': return cnol34;
      default: return cstl34;
    }
  }
}
