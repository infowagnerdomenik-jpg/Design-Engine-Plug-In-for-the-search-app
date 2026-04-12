import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnPrimaryFixedVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd23;
      case 'standard': return cstd23;
      case 'blue': return cbd23;
      case 'green': return cgd23;
      case 'red': return crd23;
      case 'nothing': return cnod23;
      default: return cstd23;
    }
  }
}
