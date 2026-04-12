import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOutlineLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl45;
      case 'standard': return cstl45;
      case 'blue': return cbl45;
      case 'green': return cgl45;
      case 'red': return crl45;
      case 'nothing': return cnol45;
      default: return cstl45;
    }
  }
}
