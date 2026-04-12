import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EInversePrimaryLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl24;
      case 'standard': return cstl24;
      case 'blue': return cbl24;
      case 'green': return cgl24;
      case 'red': return crl24;
      case 'nothing': return cnol24;
      default: return cstl24;
    }
  }
}
