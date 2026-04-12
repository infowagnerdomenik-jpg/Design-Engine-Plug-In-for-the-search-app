import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EInversePrimaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd24;
      case 'standard': return cstd24;
      case 'blue': return cbd24;
      case 'green': return cgd24;
      case 'red': return crd24;
      case 'nothing': return cnod24;
      default: return cstd24;
    }
  }
}
