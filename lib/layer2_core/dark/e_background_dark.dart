import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EBackgroundDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd1;
      case 'standard': return cstd1;
      case 'blue': return cbd1;
      case 'green': return cgd1;
      case 'red': return crd1;
      case 'nothing': return cnod1;
      default: return cstd1;
    }
  }
}
