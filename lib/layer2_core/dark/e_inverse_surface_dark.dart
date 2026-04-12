import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EInverseSurfaceDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd7;
      case 'standard': return cstd7;
      case 'blue': return cbd7;
      case 'green': return cgd7;
      case 'red': return crd7;
      case 'nothing': return cnod7;
      default: return cstd7;
    }
  }
}
