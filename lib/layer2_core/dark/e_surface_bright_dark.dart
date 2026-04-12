import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceBrightDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd9;
      case 'standard': return cstd9;
      case 'blue': return cbd9;
      case 'green': return cgd9;
      case 'red': return crd9;
      case 'nothing': return cnod9;
      default: return cstd9;
    }
  }
}
