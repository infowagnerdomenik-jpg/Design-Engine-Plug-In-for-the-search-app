import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOutlineVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl46;
      case 'standard': return cstl46;
      case 'blue': return cbl46;
      case 'green': return cgl46;
      case 'red': return crl46;
      case 'nothing': return cnol46;
      default: return cstl46;
    }
  }
}
