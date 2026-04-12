import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESecondaryContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl27;
      case 'standard': return cstl27;
      case 'blue': return cbl27;
      case 'green': return cgl27;
      case 'red': return crl27;
      case 'nothing': return cnol27;
      default: return cstl27;
    }
  }
}
