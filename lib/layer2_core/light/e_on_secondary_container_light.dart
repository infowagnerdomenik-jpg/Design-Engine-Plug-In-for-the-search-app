import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnSecondaryContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl28;
      case 'standard': return cstl28;
      case 'blue': return cbl28;
      case 'green': return cgl28;
      case 'red': return crl28;
      case 'nothing': return cnol28;
      default: return cstl28;
    }
  }
}
