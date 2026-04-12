import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceDimDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd10;
      case 'standard': return cstd10;
      case 'blue': return cbd10;
      case 'green': return cgd10;
      case 'red': return crd10;
      case 'nothing': return cnod10;
      default: return cstd10;
    }
  }
}
