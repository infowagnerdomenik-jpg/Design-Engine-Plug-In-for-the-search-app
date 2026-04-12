import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ETertiaryContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd35;
      case 'standard': return cstd35;
      case 'blue': return cbd35;
      case 'green': return cgd35;
      case 'red': return crd35;
      case 'nothing': return cnod35;
      default: return cstd35;
    }
  }
}
