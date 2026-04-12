import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EPrimaryFixedDimDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd21;
      case 'standard': return cstd21;
      case 'blue': return cbd21;
      case 'green': return cgd21;
      case 'red': return crd21;
      case 'nothing': return cnod21;
      default: return cstd21;
    }
  }
}
