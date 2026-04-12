import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceContainerHighestDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd14;
      case 'standard': return cstd14;
      case 'blue': return cbd14;
      case 'green': return cgd14;
      case 'red': return crd14;
      case 'nothing': return cnod14;
      default: return cstd14;
    }
  }
}
