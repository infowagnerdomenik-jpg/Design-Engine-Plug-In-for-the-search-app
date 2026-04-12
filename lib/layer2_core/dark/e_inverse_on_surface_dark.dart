import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EInverseOnSurfaceDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd8;
      case 'standard': return cstd8;
      case 'blue': return cbd8;
      case 'green': return cgd8;
      case 'red': return crd8;
      case 'nothing': return cnod8;
      default: return cstd8;
    }
  }
}
