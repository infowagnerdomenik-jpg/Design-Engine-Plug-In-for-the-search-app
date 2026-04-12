import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnPrimaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl17;
      case 'standard': return cstl17;
      case 'blue': return cbl17;
      case 'green': return cgl17;
      case 'red': return crl17;
      case 'nothing': return cnol17;
      default: return cstl17;
    }
  }
}
