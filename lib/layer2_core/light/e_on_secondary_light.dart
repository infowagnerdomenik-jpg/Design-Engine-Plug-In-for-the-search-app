import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnSecondaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl26;
      case 'standard': return cstl26;
      case 'blue': return cbl26;
      case 'green': return cgl26;
      case 'red': return crl26;
      case 'nothing': return cnol26;
      default: return cstl26;
    }
  }
}
