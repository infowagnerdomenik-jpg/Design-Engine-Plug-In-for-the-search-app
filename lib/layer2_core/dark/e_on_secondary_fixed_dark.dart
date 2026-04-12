import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSecondaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd31;
      case 'standard': return cstd31;
      case 'blue': return cbd31;
      case 'green': return cgd31;
      case 'red': return crd31;
      case 'nothing': return cnod31;
      default: return cstd31;
    }
  }
}
