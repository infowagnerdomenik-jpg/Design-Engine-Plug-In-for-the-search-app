import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ETertiaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd37;
      case 'standard': return cstd37;
      case 'blue': return cbd37;
      case 'green': return cgd37;
      case 'red': return crd37;
      case 'nothing': return cnod37;
      default: return cstd37;
    }
  }
}
