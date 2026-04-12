import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ETertiaryContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl35;
      case 'standard': return cstl35;
      case 'blue': return cbl35;
      case 'green': return cgl35;
      case 'red': return crl35;
      case 'nothing': return cnol35;
      default: return cstl35;
    }
  }
}
