import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EPrimaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd16;
      case 'standard': return cstd16;
      case 'blue': return cbd16;
      case 'green': return cgd16;
      case 'red': return crd16;
      case 'nothing': return cnod16;
      default: return cstd16;
    }
  }
}
