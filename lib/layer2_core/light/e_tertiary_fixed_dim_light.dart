import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ETertiaryFixedDimLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl38;
      case 'standard': return cstl38;
      case 'blue': return cbl38;
      case 'green': return cgl38;
      case 'red': return crl38;
      case 'nothing': return cnol38;
      default: return cstl38;
    }
  }
}
