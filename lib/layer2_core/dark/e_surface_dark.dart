import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd3;
      case 'standard': return cstd3;
      case 'blue': return cbd3;
      case 'green': return cgd3;
      case 'red': return crd3;
      case 'nothing': return cnod3;
      default: return cstd3;
    }
  }
}
