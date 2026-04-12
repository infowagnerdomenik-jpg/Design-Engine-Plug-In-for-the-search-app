import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EPrimaryContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl18;
      case 'standard': return cstl18;
      case 'blue': return cbl18;
      case 'green': return cgl18;
      case 'red': return crl18;
      case 'nothing': return cnol18;
      default: return cstl18;
    }
  }
}
