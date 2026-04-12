import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnTertiaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd39;
      case 'standard': return cstd39;
      case 'blue': return cbd39;
      case 'green': return cgd39;
      case 'red': return crd39;
      case 'nothing': return cnod39;
      default: return cstd39;
    }
  }
}
