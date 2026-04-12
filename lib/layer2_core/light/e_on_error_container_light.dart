import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnErrorContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl44;
      case 'standard': return cstl44;
      case 'blue': return cbl44;
      case 'green': return cgl44;
      case 'red': return crl44;
      case 'nothing': return cnol44;
      default: return cstl44;
    }
  }
}
