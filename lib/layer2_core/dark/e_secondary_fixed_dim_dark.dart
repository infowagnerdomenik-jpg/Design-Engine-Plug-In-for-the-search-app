import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESecondaryFixedDimDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd30;
      case 'standard': return cstd30;
      case 'blue': return cbd30;
      case 'green': return cgd30;
      case 'red': return crd30;
      case 'nothing': return cnod30;
      default: return cstd30;
    }
  }
}
